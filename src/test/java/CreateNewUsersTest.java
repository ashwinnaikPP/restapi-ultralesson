import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import users.UsersClient;

public class CreateNewUsersTest {


    @Test
    public void shouldAddMaleUser() {
        // 1.Arrange
        String body = "{\n" +
                "    \"name\": \"Tenali Ramakrishna\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"email\": \"tenali.ramakrishna94@153ce.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";

        //2.Act
        new UsersClient().createUser(body)
                .then()
                .log().body()

        //3.Assertion.
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("email", Matchers.equalTo("tenali.ramakrishna94@153ce.com"))
                .body("name", Matchers.equalTo("Tenali Ramakrishna"));
    }

    @Test
    public void shouldAddFemaleUser() {
        // 1.Arrange
        String body = "{\n" +
                "    \"name\": \"Aditi Rao\",\n" +
                "    \"gender\": \"female\",\n" +
                "    \"email\": \"adithi6@153ce.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";

        //2.Act
        new UsersClient().createUser(body)
                .then()
                .log().body()

      //  3.Assertion.
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("email", Matchers.equalTo("adithi6@153ce.com"))
                .body("name", Matchers.equalTo("Aditi Rao"));
    }


}
