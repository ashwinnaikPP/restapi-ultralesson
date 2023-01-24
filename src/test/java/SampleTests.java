import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import static io.restassured.RestAssured.given;

public class SampleTests {

    @Test
    public void shouldTestSomething(){
        Assert.assertEquals(1,1);
    }

    @Test
    public void secondSampleTest(){
        Assert.assertEquals(5.3,5.3);
    }

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
                    .log().body();

    }

    @Test
    public void shouldAddNewUser() {
        // 1.Arrange 2.Act 3.Assertion.

        given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .header("Authorization", "Bearer 877bb4ed9c14836e4ed800f248ace78737969858b256e0a5227d88890c28b36a")
                    .body("{\n" +
                            "    \"name\": \"Tenali Ramakrishna\",\n" +
                            "    \"gender\": \"male\",\n" +
                            "    \"email\": \"tenali.ramakrishna2@153ce.com\",\n" +
                            "    \"status\": \"active\"\n" +
                            "}")
                .when()
                    .post("https://gorest.co.in/public/v2/users")
                .then()
                    .log().body()
                    .statusCode(201);
    }
}
