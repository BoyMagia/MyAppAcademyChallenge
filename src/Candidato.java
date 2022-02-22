
public class Candidato implements Comparable<Candidato>{
	private String nome,vaga,idade,estado;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getVaga() {
		return vaga;
	}

	public void setVaga(String vaga) {
		this.vaga = vaga;
	}

	public int getIdade() {
		return Integer.parseInt(idade);
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getEstado() {
		return estado;
	}

	@Override
	public String toString() {
		return "" + nome + ";" + vaga + ";" + idade + ";" + estado + "\n";
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Candidato(String nome, String vaga, String idade, String estado) {
		this.nome = nome;
		this.vaga = vaga;
		this.idade = idade;
		this.estado = estado;
	}

	@Override
	public int compareTo(Candidato candidatos) {
		return this.getNome().compareTo(candidatos.getNome());
	}
}
