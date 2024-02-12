package rescue.agency.RescueAgency.model.request;

import lombok.Data;

@Data
public class AgencyLoginRequest {
    private String agencyEmail;
    private String agencyPassword;
}
