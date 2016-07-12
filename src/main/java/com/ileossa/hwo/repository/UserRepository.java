package com.ileossa.hwo.repository;

import java.util.List;

import com.ileossa.hwo.model.UserModel;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<UserModel, Long> {
    List<UserModel> findByPseudo(String pseudo);

	UserModel findOneByEmail(String email);

	UserModel findOneByPseudo(String pseudo);

	List<UserModel> findByClasse(String classe);
}
