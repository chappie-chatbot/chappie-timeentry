package com.chg.hackdays.chappie.chappietimeentry.service;

import com.chg.connector.salesforce.rest.SalesforceRestClient;
import com.chg.hackdays.chappie.chappietimeentry.model.AssignmentInfo;
import com.chg.hackdays.chappie.chappietimeentry.model.AssignmentInformation;
import com.chg.hackdays.chappie.chappietimeentry.model.ProviderInfo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignmentInfoService {

  private static final Logger logger = LoggerFactory.getLogger(AssignmentInfoService.class);

  private static DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
  private static DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MM/dd/yyyy");

  @Autowired
  SalesforceRestClient sfRestClient;

  public ProviderInfo getProviderInfo(String providerNumber) throws Exception {
    ProviderInfo providerInfo = null;
    List<AssignmentInfo> assignmentInfos = Collections.emptyList();;
    assignmentInfos = getSalesforceData(providerNumber);
    if (CollectionUtils.isNotEmpty(assignmentInfos)) {
      providerInfo = new ProviderInfo();
      if (Objects.nonNull(assignmentInfos.get(0).getProviderFromAssignment().getFirstName())) {
        providerInfo
            .setFirstName(assignmentInfos.get(0).getProviderFromAssignment().getFirstName());
      }
      if (Objects.nonNull(assignmentInfos.get(0).getProviderFromAssignment().getLastName())) {
        providerInfo.setLastName(assignmentInfos.get(0).getProviderFromAssignment().getLastName());
      }
      if (Objects.nonNull(assignmentInfos.get(0).getProviderFromAssignment().getJdeNumber())) {
        providerInfo
            .setProviderNumber(assignmentInfos.get(0).getProviderFromAssignment().getJdeNumber());
      }
       List<AssignmentInformation> assignmentInformations = assignmentInfos
          .stream().map(assignmentInfo -> {
        AssignmentInformation assignmentInformation = new AssignmentInformation();

        if (Objects.nonNull(assignmentInfo.getAssignmentStartDate())
            && Objects.nonNull(assignmentInfo.getAssignmentEndDate())) {
          String start = assignmentInfo.getAssignmentStartDate();
          LocalDate startDate = LocalDate.parse(start, formatter1);
          assignmentInformation.setStartDate(startDate);
          String end = assignmentInfo.getAssignmentEndDate();
          LocalDate endDate = LocalDate.parse(end, formatter1);
          assignmentInformation.setEndDate(endDate);
          assignmentInformation.setAssignmentDates(
              startDate.format(formatter2) + " - " + endDate.format(formatter2));
        }
        if (Objects.nonNull(assignmentInfo.getAsgPreNumber())) {
          assignmentInformation.setAssignmentName(assignmentInfo.getAsgPreNumber());
        }
        if (Objects.nonNull(assignmentInfo.getClient().getName())) {
          assignmentInformation.setContractingName(assignmentInfo.getClient().getName());
        }
        if (Objects.nonNull(assignmentInfo.getClient().getJdeNumber())) {
          assignmentInformation.setContractingNumber(assignmentInfo.getClient().getJdeNumber());
        } else {
          assignmentInformation.setContractingNumber(assignmentInfo.getClientJdeNumber());
        }
        if (Objects.nonNull(assignmentInfo.getBillingEntity())) {
          assignmentInformation.setClientName(assignmentInfo.getBillingEntity().getName());
          assignmentInformation
              .setClientNumber(assignmentInfo.getBillingEntity().getJdeNumber());

        } else if (Objects.nonNull(assignmentInfo.getJob()) && Objects
            .nonNull(assignmentInfo.getJob().getPrimaryBillingEntity())) {
          assignmentInformation
              .setClientName(assignmentInfo.getJob().getPrimaryBillingEntity().getName());
          assignmentInformation.setClientNumber(
              assignmentInfo.getJob().getPrimaryBillingEntity().getJdeNumber());
        }

        if (Objects.nonNull(assignmentInfo.getJob().getPrimarySpecialtyDetail())
            && Objects
            .nonNull(assignmentInfo.getJob().getPrimarySpecialtyDetail().getSpecialty())) {
          assignmentInformation
              .setSpecialty(assignmentInfo.getJob().getPrimarySpecialtyDetail().getSpecialty()
                  .getInvoiceDescription());
        }

        if (Objects.nonNull(assignmentInfo.getPrimaryWorksite())) {
          assignmentInformation.setWorksiteName(assignmentInfo.getPrimaryWorksite().getName());
          assignmentInformation
              .setWorksiteNumber(assignmentInfo.getPrimaryWorksite().getJdeNumber());
          assignmentInformation.setWorksiteCity(assignmentInfo.getPrimaryWorksite().getCity());
          assignmentInformation
              .setWorksiteState(assignmentInfo.getPrimaryWorksite().getState());
        }
        return assignmentInformation;
      }).collect(Collectors.toList());
      providerInfo.setAssignments(assignmentInformations);
    }
    return providerInfo;
  }

  public List<AssignmentInfo> getSalesforceData(String providerNumber)
      throws Exception {
    String assignmentSoql = "SELECT "
        + "Name,"
        + "Client__r.JDE_Number__c,"
        + "Client__r.Name,"
        + "Billing_Entity__r.JDE_Number__c,"
        + "Billing_Entity__r.Name,"
        + "Cost_Center_Num__c,"
        + "Job__r.Division__r.Company_Number__c,"
        + "Job__r.Primary_Specialty_detail__r.Specialty__r.Invoice_Description__c,"
        + "Primary_Worksite__r.Name,"
        + "Primary_Worksite__r.JDE_Number__c,"
        + "Primary_Worksite__r.City__c,"
        + "Primary_Worksite__r.State__c,"
        + "Provider__r.LastName,"
        + "Provider__r.FirstName,"
        + "Provider__r.JDE_Number__c,"
        + "D_JDE_Number__c,"
        + "Start_Date__c,"
        + "End_Date__c "
        + "FROM Assignment__c "
        + "WHERE Provider__r.JDE_Number__c = '" + providerNumber + "' "
        + "AND Pipeline_State__c = 'Active'";
    logger.debug("SOQL query " + assignmentSoql);
    List<AssignmentInfo> assignmentInfos = getDataFromSalesForce(assignmentSoql);
    if (CollectionUtils.isNotEmpty(assignmentInfos)) {
      return assignmentInfos;
    } else {
      return null;
    }
  }

  public List<AssignmentInfo> getDataFromSalesForce(String soqlQuery) throws Exception {
    try {

      JSONObject response = sfRestClient.runQuery(soqlQuery);
      logger.debug(response.toString());
      JSONArray jsonArray = response.getJSONArray("records");
      ObjectMapper objectMapper = new ObjectMapper();
      logger.debug("Data from salesforce rest client: {}", jsonArray);
      List<AssignmentInfo> responses = objectMapper
          .readValue(jsonArray.toString(), new TypeReference<List<AssignmentInfo>>() {
          });
      return responses;
    } catch (Exception e) {
      throw new Exception(
          "Error connecting to salesforce:", e);
    }

  }

}
