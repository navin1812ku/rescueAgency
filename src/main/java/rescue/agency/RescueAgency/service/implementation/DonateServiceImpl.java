package rescue.agency.RescueAgency.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rescue.agency.RescueAgency.model.DonateModel;
import rescue.agency.RescueAgency.model.request.DonateAddRequest;
import rescue.agency.RescueAgency.model.response.Response;
import rescue.agency.RescueAgency.repository.DonateRepository;
import rescue.agency.RescueAgency.service.DonateService;

@Service
public class DonateServiceImpl implements DonateService {

    @Autowired
    DonateRepository donateRepository;

    @Override
    public Response addDonateRequest(DonateAddRequest donateAddRequest) {
        Response response=new Response();
        DonateModel donateModel=new DonateModel();
        String id=generateUniqueId();
        donateModel.setRequestId(id);
        donateModel.setRequestType(donateAddRequest.getRequestType());
        donateModel.setSpecification(donateAddRequest.getSpecification());
        donateModel.setQuantity(donateAddRequest.getQuantity());
        donateModel.setRequestedBy(donateAddRequest.getRequestedBy());
        donateModel.setRequesterContact(donateAddRequest.getRequesterContact());
        donateModel.setRequestEndDate(donateAddRequest.getRequestEndDate());
        donateRepository.save(donateModel);
        if(donateRepository.existsById(id)){
            response.setMessage("Donate request added successfully");
            return response;
        }
        else {
            response.setMessage("Something went wrong please try again later");
            return response;
        }
    }

    @Override
    public Response removeDonateRequest(String donateRequestId) {
        Response response=new Response();
        donateRepository.deleteById(donateRequestId);
        if(donateRepository.existsById(donateRequestId)){
            response.setMessage("Something went wrong please try again later");
            return response;
        }
        else{
            response.setMessage("Donate request was deleted");
            return response;
        }
    }

    public static String generateUniqueId() {
        long timestamp = System.currentTimeMillis();
        int random = (int) (Math.random() * 100000);
        String uniqueId = String.format("%08d", timestamp % 100000000) + String.format("%05d", random);
        return uniqueId;
    }
}
