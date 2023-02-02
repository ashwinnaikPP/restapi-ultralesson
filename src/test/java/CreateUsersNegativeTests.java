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
        CreateUserRequestBody userRequestBody = CreateUserRequestBody.builder()
                .name("Tenali Ramakrishna")
                .gender("male")
                .email("tenali.ramakrishna153ce.com")
                .status("active")
                .build();
        //Act
        usersClient.create(userRequestBody)

        //Assert
        .then()
                .statusCode(422)
                .body("", Matchers.hasItem(Matchers.hasEntry("field", "email")))
                .body("", Matchers.hasItem(Matchers.hasEntry("message", "is invalid")));
    }
}
