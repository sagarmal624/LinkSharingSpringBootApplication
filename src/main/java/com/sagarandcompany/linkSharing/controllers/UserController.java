package com.sagarandcompany.linkSharing.controllers;

import com.sagarandcompany.linkSharing.domains.User;
import com.sagarandcompany.linkSharing.exception.RecordNotFoundException;
import com.sagarandcompany.linkSharing.services.UserService;
import com.sagarandcompany.linkSharing.utility.LinkSharingKeyword;
import com.sagarandcompany.linkSharing.utility.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/save")
    @ResponseBody
    public ResponseDTO save(@ModelAttribute("user") User user) {
        return userService.save(user);
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public ResponseDTO getUser(@PathVariable("id") Long id) {
        ResponseDTO responseDTO = userService.findById(id);
        if (responseDTO.getData() == null)
            throw new RecordNotFoundException(LinkSharingKeyword.USER.getValue());
        return responseDTO;
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseDTO deleteUser(@PathVariable("id") Long id) {
        return userService.delete(id);
    }

}
