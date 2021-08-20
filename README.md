# Credit Assessment Calculator
This is a simple credit assessment calculator feature for software engineer candidates

## Author
- Jacky CHUNG (Email: pillowjacky@gmail.com)

## Prerequisite
Please note that:
- This project is implement with JDK 11 (11.0.3), which installed in my home workstation
- This project is implement with [Project Lombok](https://projectlombok.org/), please install the needed IDE plugin and enable "Annotation Processing" in settings 

## Here are some assumptions of the project
- The application.properties is place in /config, to simulate the need of externalize configuration in realistic scenarios
- According to the score table in business requirement, the 3rd range of Number of Employees is 11-15, and the 4th range is 15-20, which make 15 ambiguous, thus, the 4th range is slightly modify to 16-20 in the project
- For realistic scenarios, in my opinion, cucumber test (service test / unit test) should at least test all the combination of input parameters (4 Company Type * 5 Range of Number of Employee * 4 Range of Time in Business = 80 cases) plus specific / marginal cases (invalid input parameters, number on range boundary...etc.), however. for simplicity, only one case for each category in attribute is tested 