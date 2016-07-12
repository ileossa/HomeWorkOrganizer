package com.ileossa.hwo.repository;

import com.ileossa.hwo.model.DiscussionModel;
import com.ileossa.hwo.model.ForumModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by kevin on 12/07/2016.
 */
public interface DiscusionRepository extends CrudRepository<DiscussionModel, Long> {
        List<DiscussionModel> findByForumId(long forumId);
}
