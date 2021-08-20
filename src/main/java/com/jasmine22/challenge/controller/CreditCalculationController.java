package com.jasmine22.challenge.controller;

import com.jasmine.creditcalculator.dto.CreditScoreInputs;
import com.jasmine.creditcalculator.message.ErrorResponse;
import com.jasmine.creditcalculator.service.CreditCalculationService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreditCalculationController {

  @Autowired
  private CreditCalculationService service;

  @ApiOperation(value = "Calculate credit assessment score", notes = "Calculate credit assessment score based on input parameters, referencing corresponding score from score table")
  @ApiImplicitParam(name = "inputs", required = true, value = "Input parameters include company type, number of employees & time in business", dataType = "CreditScoreInputs")
  @ApiResponses({
      @ApiResponse(code = 200, message = "Credit score"),
      @ApiResponse(code = 400, message = "Invalid input parameters", response = ErrorResponse.class)
  })
  @PostMapping(path = "/calculateCreditScore", consumes = "application/json", produces = "application/json")
  public Integer calculateCreditScore(@RequestBody CreditScoreInputs inputs) {
    return service.calculateCreditScore(inputs);
  }
}
