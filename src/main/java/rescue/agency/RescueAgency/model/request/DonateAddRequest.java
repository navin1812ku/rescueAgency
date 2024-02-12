package rescue.agency.RescueAgency.model.request;

import lombok.Data;

@Data
public class DonateAddRequest {
    private String requestType;
    private String specification;
    private String quantity;
    private String requestedBy;
    private String requesterContact;
    private String requestEndDate;
}
