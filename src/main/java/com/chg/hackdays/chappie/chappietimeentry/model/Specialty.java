package com.chg.hackdays.chappie.chappietimeentry.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Nanugonda on 10/3/2018.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Specialty {

  @JsonProperty("Invoice_Description__c")
  private String invoiceDescription;

  public String getInvoiceDescription() {
    return invoiceDescription;
  }

  public void setInvoiceDescription(String invoiceDescription) {
    this.invoiceDescription = invoiceDescription;
  }
}
