package com.jasmine22.challenge.message;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ApiModel(description = "Generic error response")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ErrorResponse {

  @ApiModelProperty(value = "HTTP status code", example = "400")
  private int status;

  @ApiModelProperty(value = "Detailed error message", example = "Error message")
  private String message;
}
