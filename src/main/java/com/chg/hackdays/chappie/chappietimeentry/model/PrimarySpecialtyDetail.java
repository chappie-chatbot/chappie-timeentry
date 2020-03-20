package com.chg.hackdays.chappie.chappietimeentry.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Nanugonda on 10/3/2018.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PrimarySpecialtyDetail {

  @JsonProperty("Specialty__r")
  private Specialty specialty;

  public Specialty getSpecialty() {
    return specialty;
  }

  public void setSpecialty(Specialty specialty) {
    this.specialty = specialty;
  }
}
