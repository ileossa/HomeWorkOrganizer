package com.ileossa.hwo.controller;

import com.ileossa.hwo.model.DiscussionModel;
import com.ileossa.hwo.repository.DiscusionRepository;
import com.ileossa.hwo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by kevin on 12/07/2016.
 */
@RestController
@RequestMapping("/discussion")
public class DiscussionController {

    @Autowired
    private DiscusionRepository discusionRepository;

    @RequestMapping(method = POST)
    public DiscussionModel createDiscussion(@RequestParam(value = "forumId") long forumId,
                                            @RequestParam(value = "sujet")String sujet,
                                            @RequestParam(value = "text") String text,
                                            @RequestParam(value = "authorId") long authorId){
        DiscussionModel discussionModel = new DiscussionModel(forumId,sujet,text,authorId);
        discusionRepository.save(discussionModel);
        return discussionModel;
    }

    @RequestMapping(method = GET)
    public List<DiscussionModel> getListDiscussion(@RequestParam(value = "forumId") long forumID){
        return discusionRepository.findByForumId(forumID);
    }

}
