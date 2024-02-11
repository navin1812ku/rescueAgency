package rescue.agency.RescueAgency.service;


import rescue.agency.RescueAgency.model.AgencyModel;
import rescue.agency.RescueAgency.model.request.AgencyChangePasswordRequest;
import rescue.agency.RescueAgency.model.request.AgencyLoginRequest;
import rescue.agency.RescueAgency.model.response.Response;

import java.util.List;

public interface AgencyService {

    Response login(AgencyLoginRequest agencyLoginRequest);
    Response register(AgencyModel agencyModel);
    List<AgencyModel> searchByExpertise(String expertise);
    List<AgencyModel> searchByLocation(String location);
    Response changePassword(AgencyChangePasswordRequest agencyChangePasswordRequest);
}
