package com.sagarandcompany.linkSharing.services;

import com.sagarandcompany.linkSharing.domains.Topic;
import com.sagarandcompany.linkSharing.domains.User;
import com.sagarandcompany.linkSharing.repository.topicRepository.TopicRepositoryImpl;
import com.sagarandcompany.linkSharing.repository.userRepository.UserRepositoryImpl;
import com.sagarandcompany.linkSharing.utility.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TopicService {
    @Autowired
    TopicRepositoryImpl topicRepositoryImpl;

    @Autowired
    UserRepositoryImpl userRepository;

    public ResponseDTO save(Topic topic) {
        ResponseDTO responseDTO = new ResponseDTO();
        if (topicRepositoryImpl.save(topic) != null) {
            responseDTO.setMessageAndStatus("Topic is saved successfully", true);
        } else {
            responseDTO.setMessageAndStatus("Topic is not saved successfully", false);
        }
        return responseDTO;
    }


}

