import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.create.CreateUserRequestBody;

public class CreateUsersNegativeTests {

    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        //Arrange
        usersClient = new UsersClient();
    }

    @Test
    public void shouldNotAllowToCreateWithInvalidEmailID() {
        String name = "Tenali Ramakrishna";
        String gender = "male";
        String email = "tenali.ramakrishna153ce.com";
        String status = "active";
        CreateUserRequestBody userRequestBody = new CreateUserRequestBody(name, gender, email, status);
        //Act
        usersClient
                .createUser(userRequestBody)
                    .then()
                        .log().body()
        //Assert
                        .statusCode(422)
                        .body("", Matchers.hasItem(Matchers.hasEntry("field", "email")))
                        .body("", Matchers.hasItem(Matchers.hasEntry("message", "is invalid")));
    }
}
