package com.sagarandcompany.linkSharing.services;

import com.sagarandcompany.linkSharing.domains.User;
import com.sagarandcompany.linkSharing.repository.loginRepository.LoginRepository;
import com.sagarandcompany.linkSharing.utility.ResponseDTO;
import com.sagarandcompany.linkSharing.utility.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class LoginService {

    @Autowired
    LoginRepository loginRepository;

    @Value("${linksharing.login.error}")
    private String error;

    @Value("${linksharing.login.success}")
    private String success;

    @Value("${linksharing.login.message}")
    private String message;


    public ResponseDTO validate(String username, String password, HttpSession httpSesssion) {
        User sessionUser = (User) httpSesssion.getAttribute("user");
        ResponseDTO responseDTO = new ResponseDTO();
        if (sessionUser != null) {
            if (sessionUser.checkUsernameAndPassword(username, password)) {
                responseDTO.setMessageAndStatus(message, true);
            } else {
                responseDTO.setMessageAndStatus(error, false);
            }
        } else {
            User user = loginRepository.findByUsernameAndPassword(username, password);
            if (user != null) {
                UserVO userVO = new UserVO();
                BeanUtils.copyProperties(user, userVO);
                userVO.setTopicCount(user.getTopics().size());
                userVO.setSubscriptionCount(user.getSubscriptions().size());
                httpSesssion.setAttribute("user", userVO);
                responseDTO.setData(user.getFullname());
                responseDTO.setMessageAndStatus(success, true);

            } else {
                responseDTO.setMessageAndStatus(error, false);
            }
        }
        return responseDTO;
    }

    public ResponseDTO logout(HttpSession httpSession) {
        UserVO sessionUser = (UserVO) httpSession.getAttribute("user");
        ResponseDTO responseDTO = new ResponseDTO();
        if (sessionUser != null) {
            httpSession.removeAttribute("user");
            responseDTO.setMessageAndStatus("User logout successfully", true);
        } else
            responseDTO.setMessageAndStatus("User already logout", false);
        return responseDTO;
    }


}
