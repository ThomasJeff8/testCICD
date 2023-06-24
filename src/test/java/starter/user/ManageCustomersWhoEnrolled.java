package starter.user;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.hasKey;

public class ManageCustomersWhoEnrolled {

    protected static String url = "https://skfw.net/api/v1/";
    protected static String token = "";
    protected static String tokenUser = "";

    @Step("user set endpoint for get customers who enrolled in the course")
    public String userSetEndpointForGetCustomersWhoEnrolledInTheCourse() {
        return url + "admin/who/courses/enrolled?size=100&page=1";
    }

    @Step("login to get token")
    public void loginToGetToken() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("username", "*");
        requestBody.put("email", "admin@mail.co");
        requestBody.put("password", "Admin@1234");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(url + "users/login");
        Response resp = SerenityRest.lastResponse();

        JsonPath jsonPath = resp.getBody().jsonPath();
        token = jsonPath.get("data.token");
    }

    @Step("user send GET HTTP request and token for get customers who enrolled in the course")
    public void userSendGETHTTPRequestAndTokenForGetCustomersWhoEnrolledInTheCourse() {
        SerenityRest.given().header("Authorization", "Bearer "+token).get(userSetEndpointForGetCustomersWhoEnrolledInTheCourse());
    }

    @Step("get all customers who enrolled in the course data")
    public void getAllCustomersWhoEnrolledInTheCourseData() {
        restAssuredThat(response -> response.body("$", hasKey("data")));
    }

    @Step("login to get token using normal user")
    public void loginToGetTokenUsingNormalUser() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("username", "testforqa");
        requestBody.put("email", "testforqa@mail.co");
        requestBody.put("password", "User@1234");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(url + "users/login");
        Response resp = SerenityRest.lastResponse();

        JsonPath jsonPath = resp.getBody().jsonPath();
        tokenUser = jsonPath.get("data.token");
    }


    @Step("send GET HTTP request and token user for get customers who enrolled in the course")
    public void sendGETHTTPRequestAndTokenUserForGetCustomersWhoEnrolledInTheCourse() {
        SerenityRest.given().header("Authorization", "Bearer "+tokenUser).get(userSetEndpointForGetCustomersWhoEnrolledInTheCourse());
    }

    @Step("error status code {int}")
    public void errorStatusCode(int arg0) {
        restAssuredThat(response -> response.statusCode(401));
    }
}
