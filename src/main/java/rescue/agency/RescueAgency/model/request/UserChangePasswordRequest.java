package rescue.agency.RescueAgency.model.request;

import lombok.Data;

@Data
public class UserChangePasswordRequest {
    private String e_mail;
    private String newPassword;
}
