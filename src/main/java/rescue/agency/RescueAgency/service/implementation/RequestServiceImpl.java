package rescue.agency.RescueAgency.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rescue.agency.RescueAgency.model.RequestModel;
import rescue.agency.RescueAgency.model.request.ReplyStoringRequest;
import rescue.agency.RescueAgency.model.response.Response;
import rescue.agency.RescueAgency.repository.RequestRepository;
import rescue.agency.RescueAgency.service.RequestService;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    RequestRepository requestRepository;

    @Override
    public Response addRequest(RequestModel requestModel) {
        Response response=new Response();
        String id=DonateServiceImpl.generateUniqueId();
        RequestModel model=new RequestModel();
        model.setRequestContact(requestModel.getRequestContact());
        model.setRequestDescription(requestModel.getRequestDescription());
        model.setRequestLocation(requestModel.getRequestLocation());
        model.setRequestMemberId(id);
        model.setReplyContact("");
        model.setReplyContent("");
        model.setRequestType(requestModel.getRequestType());
        requestRepository.save(model);
        if(requestRepository.existsById(id)){
            response.setMessage("Request sent successfully");
            return response;
        }
        response.setMessage("Something went wrong please try again later");
        return response;
    }

    @Override
    public Response addReply(String id, ReplyStoringRequest replyStoringRequest) {
        Response response=new Response();
        RequestModel requestModel=requestRepository.findByRequestMemberId(id);
        if(requestModel==null){
            response.setMessage("Given id has no request");
            return response;
        }
        requestModel.setReplyContent(replyStoringRequest.getReplyContent());
        requestModel.setReplyContact(replyStoringRequest.getReplyContact());
        requestRepository.save(requestModel);
        if(requestRepository.findByRequestMemberId(id).getReplyContent()!=null){
            response.setMessage("Reply added successfully");
            return response;
        }
        response.setMessage("Something went wrong please try again later");
        return response;
    }
}
