package rescue.agency.RescueAgency.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rescue.agency.RescueAgency.model.UserModel;
import rescue.agency.RescueAgency.model.request.UserChangePasswordRequest;
import rescue.agency.RescueAgency.model.request.UserLoginRequest;
import rescue.agency.RescueAgency.model.response.Response;
import rescue.agency.RescueAgency.repository.UserRepository;
import rescue.agency.RescueAgency.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepository;

    @Override
    public Response login(UserLoginRequest userLoginRequest) {
        UserModel userModel=userRepository.findByEmail(userLoginRequest.getE_mail());
        Response response=new Response();
        if(userModel!=null){
            if(userLoginRequest.getPassword().equals(userModel.getPassword())){
                response.setMessage("Login successful");
                return response;
            }
            else{
                response.setMessage("The entered password was wrong");
                return response;
            }
        }
        else{
            response.setMessage("Given email did not exist");
            return response;
        }
    }

    @Override
    public Response register(UserModel userModel) {
        Response response=new Response();
        userRepository.save(userModel);
        if(userRepository.findByEmail(userModel.getEmail())!=null){
            response.setMessage("Successfully registered");
            return response;
        }
        else {
            response.setMessage("Something went wrong please try again later");
            return response;
        }
    }

    @Override
    public Response changePassword(UserChangePasswordRequest userChangePasswordRequest) {
        Response response=new Response();
        System.out.println(userChangePasswordRequest.getE_mail());
        UserModel userModel=userRepository.findByEmail(userChangePasswordRequest.getE_mail());
        if(userModel==null){
            response.setMessage("Email id was not found");
            return response;
        }
        else {
            if(userModel.getPassword().equals(userChangePasswordRequest.getNewPassword())){
                response.setMessage("The entered new password matches the old password");
                return response;
            }
            else{
                userModel.setPassword(userChangePasswordRequest.getNewPassword());
                userRepository.save(userModel);
                if(userModel.getPassword().equals(userChangePasswordRequest.getNewPassword())){
                    response.setMessage("Password changed successfully");
                    return response;
                }
                else {
                    response.setMessage("Something went wrong please try again later");
                    return response;
                }
            }
        }
    }

    @Override
    public Boolean checkEmail(String email) {
        UserModel userModel=userRepository.findByEmail(email);
        if(userModel!=null){
            System.out.println(userModel.getEmail());
            return true;
        }
        else {
            System.out.println("ID not found");
            return false;
        }
    }
}
