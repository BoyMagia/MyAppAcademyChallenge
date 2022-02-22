import java.util.ArrayList;

public class GerenciadorDados{

	public ArrayList<Candidato> todosCandidatos = new ArrayList<Candidato>();
	public ArrayList<Candidato> iOSCandidatos = new ArrayList<Candidato>();
	public ArrayList<Candidato> APICandidatos = new ArrayList<Candidato>();
	public ArrayList<Candidato> QACandidatos = new ArrayList<Candidato>();
	
	public GerenciadorDados (ArrayList<Candidato> candidatos) {
		this.todosCandidatos = candidatos;
		separarPorVaga(todosCandidatos);
	}

	private void separarPorVaga(ArrayList<Candidato> candidatos) {

		for(int i = 0 ; i < candidatos.size() ; i++) {
			if(candidatos.get(i).getVaga().equals("QA")) {
				QACandidatos.add(candidatos.get(i));
			} else if (candidatos.get(i).getVaga().equals("API .NET")) {
				APICandidatos.add(candidatos.get(i));
			} else {
				iOSCandidatos.add(candidatos.get(i));
			}		
		}
	}
	
	public double porcentagemCandidatos(String vaga) {
		double qtdVaga = 0 ;
		if(vaga.equals("iOS")) {
			qtdVaga = iOSCandidatos.size();
		} else if (vaga.equals("API .NET")){
			qtdVaga = APICandidatos.size();			
		} else {
			qtdVaga = QACandidatos.size();
		}
		return Math.round(qtdVaga * 100 / todosCandidatos.size());
	}
	public double idadeMediaQA() {
		int somaIdade = 0;
		for(int i = 0 ; i < QACandidatos.size() ; i++) {
			somaIdade += QACandidatos.get(i).getIdade();
		}
		return somaIdade/ QACandidatos.size();
	}
	public String maisVelhoiOS() {
		int maiorIdade = 0;
		String maisVelho = "";
		for(int i = 0 ; i < iOSCandidatos.size() ; i++) {
			if(iOSCandidatos.get(i).getIdade() > maiorIdade) {
				maiorIdade = iOSCandidatos.get(i).getIdade();
				maisVelho = iOSCandidatos.get(i).getNome();
			}
		}
		return maisVelho;
	}
	public String maisNovoApiNet() {
		int menorIdade = 0;
		String maisNovo = "";
		for(int i = 0 ; i < APICandidatos.size() ; i++) {
			if(i == 0) {
				menorIdade = APICandidatos.get(i).getIdade();
				maisNovo = APICandidatos.get(i).getNome();
			}
			if(APICandidatos.get(i).getIdade() < menorIdade) {
				menorIdade = APICandidatos.get(i).getIdade();
				maisNovo = APICandidatos.get(i).getNome();
			}
		}
		return maisNovo;
	}
	public int somarIdadeApiNet() {
		int somaIdade = 0;
		for(int i = 0; i < APICandidatos.size() ; i++) {
			somaIdade += APICandidatos.get(i).getIdade();
		}
		return somaIdade;
	}
	public int estadosDiferentes() {
		int estadosDiferentes = 0;
		String estado = "";
		for(int i = 0; i < todosCandidatos.size() ; i++) {
			if(!estado.contains(todosCandidatos.get(i).getEstado())) {
				estado = estado + todosCandidatos.get(i).getEstado();
				estadosDiferentes++;
			}
		}
		return estadosDiferentes;
	}

	public String identificadorInstrutor() {
		String instrutor = "";
		for(int i = 0 ; i < todosCandidatos.size() ; i++) {
			if((todosCandidatos.get(i).getIdade() % 2 != 0) && (todosCandidatos.get(i).getIdade() < 31) && (todosCandidatos.get(i).getNome().endsWith("k"))){
				instrutor = todosCandidatos.get(i).getNome();
			}
		}
		return instrutor;
	}
}
