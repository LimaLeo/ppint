
public class AccontLogin {
	private String login;
	private String senha;
	private String permissao;
	
	public AccontLogin() {
		this("Sem Nome", " ", " ");
	}
	
	public AccontLogin(String login, String senha, String permissao) {
		setLogin(login);
		setSenha(senha);
		setPermissao(permissao);
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

	public String getPermissao()
	{
		return permissao;
	}

	public void setPermissao(String permissao)
	{
		this.permissao = permissao;
	}
}
