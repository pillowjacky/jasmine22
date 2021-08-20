package com.jasmine22.challenge.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ApiModel(description = "Input parameters for credit calculation")
@Getter
@Setter
@ToString
public class CreditScoreInputs {

  @ApiModelProperty(value = "Company type", required = true, allowableValues = "Sole Proprietorship, Limited Liability Company, Partnership, Others")
  private String companyType;

  @ApiModelProperty(value = "Number of employees", required = true, allowableValues = "range[1, infinity]")
  private int numberOfEmployees;

  @ApiModelProperty(value = "Time in business", required = true, allowableValues = "range[0, infinity]")
  private int timeInBusiness;
}
