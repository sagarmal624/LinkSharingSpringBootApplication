package com.sagarandcompany.linkSharing.services;

import com.sagarandcompany.linkSharing.domains.Topic;
import com.sagarandcompany.linkSharing.repository.topicRepository.TopicRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TopicService {
    @Autowired
    TopicRepositoryImpl topicRepositoryImpl;

    public Map save(Topic topic) {
        Topic savedTopic = topicRepositoryImpl.save(topic);
        Map<String, Object> map = new HashMap<>();
        if (savedTopic != null) {
            map.put("message", "Record is Successfuly stored");
            map.put("status", true);
        } else {
            map.put("message", "Record is not Successfuly stored");
            map.put("status", false);
        }
        return map;
    }
}
