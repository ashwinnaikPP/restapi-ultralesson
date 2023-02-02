import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;

public class GetUsersTests {

    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        // 1. Arrange
        usersClient = new UsersClient();
    }

    @Test
    public void shouldGetAllTheUsers() {
        // 2. Act
        usersClient
                .getAllUsers()
                    .then()
        // 3. Assertion
                        .statusCode(200)
                        .log().body()
                        .body("", Matchers.hasSize(10))
                        .body("", Matchers.hasItem(Matchers.hasEntry("gender","female")));
    }
}
