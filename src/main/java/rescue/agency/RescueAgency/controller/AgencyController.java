package rescue.agency.RescueAgency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rescue.agency.RescueAgency.model.AgencyModel;
import rescue.agency.RescueAgency.model.request.AgencyChangePasswordRequest;
import rescue.agency.RescueAgency.model.request.AgencyLoginRequest;
import rescue.agency.RescueAgency.model.response.Response;
import rescue.agency.RescueAgency.service.AgencyService;

import java.util.List;

@RestController
@RequestMapping("/agency")
public class AgencyController {

    @Autowired
    AgencyService agencyService;

    @PostMapping("/register")
    public ResponseEntity<Response> agencyRegistration(@RequestBody AgencyModel agencyModel){
        return new ResponseEntity<>(agencyService.register(agencyModel), HttpStatus.OK);
    }

    @GetMapping("/login")
    public ResponseEntity<Response> agencyLogin(@RequestBody AgencyLoginRequest agencyLoginRequest){
        return new ResponseEntity<>(agencyService.login(agencyLoginRequest), HttpStatus.OK);
    }

    @GetMapping("/searchByExpertise/{expertise}")
    public ResponseEntity<List<AgencyModel>> searchAgencyByExpertise(@PathVariable String expertise){
        return new ResponseEntity<>(agencyService.searchByExpertise(expertise), HttpStatus.OK);
    }

    @GetMapping("/searchByLocation/{location}")
    public ResponseEntity<List<AgencyModel>> searchAgencyByLocation(@PathVariable String location){
        return new ResponseEntity<>(agencyService.searchByLocation(location), HttpStatus.OK);
    }

    @PutMapping("/changePassword")
    public ResponseEntity<Response> agencyChangePassword(@RequestBody AgencyChangePasswordRequest agencyChangePasswordRequest){
        return new ResponseEntity<>(agencyService.changePassword(agencyChangePasswordRequest),HttpStatus.ACCEPTED);
    }
}
