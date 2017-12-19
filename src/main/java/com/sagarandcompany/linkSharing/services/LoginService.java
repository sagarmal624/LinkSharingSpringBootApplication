package com.sagarandcompany.linkSharing.services;

import com.sagarandcompany.linkSharing.domains.User;
import com.sagarandcompany.linkSharing.repository.loginRepository.LoginRepository;
import com.sagarandcompany.linkSharing.repository.userRepository.UserRepositoryImpl;
import com.sagarandcompany.linkSharing.utility.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {

    @Autowired
    LoginRepository loginRepository;


    public ResponseDTO validate(String username, String password, HttpSession httpSesssion) {

        User sessionUser = (User) httpSesssion.getAttribute("user");
        ResponseDTO responseDTO = new ResponseDTO();
        if (sessionUser != null) {
            if (sessionUser.checkUsernameAndPassword(username, password)) {
                responseDTO.setMessageAndStatus("User Already logined", true);
            } else {
                responseDTO.setMessageAndStatus("Invalid Username and password", false);
            }
        } else {
            User user = loginRepository.findByUsernameAndPassword(username, password);
            if (user != null) {
                httpSesssion.setAttribute("user", user);
                responseDTO.setMessageAndStatus("User logined", true);

            } else {
                responseDTO.setMessageAndStatus("Invalid Username and password", false);
            }
        }
        return responseDTO;
    }


}
