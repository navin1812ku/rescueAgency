package rescue.agency.RescueAgency.service;

import rescue.agency.RescueAgency.model.request.DonateAddRequest;
import rescue.agency.RescueAgency.model.response.Response;

public interface DonateService {
    Response addDonateRequest(DonateAddRequest donateAddRequest);
    Response removeDonateRequest(String donateRequestId);
}
