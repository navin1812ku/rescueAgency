package rescue.agency.RescueAgency.model.request;

import lombok.Data;

@Data
public class UserLoginRequest {
    private String e_mail;
    private String password;
}
