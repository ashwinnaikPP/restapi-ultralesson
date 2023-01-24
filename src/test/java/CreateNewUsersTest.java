import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateNewUsersTest {


    @Test
    public void shouldAddMaleUser() {
        // 1.Arrange
        String body = "{\n" +
                "    \"name\": \"Tenali Ramakrishna\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"email\": \"tenali.ramakrishna92@153ce.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";

        //2.Act
        createUser(body)
                .then()
                .log().body()

        //3.Assertion.
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("email", Matchers.equalTo("tenali.ramakrishna92@153ce.com"))
                .body("name", Matchers.equalTo("Tenali Ramakrishna"));
    }

    @Test
    public void shouldAddFemaleUser() {
        // 1.Arrange
        String body = "{\n" +
                "    \"name\": \"Aditi Rao\",\n" +
                "    \"gender\": \"female\",\n" +
                "    \"email\": \"adithi4@153ce.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";

        //2.Act
        createUser(body)
                .then()
                .log().body()

      //  3.Assertion.
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("email", Matchers.equalTo("adithi4@153ce.com"))
                .body("name", Matchers.equalTo("Aditi Rao"));
    }

    private static Response createUser(String body) {
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 877bb4ed9c14836e4ed800f248ace78737969858b256e0a5227d88890c28b36a")
                .body(body)
                .when()
                .post("https://gorest.co.in/public/v2/users");
    }
}
