package com.ileossa.hwo.repository;

import com.ileossa.hwo.model.ActuModel;
import com.ileossa.hwo.model.EventModel;
import com.ileossa.hwo.model.UserModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by kevin on 12/07/2016.
 */
public interface ActuRepository extends CrudRepository<ActuModel, Long> {

    List<ActuModel> findByClasse(String classe);
}
