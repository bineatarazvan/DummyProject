package curs.ecenta.beans;

import curs.ecenta.interfaces.Human;

public class UserBean implements Human{
	private int iduser;
	private String FirstName;
	private String LastName;
	private String username;
	private String password;

	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
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

	@Override
	public String getBehavior() {
		// TODO Auto-generated method stub
		return "getBehavior Method";
	}
	

}
