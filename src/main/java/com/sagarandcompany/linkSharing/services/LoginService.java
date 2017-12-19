package com.sagarandcompany.linkSharing.services;

import com.sagarandcompany.linkSharing.domains.User;
import com.sagarandcompany.linkSharing.repository.loginRepository.LoginRepository;
import com.sagarandcompany.linkSharing.utility.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class LoginService {

    @Autowired
    LoginRepository loginRepository;

    @Value("${linksharing.login.error}")
    private String errorMsg;

    public ResponseDTO validate(String username, String password, HttpSession httpSesssion) {

        User sessionUser = (User) httpSesssion.getAttribute("user");
        ResponseDTO responseDTO = new ResponseDTO();
        if (sessionUser != null) {
            if (sessionUser.checkUsernameAndPassword(username, password)) {
                responseDTO.setMessageAndStatus("User Already logined", true);
            } else {
                responseDTO.setMessageAndStatus(errorMsg, false);
            }
        } else {
            User user = loginRepository.findByUsernameAndPassword(username, password);
            if (user != null) {
                httpSesssion.setAttribute("user", user);
                responseDTO.setMessageAndStatus("User logined", true);

            } else {
                responseDTO.setMessageAndStatus(errorMsg, false);
            }
        }
        return responseDTO;
    }

    public ResponseDTO logout(HttpSession httpSession) {
        User sessionUser = (User) httpSession.getAttribute("user");
        ResponseDTO responseDTO = new ResponseDTO();
        if (sessionUser != null) {
            httpSession.removeAttribute("user");
            responseDTO.setMessageAndStatus("User logout successfully", true);
        } else
            responseDTO.setMessageAndStatus("User already logout", false);
        return responseDTO;
    }


}
