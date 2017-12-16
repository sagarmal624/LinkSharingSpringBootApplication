package com.sagarandcompany.linkSharing.services;

import com.sagarandcompany.linkSharing.domains.User;
import com.sagarandcompany.linkSharing.repository.loginRepository.LoginRepository;
import com.sagarandcompany.linkSharing.repository.userRepository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {

    @Autowired
    LoginRepository loginRepository;


    public Map validate(String username, String password) {

        User user = loginRepository.findByUsernameAndPassword(username, password);
        Map map = new HashMap();
        if (user != null) {
            map.put("status", true);
            map.put("message", "User is login successfullyy");

        } else {
            map.put("status", false);
            map.put("message", "Invalid username and password");
        }
        return map;
    }


}
