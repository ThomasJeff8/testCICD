package starter.user;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.hasKey;

public class Authentication_Register {

    protected static String url = "https://skfw.net/api/v1/";

    @Step("user set endpoint for register")
    public String userSetEndpointForRegister() {
        return url + "users/signup";
    }

    @Step("user send create account with valid data")
    public void userSendCreateAccountWithValidData() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "testforqa12345");
        requestBody.put("username", "5testforqa12345");
        requestBody.put("email", "5testforqa12345@mail.co");
        requestBody.put("password", "User@1234");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(userSetEndpointForRegister());
    }

    @Step("user see status code 201 after send register")
    public void userSeeStatusCode201AfterSendRegister() {
        restAssuredThat(response -> response.statusCode(201));
    }

    @Step("user see new detail account")
    public void userSeeNewDetailAccount() {
        restAssuredThat(response -> response.body("$", hasKey("data")));
    }

    @Step("user send create account with data already registered")
    public void userSendCreateAccountWithDataAlreadyRegistered() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "testqa");
        requestBody.put("username", "testqa");
        requestBody.put("email", "testqa@mail.co");
        requestBody.put("password", "User@1234usertestqa");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(userSetEndpointForRegister());
    }

    @Step("user see status code 500 after send register")
    public void userSeeStatusCode500AfterSendRegister() {
        restAssuredThat(response -> response.statusCode(500));
    }

    @Step("get error message {string}")
    public void getErrorMessage(String arg0) {
        restAssuredThat(response -> response.body("$", hasKey("message")));
    }

    @Step("user send create account with a short password")
    public void userSendCreateAccountWithAShortPassword() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "testqa");
        requestBody.put("username", "testqa");
        requestBody.put("email", "testqa@mail.co");
        requestBody.put("password", "user");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(userSetEndpointForRegister());
    }

    @Step("user see status code 400 after send register")
    public void userSeeStatusCode400AfterSendRegister() {
        restAssuredThat(response -> response.statusCode(400));
    }

    @Step("user send create account with a password that does not contain special characters")
    public void userSendCreateAccountWithAPasswordThatDoesNotContainSpecialCharacters() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "testqa");
        requestBody.put("username", "testqa");
        requestBody.put("email", "testqa@mail.co");
        requestBody.put("password", "userrrrrrrrrr");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(userSetEndpointForRegister());
    }

    @Step("user send create account with with a password that does not contain number character")
    public void userSendCreateAccountWithWithAPasswordThatDoesNotContainNumberCharacter() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "testqa");
        requestBody.put("username", "testqa");
        requestBody.put("email", "testqa@mail.co");
        requestBody.put("password", "Userrrrrrr!@#");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(userSetEndpointForRegister());
    }
}
