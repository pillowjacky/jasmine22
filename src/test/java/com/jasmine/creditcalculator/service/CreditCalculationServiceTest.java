package com.jasmine22.challenge.service;

import com.jasmine.creditcalculator.dto.CreditScoreInputs;
import com.jasmine.creditcalculator.share.BaseServiceTest;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;


public class CreditCalculationServiceTest extends BaseServiceTest {

  @Autowired
  private CreditCalculationService service;

  private CreditScoreInputs inputs = new CreditScoreInputs();

  @When("The API calculateCreditScore is called with valid parameters {string}, {int}, {int}")
  public void the_API_calculateCreditScore_is_called_with_vaild_parameters(String companyType,
      Integer numberOfEmployees, Integer setTimeInBusiness) {
    inputs.setCompanyType(companyType);
    inputs.setNumberOfEmployees(numberOfEmployees);
    inputs.setTimeInBusiness(setTimeInBusiness);
  }

  @Then("The credit assessment score should match {int}")
  public void the_credit_assessment_score_should_match(Integer result) {
    Assertions.assertThat(service.calculateCreditScore(inputs)).isEqualTo(result);
  }

  @When("The API calculateCreditScore is called with invalid parameters {string}, {int}, {int}")
  public void the_API_calculateCreditScore_is_called_with_invaild_parameters(String companyType,
      Integer numberOfEmployees, Integer setTimeInBusiness) {
    inputs.setCompanyType(companyType);
    inputs.setNumberOfEmployees(numberOfEmployees);
    inputs.setTimeInBusiness(setTimeInBusiness);
  }

  @Then("The IllegalArgumentException should be thrown with {string}")
  public void the_IllegalArgumentException_should_be_thrown_with(String message) {
    Assertions.assertThatThrownBy(() -> service.calculateCreditScore(inputs))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(message);
  }
}
