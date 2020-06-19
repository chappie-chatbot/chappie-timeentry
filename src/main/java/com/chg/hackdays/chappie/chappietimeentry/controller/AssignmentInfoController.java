package com.chg.hackdays.chappie.chappietimeentry.controller;

import com.chg.hackdays.chappie.chappietimeentry.model.ProviderInfo;
import com.chg.hackdays.chappie.chappietimeentry.service.AssignmentInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AssignmentInfoController {

  private static final Logger logger = LoggerFactory.getLogger(AssignmentInfoController.class);
  @Autowired
  private AssignmentInfoService assignmentInfoService;

  @CrossOrigin
  @GetMapping(value = "/getProviderInfo")
  public ResponseEntity<ProviderInfo> populateTransactionEntryForm(
      @RequestParam("providerNumber") String providerNumber) throws Exception {
    logger.info("Request received for "+providerNumber);
    return new ResponseEntity<>(assignmentInfoService.getProviderInfo(providerNumber),
        HttpStatus.OK);
  }

}
