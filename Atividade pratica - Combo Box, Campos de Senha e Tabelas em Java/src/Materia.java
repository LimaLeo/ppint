import java.util.List;

public class Materia {
	private String nomeMateria;
	private List<Aluno> alunos;
	private int faltas;
	private double media;
	private String periodo;
	
	public Materia(String nomeMateria, List<Aluno> alunos, int faltas, double media, String periodo) {
		this.nomeMateria = nomeMateria;
		this.alunos = alunos;
		this.faltas = faltas;
		this.media = media;
		this.periodo = periodo;
	}

	public String getNomeMateria() {
		return nomeMateria;
	}

	public void setNomeMateria(String nomeMateria) {
		this.nomeMateria = nomeMateria;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public int getFaltas() {
		return faltas;
	}

	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

}
