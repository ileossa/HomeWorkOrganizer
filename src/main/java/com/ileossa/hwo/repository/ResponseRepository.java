package com.ileossa.hwo.repository;

import com.ileossa.hwo.model.ResponseModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by kevin on 12/07/2016.
 */
public interface ResponseRepository extends CrudRepository<ResponseModel, Long> {
    List<ResponseModel> findByDiscussionId(long discussionId);
}

