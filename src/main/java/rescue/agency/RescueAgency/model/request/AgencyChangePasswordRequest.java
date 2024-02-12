package rescue.agency.RescueAgency.model.request;

import lombok.Data;

@Data
public class AgencyChangePasswordRequest {
    private String agencyEmail;
    private String agencyNewPassword;
}
