package com.ileossa.hwo.repository;

import java.util.List;

import com.ileossa.hwo.model.UserModel;
import org.springframework.data.repository.CrudRepository;

/**
 * Vincent L
 * Pour plus d'informations sur le fonctionnement de l'iterface, ce référencer à l'url  http://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-sql.html
 */
public interface UserRepository extends CrudRepository<UserModel, Long> {
    List<UserModel> findByPseudo(String pseudo);

	UserModel findOneByEmail(String email);

	UserModel findOneByPseudo(String pseudo);

	List<UserModel> findByClasse(String classe);
}
