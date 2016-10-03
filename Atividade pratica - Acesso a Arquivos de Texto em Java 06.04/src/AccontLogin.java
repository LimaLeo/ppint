
public class AccontLogin {
	private String login;
	private String senha;
	
	public AccontLogin() {
		this("Sem Nome", " ");
	}
	
	public AccontLogin(String login, String senha) {
		setLogin(login);
		setSenha(senha);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
