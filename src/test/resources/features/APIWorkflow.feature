Feature: API


  Background:
    Given a B-token is generated

  @api1
  Scenario: create employee
    Given a request is prepared for creating an employee using API call
    When a POST call is made to create an employee
    Then the status code for this request is 201
    And the employee created has a message  contains "Message" and value "Employee Created"
    And the employee id "Employee.employee_id" is stored as global variable


  @api
  Scenario: Get the created employee
    Given a request is prepared for getting a created employee
    When a GET call is made
    Then the status code for get call is 200
    And the "employee" data coming from the response should match with actual data.
      |emp_firstname|emp_lastname|emp_middle_name|emp_gender|emp_birthday|emp_status|emp_job_title   |
      |veronica     |benitez     |queen          |Female    |1990-10-13  |employed  |Senior QA tester|


  @dynamic
  Scenario: create employee with dynamic payload
    Given a request is prepared for creating an employee using API call with dynamic payload
    When a POST call is made to create an employee
    Then the status code for this request is 201


  @moredynamicjson
  Scenario: create employee with dynamic payload
    Given a request is prepared for creating an employee using data "veronica" , "benitez" , "queen" , "F" , "1990-10-13" , "employed" , "Senior QA tester" values
    When a POST call is made to create an employee
    Then the status code for this request is 201