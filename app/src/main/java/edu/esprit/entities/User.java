package edu.esprit.entities;

public class User {

	public int idUser;

	public String address;

	public String login;

	public String mail;

	public String password;

	public String phone;

	public String firstName;

	public String lastName;

	public String gender;

	public User(){
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		User user = (User) o;

		if (idUser != user.idUser) return false;
		if (!firstName.equals(user.firstName)) return false;
		return lastName.equals(user.lastName);

	}

	@Override
	public int hashCode() {
		int result = idUser;
		result = 31 * result + firstName.hashCode();
		result = 31 * result + lastName.hashCode();
		return result;
	}
}
