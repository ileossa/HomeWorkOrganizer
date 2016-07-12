package com.ileossa.hwo.repository;

import com.ileossa.hwo.model.DocumentModel;
import com.ileossa.hwo.model.UserModel;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by kevin on 12/07/2016.
 */
public interface DocumentRepository extends CrudRepository<DocumentModel, Long> {
}
