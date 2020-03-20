package com.chg.hackdays.chappie.chappietimeentry.model;

import java.util.List;

public class ProviderInfo {
    private String providerNumber;
    private String firstName;
    private String lastName;
    List<AssignmentInformation> assignments;
    public String getProviderNumber() {
      return providerNumber;
    }
    public void setProviderNumber(String providerNumber) {
      this.providerNumber = providerNumber;
    }
    public String getFirstName() {
      return firstName;
    }
    public void setFirstName(String firstName) {
      this.firstName = firstName;
    }
    public String getLastName() {
      return lastName;
    }
    public void setLastName(String lastName) {
      this.lastName = lastName;
    }
    public List<AssignmentInformation> getAssignments() {
      return assignments;
    }
    public void setAssignments(
        List<AssignmentInformation> assignments) {
      this.assignments = assignments;
    }
  }
