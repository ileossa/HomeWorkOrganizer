package com.ileossa.hwo.controller;

import com.ileossa.hwo.model.ForumModel;
import com.ileossa.hwo.repository.ForumRepository;
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
@RequestMapping("/forum")
public class ForumController {


    @Autowired
    private ForumRepository forumRepository;

    @RequestMapping(method = POST)
    public ForumModel createForum(@RequestParam(value = "groupId") String groupeId,
                                  @RequestParam(value = "name") String name){
        ForumModel forumModel = new ForumModel(groupeId,name);
        forumRepository.save(forumModel);
        return forumModel;
    }
    @RequestMapping(method = GET)
    public List<ForumModel> getListDiscussion(@RequestParam(value = "groupId") String groupeId){
        groupeId = groupeId.toUpperCase();
        return forumRepository.findByClasse(groupeId);
    }

}
