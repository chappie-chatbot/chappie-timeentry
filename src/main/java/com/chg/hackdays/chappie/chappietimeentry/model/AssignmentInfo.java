package com.chg.hackdays.chappie.chappietimeentry.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Nanugonda on 10/3/2018.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssignmentInfo {

  @JsonProperty("Job__r")
  Job job;

  @JsonProperty("Cost_Center_Num__c")
  String costCenterNumberInAssignment;

  @JsonProperty("Client__r")
  Client client;

  @JsonProperty("Billing_Entity__r")
  Client billingEntity;

  @JsonProperty("Primary_Worksite__r")
  Client primaryWorksite;

  @JsonProperty("Provider__r")
  Provider providerFromAssignment;

  @JsonProperty("D_JDE_Number__c")
  String activeProviderJdeNumber;

  @JsonProperty("Start_Date__c")
  String assignmentStartDate;

  @JsonProperty("End_Date__c")
  String assignmentEndDate;

  @JsonProperty("Client_JDE_Number__c")
  String clientJdeNumber;

  @JsonProperty("Cost_Center__c")
  String costCenterInPresent;

  @JsonProperty("Contact__r")
  Provider providerFromPresent;

  @JsonProperty("Name")
  String asgPreNumber;

  public Job getJob() {
    return job;
  }

  public void setJob(Job job) {
    this.job = job;
  }

  public String getCostCenterNumberInAssignment() {
    return costCenterNumberInAssignment;
  }

  public void setCostCenterNumberInAssignment(String costCenterNumberInAssignment) {
    this.costCenterNumberInAssignment = costCenterNumberInAssignment;
  }

  public String getClientJdeNumber() {
    return clientJdeNumber;
  }

  public void setClientJdeNumber(String clientJdeNumber) {
    this.clientJdeNumber = clientJdeNumber;
  }

  public String getCostCenterInPresent() {
    return costCenterInPresent;
  }

  public void setCostCenterInPresent(String costCenterInPresent) {
    this.costCenterInPresent = costCenterInPresent;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public Client getBillingEntity() {
    return billingEntity;
  }

  public void setBillingEntity(Client billingEntity) {
    this.billingEntity = billingEntity;
  }

  public String getActiveProviderJdeNumber() {
    return activeProviderJdeNumber;
  }

  public void setActiveProviderJdeNumber(String activeProviderJdeNumber) {
    this.activeProviderJdeNumber = activeProviderJdeNumber;
  }

  public String getAssignmentStartDate() {
    return assignmentStartDate;
  }

  public void setAssignmentStartDate(String assignmentStartDate) {
    this.assignmentStartDate = assignmentStartDate;
  }

  public String getAssignmentEndDate() {
    return assignmentEndDate;
  }

  public void setAssignmentEndDate(String assignmentEndDate) {
    this.assignmentEndDate = assignmentEndDate;
  }

  public Provider getProviderFromAssignment() {
    return providerFromAssignment;
  }

  public void setProviderFromAssignment(
      Provider providerFromAssignment) {
    this.providerFromAssignment = providerFromAssignment;
  }

  public Provider getProviderFromPresent() {
    return providerFromPresent;
  }

  public void setProviderFromPresent(
      Provider providerFromPresent) {
    this.providerFromPresent = providerFromPresent;
  }

  public String getAsgPreNumber() {
    return asgPreNumber;
  }

  public void setAsgPreNumber(String asgPreNumber) {
    this.asgPreNumber = asgPreNumber;
  }

  public Client getPrimaryWorksite() {
    return primaryWorksite;
  }

  public void setPrimaryWorksite(Client primaryWorksite) {
    this.primaryWorksite = primaryWorksite;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("job", job)
        .append("costCenterNumberInAssignment", costCenterNumberInAssignment)
        .append("client", client)
        .append("billingEntity", billingEntity)
        .append("providerFromAssignment", providerFromAssignment)
        .append("activeProviderJdeNumber", activeProviderJdeNumber)
        .append("assignmentStartDate", assignmentStartDate)
        .append("assignmentEndDate", assignmentEndDate)
        .append("clientJdeNumber", clientJdeNumber)
        .append("costCenterInPresent", costCenterInPresent)
        .append("providerFromPresent", providerFromPresent)
        .append("asgPreNumber", asgPreNumber)
        .append("primaryWorksite", primaryWorksite)
        .toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    AssignmentInfo that = (AssignmentInfo) o;

    return new EqualsBuilder()
        .append(job, that.job)
        .append(costCenterNumberInAssignment, that.costCenterNumberInAssignment)
        .append(client, that.client)
        .append(billingEntity, that.billingEntity)
        .append(providerFromAssignment, that.providerFromAssignment)
        .append(activeProviderJdeNumber, that.activeProviderJdeNumber)
        .append(assignmentStartDate, that.assignmentStartDate)
        .append(assignmentEndDate, that.assignmentEndDate)
        .append(clientJdeNumber, that.clientJdeNumber)
        .append(costCenterInPresent, that.costCenterInPresent)
        .append(providerFromPresent, that.providerFromPresent)
        .append(asgPreNumber, that.asgPreNumber)
        .append(primaryWorksite, that.primaryWorksite)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
        .append(job)
        .append(costCenterNumberInAssignment)
        .append(client)
        .append(billingEntity)
        .append(providerFromAssignment)
        .append(activeProviderJdeNumber)
        .append(assignmentStartDate)
        .append(assignmentEndDate)
        .append(clientJdeNumber)
        .append(costCenterInPresent)
        .append(providerFromPresent)
        .append(asgPreNumber)
        .append(primaryWorksite)
        .toHashCode();
  }
}
