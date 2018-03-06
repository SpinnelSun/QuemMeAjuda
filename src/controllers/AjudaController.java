package controllers;

import java.util.HashMap;
import java.util.Map;

import models.Ajuda;
import models.AjudaOnline;
import models.AjudaPresencial;
import models.InfoAjuda;
import models.InfoAluno;
import utility.Validador;

public class AjudaController {
	
	private Map<Integer, Ajuda> ajudas;
	
	public AjudaController() {
		this.ajudas = new HashMap<Integer, Ajuda>();
	}
	
	public int pedirAjudaPresencial (String matriculaAluno, String disciplina, String hora, String dia,
									 String local, String matriculaTutor) {
		
		this.ajudas.put(this.ajudas.size() + 1, new AjudaPresencial(matriculaAluno, disciplina, hora, dia,
						local, matriculaTutor));
		
		return this.ajudas.size();
	}
	
	public int pedirAjudaOnline (String matriculaAluno, String disciplina, String matriculaTutor) {
		this.ajudas.put(this.ajudas.size() + 1, new AjudaOnline(matriculaAluno, disciplina, matriculaTutor));
		return this.ajudas.size();
	}
	
	private void impedirAjudaNaoCadastrada(int idAjuda) {
		if (!this.ajudas.containsKey(idAjuda)) {
			throw new IllegalArgumentException("id nao encontrado ");
		}
	}

	public String pegarTutor(int idAjuda) {
		Validador.validarInteiroPositivo("id nao pode menor que zero ", idAjuda);
		this.impedirAjudaNaoCadastrada(idAjuda);
		
		return this.ajudas.get(idAjuda).toString();
	}
	
	public String getInfoAjuda(int idAjuda, String atributo) {
		Validador.validarInteiroPositivo("id nao pode menor que zero ", idAjuda);
		this.impedirAjudaNaoCadastrada(idAjuda);
		
		return this.ajudas.get(idAjuda).getInfo(atributo);
	}
	
	public void registrarAvaliacao(int idAjuda) {
		this.impedirAjudaNaoCadastrada(idAjuda);
		this.ajudas.get(idAjuda).registrarAvaliacao();
	}

}
