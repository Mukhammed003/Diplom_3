package original.apisteps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import original.Constants;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class StepsForWorkingWithAPI {

    @Step("Создаем пользователя")
    public Response createUser(String email, String password, String name) {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("email", email);
        requestBody.put("password", password);
        requestBody.put("name", name);

        Response response =
                given()
                        .header("Content-type", "application/json")
                        .body(requestBody)
                        .when()
                        .post(Constants.ENDPOINT_FOR_CREATING_USER);
        return response;
    }

    @Step("Авторизуемся под пользователем")
    public Response loginUser(String email, String password) {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("email", email);
        requestBody.put("password", password);

                Response response =
                        given()
                        .header("Content-type", "application/json")
                        .body(requestBody)
                        .when()
                        .post(Constants.ENDPOINT_FOR_LOGIN_USER);
        return response;
    }

    @Step("Извлекаем accessToken из response")
    public String extractingToken(Response response) {
        String accessToken = response.then().extract().body().path("accessToken").toString();
        return accessToken.substring(7);
    }

    @Step("Удаляем пользователя по accessToken")
    public void deleteUser(String accessToken) {
        given()
                .auth().oauth2(accessToken)
                .when()
                .delete(Constants.ENDPOINT_FOR_DELETING_USER);
    }
}
