Feature: Credit Assessment Calculator
  This is a simple credit assessment calculator feature for software engineer candidates

  Scenario Outline: Calculate Credit Assessment Score successfully
    When The API calculateCreditScore is called with valid parameters <companyType>, <numberOfEmployees>, <timeInBusiness>
    Then The credit assessment score should match <result>

  Examples:
    | companyType                 | numberOfEmployees | timeInBusiness | result |
    | "Sole Proprietorship"       | 1                 | 2              | 12     |
    | "Sole Proprietorship"       | 1                 | 6              | 40     |
    | "Sole Proprietorship"       | 1                 | 14             | 48     |
    | "Sole Proprietorship"       | 1                 | 37             | 71     |
    | "Sole Proprietorship"       | 7                 | 0              | 32     |
    | "Sole Proprietorship"       | 14                | 0              | 44     |
    | "Sole Proprietorship"       | 18                | 0              | 67     |
    | "Sole Proprietorship"       | 23                | 0              | 82     |
    | "Limited Liability Company" | 1                 | 0              | 63     |
    | "Partnership"               | 1                 | 0              | 75     |
    | "Others"                    | 1                 | 0              | 0      |

  Scenario Outline: Calculate Credit Assessment Score failed (With invalid input param)
    When The API calculateCreditScore is called with invalid parameters <companyType>, <numberOfEmployees>, <timeInBusiness>
    Then The IllegalArgumentException should be thrown with <message>

  Examples:
    | companyType            | numberOfEmployees | timeInBusiness | message                                                    |
    | ""                     | 10                | 5              | "Company Type \"\" not found"                              |
    | "Invalid Company Type" | 10                | 8              | "Company Type \"Invalid Company Type\" not found"          |
    | "Sole Proprietorship"  | 0                 | 8              | "Number of Employees is out of range (from 1 to infinity)" |
    | "Sole Proprietorship"  | -1                | 8              | "Number of Employees is out of range (from 1 to infinity)" |
    | "Sole Proprietorship"  | 10                | -1             | "Time in Business is out of range (from 0 to infinity)"    |