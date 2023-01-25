import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;

public class CreateUsersNegativeTests {

    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        //Arrange
        usersClient = new UsersClient();
    }

    @Test
    public void shouldNotAllowToCreateWithInvalidEmailID() {
        String body = "{\n" +
                "    \"name\": \"Tenali Ramakrishna\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"email\": \"tenali.ramakrishna153ce.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";
        //Act
        usersClient
                .createUser(body)
                    .then()
                        .log().body()
        //Assert
                        .statusCode(422)
                        .body("", Matchers.hasItem(Matchers.hasEntry("field", "email")))
                        .body("", Matchers.hasItem(Matchers.hasEntry("message", "is invalid")));
    }
}
