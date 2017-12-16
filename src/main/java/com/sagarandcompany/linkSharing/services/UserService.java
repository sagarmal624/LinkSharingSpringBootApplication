package com.sagarandcompany.linkSharing.services;

import com.sagarandcompany.linkSharing.domains.User;
import com.sagarandcompany.linkSharing.repository.userRepository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    UserRepositoryImpl userRepository;

    public Map save(User user) {
        User savedUser = userRepository.save(user);
        Map map = new HashMap();
        if (savedUser.getUser_id() != null) {
            map.put("status", true);
            map.put("message", "record is created successfullyy");
        } else {
            map.put("status", false);
            map.put("message", "record is not Saved successfullyy");
        }
        return map;
    }

    public User findById(Long id) {
        return userRepository.findByUser(id);
    }
}
