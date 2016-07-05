package user.repositorys;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import user.model.UserModel;


public interface UserRepository extends CrudRepository<UserModel, Long> {

	List<UserModel> findByLastName(String lastName);

	UserModel findOneByEmail(String email);

	UserModel findOneByPseudo(String pseudo);
}
