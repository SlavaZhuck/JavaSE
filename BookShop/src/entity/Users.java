package entity;

public class Users {

	private int id_user;
	private String login;
	private String pass;
	private int role;
	private int del_status;

	public Users(int id_user, String login, String pass, int role, int del_status) {
		this.id_user = id_user;
		this.login = login;
		this.pass = pass;
		this.role = role;
		this.del_status = del_status;
	}

	public Users(String login, String pass) {
		this.login = login;
		this.pass = pass;
		role = 1;
		del_status = 1;
	}

	public Users() {

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + del_status;
		result = prime * result + id_user;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + role;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		if (del_status != other.del_status)
			return false;
		if (id_user != other.id_user)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (role != other.role)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Users [id_user=" + id_user + ", login=" + login + ", pass=" + pass + ", role=" + role + ", del_status="
				+ del_status + "]";
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getDel_status() {
		return del_status;
	}

	public void setDel_status(int del_status) {
		this.del_status = del_status;
	}

}
