package starter.user;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;

public class Authentication_Login {

    protected static String url = "https://skfw.net/api/v1/";

    @Step("user set endpoint for login")
    public String userSetEndpointForLogin() {
        return url + "users/login";
    }

    @Step("user send POST HTTP request with valid data")
    public void userSendPOSTHTTPRequestWithValidData() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("username", "testinggg1");
        requestBody.put("email", "testinggg1@gmail.com");
        requestBody.put("password", "Testing123!@@#");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(userSetEndpointForLogin());
    }

    @Step("user see status code 201")
    public void userSeeStatusCode201() {
        restAssuredThat(response -> response.statusCode(201));
    }

    @Step("get valid data")
    public void getValidData() {
        restAssuredThat(response -> response.body("$", hasKey("data")));
    }

    @Step("user send POST HTTP request with invalid data username")
    public void userSendPOSTHTTPRequestWithInvalidDataUsername() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("username", "usertestingsalah");
        requestBody.put("email", "usertesting@mail.co");
        requestBody.put("password", "User@1234usertesting");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(userSetEndpointForLogin());
    }

    @Step("user see status code 401")
    public void userSeeStatusCode401() {
        restAssuredThat(response -> response.statusCode(401));
    }

    @Step("user get error message {string}")
    public void userGetErrorMessage(String arg0) {
        restAssuredThat(response -> response.body("$", hasKey("message")));
    }

    @Step("user send POST HTTP request with invalid data email")
    public void userSendPOSTHTTPRequestWithInvalidDataEmail() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("username", "usertesting");
        requestBody.put("email", "usertesting@mail.cooooo");
        requestBody.put("password", "User@1234usertesting");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(userSetEndpointForLogin());
    }

    @Step("user send POST HTTP request with invalid data password")
    public void userSendPOSTHTTPRequestWithInvalidDataPassword() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("username", "test11");
        requestBody.put("email", "usertesting1@mail.co");
        requestBody.put("password", "User@1234usertesting1s");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(userSetEndpointForLogin());
    }

}
