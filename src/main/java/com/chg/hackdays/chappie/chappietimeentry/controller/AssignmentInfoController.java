package com.chg.hackdays.chappie.chappietimeentry.controller;

import com.chg.hackdays.chappie.chappietimeentry.model.ProviderInfo;
import com.chg.hackdays.chappie.chappietimeentry.service.AssignmentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AssignmentInfoController {

  @Autowired
  private AssignmentInfoService assignmentInfoService;

  @CrossOrigin
  @GetMapping(value = "/getProviderInfo")
  public ResponseEntity<ProviderInfo> populateTransactionEntryForm(
      @RequestParam("providerNumber") String providerNumber) throws Exception {
    return new ResponseEntity<>(assignmentInfoService.getProviderInfo(providerNumber),
        HttpStatus.OK);
  }

}
