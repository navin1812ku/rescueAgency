package rescue.agency.RescueAgency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rescue.agency.RescueAgency.model.RequestModel;
import rescue.agency.RescueAgency.model.request.ReplyStoringRequest;
import rescue.agency.RescueAgency.model.response.Response;
import rescue.agency.RescueAgency.service.RequestService;

@RestController
@RequestMapping("/request")
public class RequestController {

    @Autowired
    RequestService requestService;

    @PostMapping("/addRequest")
    public ResponseEntity<Response> addRequest(@RequestBody RequestModel requestModel){
        return new ResponseEntity<>(requestService.addRequest(requestModel), HttpStatus.ACCEPTED);
    }

    @PutMapping("/addReply/{id}")
    public ResponseEntity<Response> addReply(@PathVariable String id, @RequestBody ReplyStoringRequest replyStoringRequest){
        return new ResponseEntity<>(requestService.addReply(id,replyStoringRequest),HttpStatus.OK);
    }
}
