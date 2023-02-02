package users.create.response;

import lombok.Getter;
import lombok.Setter;

@Getter
public class CreateUserResponse {

    @Setter
    private int statusCode;

    private int id;
    private String name;
    private String email;
    private String gender;
    private String status;
}
