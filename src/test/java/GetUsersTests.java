import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class GetUsersTests {

    @Test
    public void shouldGetAllTheUsers() {
        // 1. Arrange
        // 2. Act
        // 3. Assertion

        given()
                .when()
                    .get("https://gorest.co.in/public/v2/users")
                .then()
                    .statusCode(200)
                    .log().body()
                .body("", Matchers.hasSize(10))
                .body("", Matchers.hasItem(Matchers.hasEntry("gender","female")));

    }


}
