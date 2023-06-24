package starter.user;

import io.cucumber.java.en.And;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.hasKey;

public class ManageCourse {

    protected static String url = "https://skfw.net/api/v1/";
    protected static String tokenAdmin = "";
    protected static String tokenUser = "";



    @Step("user set endpoint for get course")
    public String userSetEndpointForGetCourse() {
        return url + "admin/courses?size=10&page=1&sort=desc";
    }

    @Step("login as admin to get token")
    public void loginAsAdminToGetToken() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("username", "*");
        requestBody.put("email", "admin@mail.co");
        requestBody.put("password", "Admin@1234");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(url + "users/login");
        Response resp = SerenityRest.lastResponse();

        JsonPath jsonPath = resp.getBody().jsonPath();
        tokenAdmin = jsonPath.get("data.token");
    }

    @Step("user send GET HTTP request")
    public void userSendGETHTTPRequest() {
        SerenityRest.given().header("Authorization", "Bearer "+tokenAdmin).get(userSetEndpointForGetCourse());
    }

    @Step("user send POST HTTP request")
    public void userSendPostHTTPRequest() {
        SerenityRest.given().header("Authorization", "Bearer "+tokenAdmin).post(userSetEndpointForGetCourse());
    }

    @Step("user see status code 200")
    public void userSeeStatusCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("user see status code 201 for create course")
    public void userSeeStatusCode201ForCreateCourse() {
        restAssuredThat(response -> response.statusCode(201));
    }

    @Step("get all course show up")
    public void getAllCourseShowUp() {
        restAssuredThat(response -> response.body("$", hasKey("data")));
    }

    @Step("login as user to get token")
    public void loginAsUserToGetToken() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("username", "testforqa");
        requestBody.put("email", "testforqa@mail.co");
        requestBody.put("password", "User@1234");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(url + "users/login");
        Response resp = SerenityRest.lastResponse();

        JsonPath jsonPath = resp.getBody().jsonPath();
        tokenUser = jsonPath.get("data.token");
    }

    @Step("user send GET HTTP request using normal token")
    public void userSendGETHTTPRequestUsingNormalToken() {
        SerenityRest.given().header("Authorization", "Bearer "+tokenUser).get(userSetEndpointForGetCourse());
    }

    @Step("user set endpoint for get specific course {0}")
    public String userSetEndpointForGetSpecificCourse(String id) {
        return url + "/admin/course?id="+id;
    }


    @Step("user successful get who courses enrolled")
    public String userSuccessGetWhoCourseEnrolled() {
        return url + "admin/who/courses/enrolled?size=10&page=1";
    }

    @Step("user successful get course resumes")
    public String userSuccessGetCourseResumes() {
        return url + "admin/course/resumes?size=10&page=1";
    }

}
