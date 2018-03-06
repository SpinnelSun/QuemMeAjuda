package controllers;

import java.util.List;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import models.AjudaPresencial;
import models.Candidato;
import models.Tutor;
import models.Habilidade;
import utility.Validador;

public class TutorController {
	
	private Map<String, Tutor> tutores;
	
	public TutorController() {
		this.tutores = new HashMap<String, Tutor>();
	}
		
	public void criarNovoTutor(String matricula, String nome, String codigoCurso, String telefone, String email) {
		if (!this.tutores.containsKey(matricula)) {
			
			this.tutores.put(matricula, new Tutor(nome, matricula, Integer.parseInt(codigoCurso), telefone,
							 email, this.tutores.size() + 1));
		}
	}
	
	public int quantTudores() {
		return this.tutores.size();
	}
	
	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
			this.tutores.get(matricula).adicionarHabilidade(disciplina, proficiencia);
	}
	
	private void impedirTutorNaoCadastrado(String matricula, String msg) {
		if (!this.tutores.containsKey(matricula)) {
			throw new IllegalArgumentException(msg);
		}
	}
	
	public String recuperaTutor(String matricula) {
		this.impedirTutorNaoCadastrado(matricula, "Tutor nao encontrado");
		return this.tutores.get(matricula).toString();
	}
	
	private List<Tutor> tutoresToList() {
		List<Tutor> listaDeTutores = new ArrayList<Tutor>();
		listaDeTutores.addAll(this.tutores.values());
		
		return listaDeTutores;
	}
	
	public String listarTutores() {
		String listagemTutores = "";
		
		for (int i = 0; i < this.tutoresToList().size() - 1; i++) {
			listagemTutores += tutoresToList().get(i).toString() + ", ";
		}
		
		listagemTutores += tutoresToList().get(tutoresToList().size() - 1).toString();		
		return listagemTutores;
	}
	
	private String getMatriculaPorEmail(String email) {
		for(Tutor tutor : this.tutoresToList()) {
			if(tutor.getEmail().equals(email)) {
				return tutor.getMatricula();
			}
		}
		
		return "";
	}
	
	public void cadastrarHorario(String email, String horario, String dia) {
		Validador.validarStringNaoVaziaNaoNula("email nao pode ser vazio ou em branco", email);
		Validador.validarStringNaoVazia("tutor nao cadastrado", this.getMatriculaPorEmail(email));
			
		this.tutores.get(this.getMatriculaPorEmail(email)).cadastrarHorario(horario, dia);
	}
	
	public void cadastrarLocalDeAtendimento(String email, String local) {
		Validador.validarStringNaoVaziaNaoNula("email nao pode ser vazio ou em branco", email);
		Validador.validarStringNaoVazia("tutor nao cadastrado", this.getMatriculaPorEmail(email));
		
		this.tutores.get(this.getMatriculaPorEmail(email)).cadastrarLocalDeAtendimento(local);
	}
	
	public boolean consultaHorario(String email, String horario, String dia) {
		try {
			Validador.validarStringNaoVaziaNaoNula("email nao pode ser vazio ou em branco", email);
			Validador.validarStringNaoVazia("tutor nao cadastrado", this.getMatriculaPorEmail(email));
			
			return this.tutores.get(this.getMatriculaPorEmail(email)).consultaHorario(horario, dia);
		}
		
		catch (IllegalArgumentException e) {
			return false;
		}
	}
	
	public boolean consultaLocal(String email, String local) {
		try {
			Validador.validarStringNaoVaziaNaoNula("email nao pode ser vazio ou em branco", email);
			Validador.validarStringNaoVazia("tutor nao cadastrado", this.getMatriculaPorEmail(email));
			
			return this.tutores.get(this.getMatriculaPorEmail(email)).consultaLocal(local);
		}
		
		catch (IllegalArgumentException e) {
			return false;
		}
	}
	
	
	

	private List<Candidato> listarCandidatos(String disciplina) {
		List<Candidato> candidatos = new ArrayList<Candidato>();
		for (Tutor tutor : this.tutoresToList()) {
			if (tutor.consultaHabilidade(disciplina)) {
				candidatos.add(new Candidato(tutor.getMatricula(), tutor.getProficiencia(disciplina),
							   tutor.getNumeroCadastro()));
			}
		}
		
		return candidatos;
	}
	
	private List<Candidato> listarCandidatos(String disciplina, String hora, String dia, String local) {
		List<Candidato> candidatos = this.listarCandidatos(disciplina);
		for (Tutor tutor : this.tutoresToList()) {
			if (tutor.consultaHabilidade(disciplina) && tutor.consultaDisponibilidade(hora, dia, local)) {
				candidatos.add(new Candidato(tutor.getMatricula(), tutor.getProficiencia(disciplina),
							   tutor.getNumeroCadastro()));
			}
		}
		
		return candidatos;
	}
	
	public String selecionarTutor(String disciplina) {
		List<Candidato> candidatos = this.listarCandidatos(disciplina);
		candidatos.sort(new CandidatoPorProficiencia());
		
		return candidatos.isEmpty() ? "" : candidatos.get(0).getMatricula();
	}
	
	public String selecionarTutor(String disciplina, String hora, String dia, String local) {
		List<Candidato> candidatos = this.listarCandidatos(disciplina, hora, dia, local);
		candidatos.sort(new CandidatoPorProficiencia());
		
		return candidatos.isEmpty() ? "" : candidatos.get(0).getMatricula();
	}
	
	public void doar(String matriculaTutor, int totalCentavos) {
		this.tutores.get(matriculaTutor).adicionarDoacao(totalCentavos);
	}
	
	public double pegarNotaDouble(String matricula) {
		return tutores.get(matricula).getNota();
	}
	
	public String pegarNota(String matricula) {
		this.impedirTutorNaoCadastrado(matricula, "Tutor nao encontrado");
		
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(tutores.get(matricula).getNota());
	}

	public String pegarNivel(String matricula) {
		this.impedirTutorNaoCadastrado(matricula, "Tutor nao encontrado");
		return tutores.get(matricula).getNivel();
	}
	
	public int getTotalDinheiro(String emailTutor) {
		return this.tutores.get(getMatriculaPorEmail(emailTutor)).getDinheiroRecebido();
	}
	
	public void adicionarAvaliacao(String matricula, int nota) {
		this.tutores.get(matricula).adicionarAvaliacao(nota);
	}
	
}
