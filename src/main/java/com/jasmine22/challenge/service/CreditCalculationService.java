package com.jasmine22.challenge.service;

import com.jasmine.creditcalculator.dto.CreditScoreInputs;
import java.util.Arrays;
import org.springframework.stereotype.Service;

@Service
public class CreditCalculationService {

  private int[] numberOfEmployeesRange = {5, 10, 15, 20};
  private int[] timeInBusinessRange = {3, 9, 15};

  public Integer calculateCreditScore(CreditScoreInputs inputs) {
    return getCompanyTypeScore(inputs.getCompanyType())
        + getNumberOfEmployees(inputs.getNumberOfEmployees())
        + getTimeInBusinessScore(inputs.getTimeInBusiness());
  }

  private int getCompanyTypeScore(String companyType) {
    if (companyType == null || companyType.trim().isEmpty()) {
      throw new IllegalArgumentException("Company Type \"\" not found");
    }

    switch (companyType.toUpperCase()) {
      case "SOLE PROPRIETORSHIP":
        return 12;
      case "LIMITED LIABILITY COMPANY":
        return 63;
      case "PARTNERSHIP":
        return 75;
      case "OTHERS":
        return 0;
      default:
        throw new IllegalArgumentException("Company Type \"" + companyType + "\" not found");
    }
  }

  private int getNumberOfEmployees(int numberOfEmployees) {
    if (numberOfEmployees < 1) {
      throw new IllegalArgumentException(
          "Number of Employees is out of range (from 1 to infinity)");
    }

    int range = offsetIndex(Arrays.binarySearch(numberOfEmployeesRange, numberOfEmployees));

    switch (range) {
      case 1:
        return 0;
      case 2:
        return 20;
      case 3:
        return 32;
      case 4:
        return 55;
      default:
        return 70;
    }
  }

  private int getTimeInBusinessScore(int timeInBusiness) {
    if (timeInBusiness < 0) {
      throw new IllegalArgumentException("Time in Business is out of range (from 0 to infinity)");
    }

    int range = offsetIndex(Arrays.binarySearch(timeInBusinessRange, timeInBusiness));

    switch (range) {
      case 1:
        return 0;
      case 2:
        return 28;
      case 3:
        return 36;
      default:
        return 59;
    }
  }

  private int offsetIndex(int index) {
    return (index < 0) ? Math.abs(index) : index + 1;
  }
}
