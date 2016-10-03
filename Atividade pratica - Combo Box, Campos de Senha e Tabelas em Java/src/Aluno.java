
public class Aluno {
	private int ra;
	private String senha, nomeAluno;

	public Aluno(int ra, String senha, String nomeAluno) {
		this.ra = ra;
		this.senha = senha;
		this.nomeAluno = nomeAluno;
	}

	public int getRa() {
		return ra;
	}

	public void setRa(int ra) {
		this.ra = ra;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}
}
