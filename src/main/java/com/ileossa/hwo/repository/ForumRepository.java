package com.ileossa.hwo.repository;

import com.ileossa.hwo.model.ForumModel;
import com.ileossa.hwo.model.UserModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by kevin on 12/07/2016.
 */
public interface ForumRepository extends CrudRepository<ForumModel, Long> {
    List<ForumModel> findByClasse(String classe);
}
