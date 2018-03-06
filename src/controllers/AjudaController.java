package controllers;

import java.util.HashMap;
import java.util.Map;

import models.Ajuda;
import models.AjudaOnline;
import models.AjudaPresencial;
import models.InfoAjuda;
import models.InfoAluno;

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

	public String pegarTutor(int idAjuda) {
		return this.ajudas.get(idAjuda).toString();
	}
	
	public String getInfoAjuda(int idAjuda, String atributo) {
		return this.ajudas.get(idAjuda).getInfo(atributo, this.ajudas.get(idAjuda));
	}

}
