import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;


public class MainCandidatos {
	public static void main(String[] args) {
		
		ArrayList<Candidato> candidatos = new ArrayList<Candidato>();
		String csvArchive = "Candidatos.csv";
		BufferedReader conteudoCSV = null;
		String linha = "";
		String csvSeparadorCampo = ";";
		boolean PrimeiraLinha = true;
		try {
			conteudoCSV = new BufferedReader(new FileReader(csvArchive));
			while((linha = conteudoCSV.readLine()) != null) {
				if(PrimeiraLinha) {
					PrimeiraLinha = false;
					continue;
				}
				String[] candidatoInfo = linha.split(csvSeparadorCampo);
				
				Candidato candidato = new Candidato(candidatoInfo[0],candidatoInfo[1],candidatoInfo[2].replaceAll("[\\D]", ""),candidatoInfo[3]);
				candidatos.add(candidato);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado: \n" + e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("IndexOutOfBound: \n" + e.getMessage());
		} catch (IOException e) {
			System.out.print("IO ERRO: \n" + e.getMessage());
		} finally {
			if ( conteudoCSV != null) {
				try {
					conteudoCSV.close();
				} catch (IOException e) {
					System.out.println("IO Erro: \n" + e.getMessage());
				}
			}
		}

		GerenciadorDados gerenciando = new GerenciadorDados(candidatos);
		System.out.println("Proporção de candidatos por vaga:");
		System.out.println("API .NET:" + gerenciando.porcentagemCandidatos("API .NET") + "%");
		System.out.println("iOS:" + gerenciando.porcentagemCandidatos("iOS") + "%");
		System.out.println("QA:" + gerenciando.porcentagemCandidatos("QA") + "%");
		System.out.println("");
		System.out.println("Idade média dos candidatos de QA: " + gerenciando.idadeMediaQA() + " Anos");
		System.out.println("");
		System.out.println("Candidato mais velho de iOS: " + gerenciando.maisVelhoiOS());
		System.out.println("");
		System.out.println("Candidato mais novo de API .NET: " + gerenciando.maisNovoApiNet());
		System.out.println("");
		System.out.println("Soma de idades de API .NET: " + gerenciando.somarIdadeApiNet());
		System.out.println("");
		System.out.println("Estados distintos na lista: " + gerenciando.estadosDiferentes());
		System.out.println("");
		System.out.println("Gerando Lista Alternada...");
		System.out.println("Lista ordenada salva como: Sorted_AppAcademy_Candidates.csv");
		Collections.sort(candidatos);
		try {
			// Modifique a o caminho para onde deseja salvar sua Sorted_AppAcademy_Candidates.csv//
			PrintWriter pw = new PrintWriter(new File("C:\\Users\\melch\\OneDrive\\área de Trabalho\\coisas\\Sorted_AppAcademy_Candidates.csv"));
			StringBuilder sb = new StringBuilder();
			for(Candidato candidato : candidatos) {
				sb.append(candidato);
			}
			pw.write("Nome;Vaga;Idade;Estado");
			pw.write("\n");
			pw.write(sb.toString());
			pw.close();
			} catch (Exception e){
		}
		System.out.println("");
		System.out.println("Instrutor de API .NET: " + gerenciando.identificadorInstrutor());
	}
}
