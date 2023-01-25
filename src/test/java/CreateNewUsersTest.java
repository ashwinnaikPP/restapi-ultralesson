import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.create.CreateUserRequestBody;

import java.util.UUID;

public class CreateNewUsersTest {

    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass() {
        // 1.Arrange
        usersClient = new UsersClient();
    }

    @Test
    public void shouldAddMaleUser() {
        String email = String.format("%s@gmail.com", UUID.randomUUID());
        CreateUserRequestBody userRequestBody = CreateUserRequestBody.builder()
                                                                        .name("Tenali Ramakrishna")
                                                                        .gender("male")
                                                                        .email(email)
                                                                        .status("active")
                                                                        .build();
        //2.Act
        usersClient
                .createUser(userRequestBody)
                    .then()
                        .log().body()
        //3.Assertion.
                        .statusCode(201)
                        .body("id", Matchers.notNullValue())
                        .body("email", Matchers.equalTo(email))
                        .body("name", Matchers.equalTo("Tenali Ramakrishna"));
    }

    @Test
    public void shouldAddFemaleUser() {
        // 1.Arrange
        String email = String.format("%s@gmail.com", UUID.randomUUID());
        CreateUserRequestBody userRequestBody = CreateUserRequestBody.builder()
                .name("Aditi Rao")
                .gender("female")
                .email(email)
                .status("active")
                .build();
        //2.Act
        usersClient
                .createUser(userRequestBody)
                    .then()
                        .log().body()
      //  3.Assertion.
                        .statusCode(201)
                        .body("id", Matchers.notNullValue())
                        .body("email", Matchers.equalTo(email))
                        .body("name", Matchers.equalTo("Aditi Rao"));
    }
}
