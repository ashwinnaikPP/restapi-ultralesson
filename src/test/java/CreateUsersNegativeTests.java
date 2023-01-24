import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import users.UsersClient;

public class CreateUsersNegativeTests {
    @Test
    public void shouldNotAllowToCreateWithInvalidEmailID() {
        //Arrange
        String body = "{\n" +
                "    \"name\": \"Tenali Ramakrishna\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"email\": \"tenali.ramakrishna153ce.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";

        //Act
        new UsersClient().createUser(body)
                .then()
                .log().body()

                //Assert
                .statusCode(422)
                .body("", Matchers.hasItem(Matchers.hasEntry("field", "email")))
                .body("", Matchers.hasItem(Matchers.hasEntry("message", "is invalid")));
    }
}
