package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.user.*;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class UserSteps {

    @Steps
    Authentication_Login login;

    @Steps
    Authentication_Register register;

    @Steps
    ManageCourse get;


    @Steps
    ManageCustomersWhoEnrolled manageCustomersWhoEnrolled;

    @Given("user set endpoint for login")
    public void userSetEndpointForLogin() {
        login.userSetEndpointForLogin();
    }

    @When("user send POST HTTP request with valid data")
    public void userSendPOSTHTTPRequestWithValidData() {
        login.userSendPOSTHTTPRequestWithValidData();
    }

    @Then("user see status code 201")
    public void userSeeStatusCode() {
        login.userSeeStatusCode201();
    }

    @And("get valid data")
    public void getValidData() {
        login.getValidData();
    }

    @When("user send POST HTTP request with invalid data username")
    public void userSendPOSTHTTPRequestWithInvalidDataUsername() {
        login.userSendPOSTHTTPRequestWithInvalidDataUsername();
    }

    @Then("user see status code 401")
    public void userSeeStatusCode401() {
        login.userSeeStatusCode401();
    }

    @And("user get error message {string}")
    public void userGetErrorMessage(String arg0) {
        login.userGetErrorMessage(arg0);
    }

    @When("user send POST HTTP request with invalid data email")
    public void userSendPOSTHTTPRequestWithInvalidDataEmail() {
        login.userSendPOSTHTTPRequestWithInvalidDataEmail();
    }

    @When("user send POST HTTP request with invalid data password")
    public void userSendPOSTHTTPRequestWithInvalidDataPassword() {
        login.userSendPOSTHTTPRequestWithInvalidDataPassword();
    }

    @Given("user set endpoint for register")
    public void userSetEndpointForRegister() {
        register.userSetEndpointForRegister();
    }

    @When("user send create account with valid data")
    public void userSendCreateAccountWithValidData() {
        register.userSendCreateAccountWithValidData();
    }

    @Then("user see status code 201 after send register")
    public void userSeeStatusCode201AfterSendRegister() {
        register.userSeeStatusCode201AfterSendRegister();
    }

    @And("user see new detail account")
    public void userSeeNewDetailAccount() {
        register.userSeeNewDetailAccount();
    }

    @When("user send create account with data already registered")
    public void userSendCreateAccountWithDataAlreadyRegistered() {
        register.userSendCreateAccountWithDataAlreadyRegistered();
    }

    @Then("user see status code 500 after send register")
    public void userSeeStatusCode500AfterSendRegister() {
        register.userSeeStatusCode500AfterSendRegister();
    }

    @And("get error message {string}")
    public void getErrorMessage(String arg0) {
        register.getErrorMessage(arg0);
    }

    @When("user send create account with a short password")
    public void userSendCreateAccountWithAShortPassword() {
        register.userSendCreateAccountWithAShortPassword();
    }

    @Then("user see status code 400 after send register")
    public void userSeeStatusCode400AfterSendRegister() {
        register.userSeeStatusCode400AfterSendRegister();
    }

    @Given("user set endpoint for get course")
    public void userSetEndpointForGetCourse() {
        get.userSetEndpointForGetCourse();
    }

    @And("login as admin to get token")
    public void loginAsAdminToGetToken() {
        get.loginAsAdminToGetToken();
    }

    @And("login as user to get token")
    public void loginAsUserToGetToken() {
        get.loginAsUserToGetToken();
    }

    @When("user send GET HTTP request")
    public void userSendGETHTTPRequest() {
        get.userSendGETHTTPRequest();
    }

    @When("user send GET HTTP request using normal token")
    public void userSendGETHTTPRequestUsingNormalToken() {
        get.userSendGETHTTPRequestUsingNormalToken();
    }

    @When("user send POST HTTP request")
    public void userSendPostHTTPRequest() {
        get.userSendPostHTTPRequest();
    }

    @Then("user see status code 200")
    public void userSeeStatusCode200() {
        get.userSeeStatusCode200();
    }

    @Then("user see status code 201 for create course")
    public void userSeeStatusCode201ForCreateCourse() {
        get.userSeeStatusCode201ForCreateCourse();
    }

    @And("get all course show up")
    public void getAllCourseShowUp() {
        get.getAllCourseShowUp();
    }

    @When("user send create account with a password that does not contain special characters")
    public void userSendCreateAccountWithAPasswordThatDoesNotContainSpecialCharacters() {
        register.userSendCreateAccountWithAPasswordThatDoesNotContainSpecialCharacters();
    }

    @When("user send create account with with a password that does not contain number character")
    public void userSendCreateAccountWithWithAPasswordThatDoesNotContainNumberCharacter() {
        register.userSendCreateAccountWithWithAPasswordThatDoesNotContainNumberCharacter();
    }

    @Given("user set endpoint for get customers who enrolled in the course")
    public void userSetEndpointForGetCustomersWhoEnrolledInTheCourse() {
        manageCustomersWhoEnrolled.userSetEndpointForGetCustomersWhoEnrolledInTheCourse();
    }

    @And("login to get token")
    public void loginToGetToken() {
        manageCustomersWhoEnrolled.loginToGetToken();
    }

    @When("user send GET HTTP request and token for get customers who enrolled in the course")
    public void userSendGETHTTPRequestAndTokenForGetCustomersWhoEnrolledInTheCourse() {
        manageCustomersWhoEnrolled.userSendGETHTTPRequestAndTokenForGetCustomersWhoEnrolledInTheCourse();
    }

    @And("get all customers who enrolled in the course data")
    public void getAllCustomersWhoEnrolledInTheCourseData() {
        manageCustomersWhoEnrolled.getAllCustomersWhoEnrolledInTheCourseData();
    }

    @And("login to get token using normal user")
    public void loginToGetTokenUsingNormalUser() {
        manageCustomersWhoEnrolled.loginToGetTokenUsingNormalUser();
    }

    @When("send GET HTTP request and token user for get customers who enrolled in the course")
    public void sendGETHTTPRequestAndTokenUserForGetCustomersWhoEnrolledInTheCourse() {
        manageCustomersWhoEnrolled.sendGETHTTPRequestAndTokenUserForGetCustomersWhoEnrolledInTheCourse();
    }

    @Then("error status code {int}")
    public void errorStatusCode(int arg0) {
        manageCustomersWhoEnrolled.errorStatusCode(401);
    }


    @Given("user set endpoint for get specific course {string}")
    public void userSetEndpointForGetSpecificCourse(String arg0) {
        get.userSetEndpointForGetSpecificCourse(arg0);
    }

    @Given("user successful get who courses enrolled")
    public void userSuccessGetWhoCourseEnrolled() {
        get.userSuccessGetWhoCourseEnrolled();
    }

    @Given("user successful get course resumes")
    public void userSuccessGetCourseResumes() {
        get.userSuccessGetCourseResumes();
    }

}
