package com.sagarandcompany.linkSharing.services;

import com.sagarandcompany.linkSharing.domains.Topic;
import com.sagarandcompany.linkSharing.domains.User;
import com.sagarandcompany.linkSharing.repository.topicRepository.TopicRepositoryImpl;
import com.sagarandcompany.linkSharing.repository.userRepository.UserRepositoryImpl;
import com.sagarandcompany.linkSharing.utility.ResponseDTO;
import com.sagarandcompany.linkSharing.utility.TopicVO;
import org.hibernate.Session;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<TopicVO> getTopicList() throws Exception {
        return topicRepositoryImpl.getTopicList();
    }

    public ResponseDTO save(Topic topic) {
        ResponseDTO responseDTO = new ResponseDTO();
        Topic savetopic = topicRepositoryImpl.save(topic);
        if (savetopic != null) {
            TopicVO topicVO = new TopicVO();
            BeanUtils.copyProperties(savetopic, topicVO);
            responseDTO.setData(topicVO);
            responseDTO.setMessageAndStatus(success, true);
        } else {
            responseDTO.setMessageAndStatus(error, false);
        }
        return responseDTO;
    }

    public ResponseDTO getTopic(Long id) {
        ResponseDTO responseDTO = new ResponseDTO();
        Topic topic = topicRepositoryImpl.getTopic(id);
        if (topic != null) {
            responseDTO.setStatus(true);
            TopicVO topicVO = new TopicVO();
            topicVO.setName(topic.getName());
            topicVO.setTopic_id(topic.getTopic_id());
            topicVO.setVisibility(topic.getVisibility());
            topicVO.setUser_id(topic.getCreatedBy().getUser_id());
            topicVO.setDateCreated(topic.getDateCreated());
            responseDTO.setData(topicVO);
        }
        return responseDTO;
    }

    public ResponseDTO delete(Long id) {
        ResponseDTO responseDTO = new ResponseDTO();
        if (topicRepositoryImpl.delete(id)) {
            responseDTO.setMessageAndStatus("Record Deleted Successfully", true);


        } else {
            responseDTO.setMessageAndStatus("Something went Wrong", false);
        }

        return responseDTO;
    }
}


















