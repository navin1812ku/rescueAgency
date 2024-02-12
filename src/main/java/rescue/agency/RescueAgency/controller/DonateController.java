package rescue.agency.RescueAgency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rescue.agency.RescueAgency.model.request.DonateAddRequest;
import rescue.agency.RescueAgency.model.response.Response;
import rescue.agency.RescueAgency.service.DonateService;

@RestController
@RequestMapping("/donate")
public class DonateController {

    @Autowired
    DonateService donateService;

    @PostMapping("/addRequest")
    public ResponseEntity<Response> donateRequestAdding(@RequestBody DonateAddRequest donateAddRequest){
        return new ResponseEntity<>(donateService.addDonateRequest(donateAddRequest), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteDonateRequest/{donateRequestId}")
    public ResponseEntity<Response> donateRequestDeleting(@PathVariable String donateRequestId){
        return new ResponseEntity<>(donateService.removeDonateRequest(donateRequestId),HttpStatus.OK);
    }
}
