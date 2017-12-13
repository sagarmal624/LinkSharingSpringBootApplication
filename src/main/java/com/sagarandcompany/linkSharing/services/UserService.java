package com.sagarandcompany.linkSharing.services;

import com.sagarandcompany.linkSharing.domains.User;
import com.sagarandcompany.linkSharing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Map save(User user) {
        User savedUser = userRepository.saveAndFlush(user);
        Map map = new HashMap();
        if (savedUser.getId() != null) {
            map.put("status", true);
            map.put("message", "record is created successfullyy");
        } else {
            map.put("status", false);
            map.put("message", "record is not Saved successfullyy");
        }
        return map;
    }

    public User findById(Long id) {
        return userRepository.findOne(id);
    }
}
