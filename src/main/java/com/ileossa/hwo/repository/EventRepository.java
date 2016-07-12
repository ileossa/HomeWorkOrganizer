package com.ileossa.hwo.repository;

import com.ileossa.hwo.model.EventModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by kevin on 12/07/2016.
 */
public interface EventRepository extends CrudRepository<EventModel, Long> {

   List<EventModel> findByClasse(String classe);
}
