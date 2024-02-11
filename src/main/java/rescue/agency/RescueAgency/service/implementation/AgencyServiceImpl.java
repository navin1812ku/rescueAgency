package rescue.agency.RescueAgency.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rescue.agency.RescueAgency.model.AgencyModel;
import rescue.agency.RescueAgency.model.request.AgencyChangePasswordRequest;
import rescue.agency.RescueAgency.model.request.AgencyLoginRequest;
import rescue.agency.RescueAgency.model.response.Response;
import rescue.agency.RescueAgency.repository.AgencyRepository;
import rescue.agency.RescueAgency.service.AgencyService;

import java.util.List;

@Service
public class AgencyServiceImpl implements AgencyService {

    @Autowired
    AgencyRepository agencyRepository;

    @Override
    public Response login(AgencyLoginRequest agencyLoginRequest) {
        Response response=new Response();
        AgencyModel agencyModel=agencyRepository.findByAgencyId(agencyLoginRequest.getAgencyId());
        if(agencyModel==null){
            response.setMessage("The entered agency id was not found");
            return response;
        }
        else{
            if(agencyModel.getAgency_password().equals(agencyLoginRequest.getAgencyPassword())){
                response.setMessage("Login successful");
                return response;
            }
            else{
                response.setMessage("The entered password is wrong");
                return response;
            }
        }
    }

    @Override
    public Response register(AgencyModel agencyModel) {
        Response response=new Response();
        AgencyModel model=agencyRepository.findByAgencyId(agencyModel.getAgency_id());
        if(model!=null){
            response.setMessage("This agency already had an account");
            return response;
        }
        else{
            agencyRepository.save(agencyModel);
            response.setMessage("Registered successfully");
            return response;
        }
    }

    @Override
    public List<AgencyModel> searchByExpertise(String expertise) {
        return agencyRepository.searchByAgencyExpertise(expertise);
    }

    @Override
    public List<AgencyModel> searchByLocation(String location) {
        return agencyRepository.searchByAgencyAddress(location);
    }

    @Override
    public Response changePassword(AgencyChangePasswordRequest agencyChangePasswordRequest) {
        Response response=new Response();
        AgencyModel agencyModel=agencyRepository.findByAgencyId(agencyChangePasswordRequest.getAgencyId());
        if(agencyModel==null){
            response.setMessage("The entered agency id does not exists");
            return response;
        }
        else{
            if(agencyModel.getAgency_password().equals(agencyChangePasswordRequest.getNewPassword())){
                response.setMessage("The new password matches the old password");
                return response;
            }
            else{
                agencyModel.setAgency_password(agencyChangePasswordRequest.getNewPassword());
                agencyRepository.save(agencyModel);
                if(agencyModel.getAgency_password().equals(agencyChangePasswordRequest.getNewPassword())){
                    response.setMessage("Password changed successfully");
                    return response;
                }
                else{
                    response.setMessage("Something went wrong please try again later");
                    return response;
                }
            }
        }
    }
}
