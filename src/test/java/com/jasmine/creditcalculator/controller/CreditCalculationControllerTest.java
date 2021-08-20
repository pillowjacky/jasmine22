package com.jasmine22.challenge.controller;

import com.jasmine.creditcalculator.Application;
import java.util.HashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class CreditCalculationControllerTest {

  private static final String URL_PREFIX = "http://localhost:";

  @LocalServerPort
  private int port;

  private TestRestTemplate restTemplate = new TestRestTemplate();

  @Test
  public void simulateFrontendAPICall() {
    Map<String, Object> request = new HashMap<>();
    request.put("companyType", "Partnership");
    request.put("numberOfEmployees", 50);
    request.put("timeInBusiness", 100);

    ResponseEntity<Integer> responseEntity = restTemplate
        .postForEntity(createURL("/calculateCreditScore"), request, Integer.class);

    Assertions.assertThat(responseEntity.getBody()).isEqualTo(75 + 70 + 59);
  }

  private String createURL(String uri) {
    return URL_PREFIX + port + uri;
  }
}
