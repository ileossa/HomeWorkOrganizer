package com.ileossa.hwo.repository;

import com.ileossa.hwo.model.DiscussionModel;
import com.ileossa.hwo.model.ForumModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by kevin on 12/07/2016.
 * Pour plus d'informations sur le fonctionnement de l'iterface, ce référencer à l'url  http://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-sql.html
 */
public interface DiscusionRepository extends CrudRepository<DiscussionModel, Long> {
        List<DiscussionModel> findByForumId(long forumId);
}
