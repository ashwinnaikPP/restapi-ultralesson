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
}
