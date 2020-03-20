package com.chg.hackdays.chappie.chappietimeentry.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Nanugonda on 10/3/2018.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Client {

  @JsonProperty("Name")
  private String name;
  @JsonProperty("JDE_Number__c")
  private String jdeNumber;
  @JsonProperty("City__c")
  private String city;
  @JsonProperty("State__c")
  private String state;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getJdeNumber() {
    return jdeNumber;
  }

  public void setJdeNumber(String jdeNumber) {
    this.jdeNumber = jdeNumber;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }
}

