package com.chg.hackdays.chappie.chappietimeentry.config;

import com.chg.connector.salesforce.rest.SalesforceRestClient;
import com.chg.connector.salesforce.rest.SalesforceRestClientException;
import com.chg.connector.salesforce.rest.auth.SFCredentialsProvider;
import com.chg.connector.salesforce.rest.auth.SalesforceRestConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.chg.connector.salesforce.rest.*"})
public class SalesForceClientConfig {

  private static final Logger logger = LoggerFactory.getLogger(SalesForceClientConfig.class);

  @Autowired
  SFCredentialsProvider springUserCredentialsProvider;

  @Bean
  SalesforceRestClient salesForceRestClient() {
    SalesforceRestConnectionFactory connectionFactory =
        SalesforceRestConnectionFactory.builder().build();
    SalesforceRestClient sfRestClient = null;
    try {
      sfRestClient = connectionFactory.createConnection();
    } catch (SalesforceRestClientException ex) {
      logger.warn("No default salesforce provider available, trying spring provider");
      connectionFactory =
          SalesforceRestConnectionFactory.builder()
              .withUserCredentialsProvider(springUserCredentialsProvider)
              .build();
      sfRestClient = connectionFactory.createConnection();
      logger.info("Using spring salesforce client provider");
    }
    return sfRestClient;
  }
}
