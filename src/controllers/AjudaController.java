package controllers;

import java.util.HashMap;
import java.util.Map;

import models.Ajuda;
import models.AjudaOnline;
import models.AjudaPresencial;

public class AjudaController {
	
	static int numAjudas = 0;
	private Map<Integer, Ajuda> ajudas;
	
	
	public AjudaController() {
		this.ajudas = new HashMap<Integer, Ajuda>();
	}
	
	public int pedirAjudaPresencial (String matriculaAluno, String disciplina, String horario, String dia, String localInteresse) {
		AjudaPresencial novaAjuda = new AjudaPresencial(matriculaAluno, disciplina, horario, dia, localInteresse);	
		this.numAjudas++;
		return numAjudas;
	}
	
	public int pedirAjudaOnline (String matriculaAluno, String disciplina) {
		AjudaOnline novaAjuda = new AjudaOnline(matriculaAluno, disciplina);	
		this.numAjudas++;
		return numAjudas;
	}

	public String addTutor(int idAjuda) {
		return null;
	}

}
