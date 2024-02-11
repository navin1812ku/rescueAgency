package rescue.agency.RescueAgency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rescue.agency.RescueAgency.model.UserModel;
import rescue.agency.RescueAgency.model.request.UserChangePasswordRequest;
import rescue.agency.RescueAgency.model.request.UserLoginRequest;
import rescue.agency.RescueAgency.model.response.Response;
import rescue.agency.RescueAgency.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public ResponseEntity<Response> userLogin(@RequestBody UserLoginRequest userLoginRequest){
        return new ResponseEntity<>(userService.login(userLoginRequest), HttpStatus.ACCEPTED);
    }

    @PostMapping("/register")
    public ResponseEntity<Response> userRegister(@RequestBody UserModel userModel){
        return new ResponseEntity<>(userService.register(userModel),HttpStatus.CREATED);
    }

    @GetMapping("/checkEmail/{email}")
    public ResponseEntity<Boolean> checkEmail(@PathVariable String email){
        return new ResponseEntity<>(userService.checkEmail(email),HttpStatus.CONTINUE);
    }

    @PutMapping("/changePassword")
    public ResponseEntity<Response> userPasswordChanging(@RequestBody UserChangePasswordRequest userChangePasswordRequest){
        return new ResponseEntity<>(userService.changePassword(userChangePasswordRequest),HttpStatus.ACCEPTED);
    }
}
