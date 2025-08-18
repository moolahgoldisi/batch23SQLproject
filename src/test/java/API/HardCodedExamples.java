package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {
    // task number 1
    //create an Employee on RestAssured
    //set the base URI
    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";

    String token = " eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3NTU0Mzc1NTQsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTc1NTQ4MDc1NCwidXNlcklkIjoiNzQ0MiJ9.oaxxERGM-5wAD1Bvs24E46XuEVJsPiDLYCfr7CSzMuc";

    static String employee_id;

    @Test
    public void aCreateAnEmployee() {
        //given kew word to prepare the request specifications
        //header-->content type and authorization
        //body-->the request body
        RequestSpecification request = given().header("Content-Type", "application/json").header("Authorization", token).
                body("{\n" +
                        "  \"emp_firstname\": \"veronica\",\n" +
                        "  \"emp_lastname\": \"benitez\",\n" +
                        "  \"emp_middle_name\": \"queen\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"1990-10-13\",\n" +
                        "  \"emp_status\": \"employed\",\n" +
                        "  \"emp_job_title\": \"Senior QA tester\"\n" +
                        "}");

//getting the endpoint
        //When keyword to send the request to server
        //make sure to have the request attached to the when() keyword
        Response response = request.when().post("/createEmployee.php");
        //printing the response
        response.prettyPrint();
//verify the response code is 201
        response.then().assertThat().statusCode(201);
        //verify the employee is created
        response.then().assertThat().body("Message", org.hamcrest.Matchers.equalTo("Employee Created"));
//verify that the employee first_name is veronica
        response.then().assertThat().body("Employee.emp_firstname", org.hamcrest.Matchers.equalTo("veronica"));
//extract the employee id using json path
        employee_id = response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);

    }


    @Test
    public void bgetCreatedEmployee() {

        //preparing the request
        RequestSpecification request = given().
                header("Content-Type", "application/json").
                header("Authorization", token).
                queryParam("employee_id", employee_id);

        Response response = request.when().get("/getOneEmployee.php");

        response.then().assertThat().statusCode(200);
        response.prettyPrint();


    }

    @Test
    public void cUpdateEmployee() {
        //preparing the request
        RequestSpecification request = given().header("Content-Type", "application/json").header("Authorization", token).
                body("{\n" +
                        "  \"employee_id\": \"" + employee_id + "\",\n" +
                        "  \"emp_firstname\": \"john\",\n" +
                        "  \"emp_lastname\": \"doe\",\n" +
                        "  \"emp_middle_name\": \"m\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"1998-07-08\",\n" +
                        "  \"emp_status\": \"employeed\",\n" +
                        "  \"emp_job_title\": \"cloud engineer\"\n" +
                        "}");

        Response response = request.when().put("/updateEmployee.php");

        //validate the response
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("Message", org.hamcrest.Matchers.equalTo("Employee record Updated"));


    }
}


















