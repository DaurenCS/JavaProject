package mainPackage;

import java.io.Serializable;

public class LogInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String login;
	private String password;

	public LogInfo(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (this.getClass() != o.getClass())
			return false;
		return this.login.equals(((LogInfo) o).getLogin()) && this.password.equals(((LogInfo) o).getPassword());
	}

	public int hashCode() {
		return login.hashCode() + password.hashCode();
	}

}
