package rescue.agency.RescueAgency.service;

import rescue.agency.RescueAgency.model.UserModel;
import rescue.agency.RescueAgency.model.request.UserChangePasswordRequest;
import rescue.agency.RescueAgency.model.request.UserLoginRequest;
import rescue.agency.RescueAgency.model.response.Response;

public interface UserService {
    Response login(UserLoginRequest userLoginRequest);
    Response register(UserModel userModel);
    Response changePassword(UserChangePasswordRequest userChangePasswordRequest);
    Boolean checkEmail(String email);
}
