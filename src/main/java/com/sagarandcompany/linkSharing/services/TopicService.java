package com.sagarandcompany.linkSharing.services;

import com.sagarandcompany.linkSharing.domains.Topic;
import com.sagarandcompany.linkSharing.repository.topicRepository.TopicRepositoryImpl;
import com.sagarandcompany.linkSharing.repository.userRepository.UserRepositoryImpl;
import com.sagarandcompany.linkSharing.utility.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
    @Autowired
    TopicRepositoryImpl topicRepositoryImpl;

    @Autowired
    UserRepositoryImpl userRepository;
    @Value(" ${linksharing.topic.success}")
    private String success;

    @Value("${linksharing.topic.error}")
    private String error;

    public ResponseDTO save(Topic topic) {
        ResponseDTO responseDTO = new ResponseDTO();
        if (topicRepositoryImpl.save(topic) != null) {
            responseDTO.setMessageAndStatus(success, true);
        } else {
            responseDTO.setMessageAndStatus(error, false);
        }
        return responseDTO;
    }


}


















