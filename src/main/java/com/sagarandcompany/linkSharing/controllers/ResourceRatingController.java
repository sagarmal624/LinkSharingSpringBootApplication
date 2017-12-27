package com.sagarandcompany.linkSharing.controllers;

import com.sagarandcompany.linkSharing.domains.ResourceRating;
import com.sagarandcompany.linkSharing.services.ResorceRatingService;
import com.sagarandcompany.linkSharing.utility.ResourceRatingDTO;
import com.sagarandcompany.linkSharing.utility.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller
@RequestMapping("/resourceRating")
public class ResourceRatingController {

    @Autowired
    ResorceRatingService resorceRatingService;

    @PostMapping("/save")
    @ResponseBody
    public ResponseDTO save(@ModelAttribute("resorcerating") ResourceRatingDTO resourceRating) {
        return resorceRatingService.save(resourceRating);

    }

    @GetMapping("get/{id}")
    @ResponseBody
    public ResponseDTO getResourcerating(@PathVariable("id") Long id)
  {
      return resorceRatingService.get(id);

  }
     @DeleteMapping("delete/{id}")
    @ResponseBody
    public ResponseDTO deleteResourcertng(@PathVariable("id") Long id)
     {
         return resorceRatingService.delete(id);
     }


}
