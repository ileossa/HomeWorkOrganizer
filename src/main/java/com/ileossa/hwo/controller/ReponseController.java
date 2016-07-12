package com.ileossa.hwo.controller;

import com.ileossa.hwo.model.ResponseModel;
import com.ileossa.hwo.repository.ResponseRepository;
import com.ileossa.hwo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by kevin on 12/07/2016.
 */

@RestController
@RequestMapping("/reponse")
public class ReponseController {

    @Autowired
    private ResponseRepository responseRepository;

    @RequestMapping(method = POST)
    public ResponseModel createReponse(@RequestParam(value = "disussionId") long discussionID,
                                       @RequestParam(value = "authorId")long authorId,
                                       @RequestParam(value = "text") String text){
        ResponseModel responseModel = new ResponseModel(discussionID,authorId,text);
        responseRepository.save(responseModel);
        return responseModel;
    }

    @RequestMapping(method = GET)
    public List<ResponseModel> getListDiscussion(@RequestParam(value = "discussionId") long discussionId){
        return responseRepository.findByDiscussionId(discussionId);
    }

}
