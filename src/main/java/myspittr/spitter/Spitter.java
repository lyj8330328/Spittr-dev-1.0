package myspittr.spitter;

import org.springframework.web.multipart.MultipartFile;

public class Spitter {

	private int id;

	private String username;

	private String password;

	private String passwordconfirm;

	private String email;

	private MultipartFile profilePicture;

	public Spitter() {
	}

	public Spitter(Integer id, String username, String email) {
		this(id, username, null, email, null, null);
	}

	public Spitter(Integer id, String username, String password, String email, String passwordconfirm,
			MultipartFile profilePicture) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.passwordconfirm = passwordconfirm;
		this.profilePicture = profilePicture;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setPasswordconfirm(String passwordconfim) {
		this.passwordconfirm = passwordconfim;
	}

	public String getPasswordconfirm() {
		return passwordconfirm;
	}

	public MultipartFile getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(MultipartFile profilePicture) {
		this.profilePicture = profilePicture;
	}

	// @Override
	// public boolean equals(Object that) {
	// return EqualsBuilder.reflectionEquals(this, that, "firstName",
	// "lastName", "username", "password", "email");
	// }
	//
	// @Override
	// public int hashCode() {
	// return HashCodeBuilder.reflectionHashCode(this, "firstName", "lastName",
	// "username", "password", "email");
	// }

}
