package rescue.agency.RescueAgency.service;

import rescue.agency.RescueAgency.model.RequestModel;
import rescue.agency.RescueAgency.model.request.ReplyStoringRequest;
import rescue.agency.RescueAgency.model.response.Response;

public interface RequestService {
    Response addRequest(RequestModel requestModel);
    Response addReply(String id, ReplyStoringRequest replyStoringRequest);
}
