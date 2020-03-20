package com.chg.hackdays.chappie.chappietimeentry.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Nanugonda on 10/3/2018.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Job {

  @JsonProperty("Division__r")
  private Division division;
  @JsonProperty("Primary_Specialty_Detail__r")
  private PrimarySpecialtyDetail primarySpecialtyDetail;

  @JsonProperty("Primary_Worksite__r")
  private Client primaryWorkSite;

  @JsonProperty("Primary_Billing_Entity__r")
  private Client primaryBillingEntity;

  public Client getPrimaryBillingEntity() {
    return primaryBillingEntity;
  }

  public void setPrimaryBillingEntity(Client primaryBillingEntity) {
    this.primaryBillingEntity = primaryBillingEntity;
  }

  public Division getDivision() {
    return division;
  }

  public void setDivision(Division division) {
    this.division = division;
  }

  public PrimarySpecialtyDetail getPrimarySpecialtyDetail() {
    return primarySpecialtyDetail;
  }

  public void setPrimarySpecialtyDetail(
      PrimarySpecialtyDetail primarySpecialtyDetail) {
    this.primarySpecialtyDetail = primarySpecialtyDetail;
  }

  public Client getPrimaryWorkSite() {
    return primaryWorkSite;
  }

  public void setPrimaryWorkSite(Client primaryWorkSite) {
    this.primaryWorkSite = primaryWorkSite;
  }
}
