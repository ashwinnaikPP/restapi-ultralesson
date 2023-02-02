import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserResponse;

import java.util.UUID;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

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
        CreateUserRequestBody userRequestBody =
                CreateUserRequestBody
                        .builder()
                            .name("Tenali Ramakrishna")
                            .gender("male")
                            .email(email)
                            .status("active")
                            .build();
        //2.Act
        CreateUserResponse createUserResponse = usersClient.createUser(userRequestBody);

        //3.Assertion.
        assertEquals(createUserResponse.getStatusCode(), 201);
        assertNotNull(createUserResponse.getId());
        assertNotNull(createUserResponse.getEmail());
        assertEquals(createUserResponse.getEmail(), userRequestBody.getEmail());
        assertEquals(createUserResponse.getName(), "Tenali Ramakrishna");
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
        CreateUserResponse createUserResponse = usersClient.createUser(userRequestBody);

      //  3.Assertion.
        assertEquals(createUserResponse.getStatusCode(), 201);
        assertNotNull(createUserResponse.getId());
        assertNotNull(createUserResponse.getEmail());
        assertEquals(createUserResponse.getEmail(), userRequestBody.getEmail());
        assertEquals(createUserResponse.getName(), "Aditi Rao");
    }
}
