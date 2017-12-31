package com.sagarandcompany.linkSharing.services;

import com.sagarandcompany.linkSharing.domains.User;
import com.sagarandcompany.linkSharing.repository.userRepository.UserRepositoryImpl;
import com.sagarandcompany.linkSharing.utility.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepositoryImpl userRepository;
    @Value(" ${linksharing.user.success}")
    private String success;

    @Value("${linksharing.user.error}")
    private String error;

    public ResponseDTO save(User user) {

        ResponseDTO responseDTO = new ResponseDTO();

        User savedUser = userRepository.save(user);
        if (savedUser.getUser_id() != null) {

            responseDTO.setMessageAndStatus(success, true);

        } else {
            responseDTO.setMessageAndStatus(error, false);
        }
        return responseDTO;
    }

    public ResponseDTO findById(Long id) {
        ResponseDTO responseDTO = new ResponseDTO();
        User user = userRepository.findByUser(id);
        if (user != null)
            responseDTO.setData(user);
        return responseDTO;
    }

    public ResponseDTO delete(Long id) {
        ResponseDTO responseDTO = new ResponseDTO(false);

        if (userRepository.delete(id)) {
            responseDTO.setMessageAndStatus("Deleted Successfully", true);
        } else
            responseDTO.setMessage("Something went wrong");
        return responseDTO;
    }

}
