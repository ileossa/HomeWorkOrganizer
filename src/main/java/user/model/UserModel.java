package user.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class UserModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String pseudo;

	private String email;

	private String password;

	private String group;

	private String role;

	protected UserModel() {}

	public UserModel(long id, String pseudo, String email, String password, String group, String role) {
		super();
		this.id = id;
		this.pseudo = pseudo;
		this.email = email;
		this.password = password;
		this.group = group;
		this.role = role;
	}

	public UserModel(String pseudo, String email, String password, String group, String role) {
		super();
		this.pseudo = pseudo;
		this.email = email;
		this.password = password;
		this.group = group;
		this.role = role;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", pseudo=" + pseudo + ", email=" + email + ", password=" + password + ", group=" + group + ", role=" + role
				+ "]";
	}

}
