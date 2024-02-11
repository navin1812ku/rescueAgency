package rescue.agency.RescueAgency.model.request;

import lombok.Data;

@Data
public class AgencyLoginRequest {
    private String agencyId;
    private String agencyPassword;
}
