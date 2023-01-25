package users;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import users.create.CreateUserRequestBody;

import static io.restassured.RestAssured.given;

public class UsersClient {
    public Response createUser(CreateUserRequestBody body) {
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 877bb4ed9c14836e4ed800f248ace78737969858b256e0a5227d88890c28b36a")
                .body(body)
                .when()
                .post("https://gorest.co.in/public/v2/users");
    }

    public Response getAllUsers() {
        return given()
                .when()
                .get("https://gorest.co.in/public/v2/users");
    }
}