package com.chg.hackdays.chappie.chappietimeentry.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Nanugonda on 10/3/2018.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Provider {

  @JsonProperty("JDE_Number__c")
  private String jdeNumber;
  @JsonProperty("FirstName")
  private String firstName;
  @JsonProperty("LastName")
  private String lastName;

  public String getProviderName() {
    return (getLastName()+", " + getFirstName());
  }

  public String getJdeNumber() {
    return jdeNumber;
  }

  public void setJdeNumber(String jdeNumber) {
    this.jdeNumber = jdeNumber;
  }

  public String getFirstName() { return firstName; }

  public void setFirstName(String firstName) { this.firstName = firstName; }

  public String getLastName() { return lastName; }

  public void setLastName(String lastName) { this.lastName = lastName; }
}
