package controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.AtributoAluno;
import models.Aluno;
import models.Tutor;

public class Sistema {
	
	private Map<String, Aluno> alunos;
	private Map<String, Tutor> tutores;
	private Comparator<Aluno> ordenadorAlunos;
	
	public Sistema() {
		this.alunos = new HashMap<String, Aluno>();
		this.tutores = new HashMap<String, Tutor>();
		this.ordenadorAlunos = new AlunoPorNome();
	}
	
	private void verificarAlunoRepetido(String matricula, String msg) {
		if (this.alunos.containsKey(matricula)) {
			throw new IllegalArgumentException(msg);
		}
	}
	
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		try {
			Aluno aluno = new Aluno(nome, matricula, codigoCurso, telefone, email);
			this.verificarAlunoRepetido(matricula, "Aluno de mesma matricula ja cadastrado");
			
			this.alunos.put(matricula, aluno);
		}
		
		catch (IllegalArgumentException e1) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: " + e1.getMessage());
		}
		
		catch (NullPointerException e2) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: " + e2.getMessage());
		}
	}
	
	private void verificarAlunoInexistente(String matricula, String msg) {
		if (!this.alunos.containsKey(matricula)) {
			throw new IllegalArgumentException(msg);
		}
	}
	
	public String recuperaAluno(String matricula) {
		try {
			this.verificarAlunoInexistente(matricula, "Aluno nao encontrado");
			return this.alunos.get(matricula).toString();
		}
		
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro na busca por aluno: " + e.getMessage());
		}
	}
	
	private List<Aluno> ordenarAlunos() {
		List<Aluno> alunosPorNome = new ArrayList<Aluno>();
		alunosPorNome.addAll(this.alunos.values());
		alunosPorNome.sort(this.ordenadorAlunos);
		
		return alunosPorNome;
	}
	
	public String listarAlunos() {
		String listagemAlunos = "";
		for (int i = 0; i < this.ordenarAlunos().size() - 1; i++) {
			listagemAlunos += ordenarAlunos().get(i).toString() + ", ";
		}
		
		listagemAlunos += ordenarAlunos().get(ordenarAlunos().size() - 1).toString();
		return listagemAlunos;
	}
	
	public String getInfoAluno(String matricula, String atributo) {
		try {
			this.verificarAlunoInexistente(matricula, "Aluno nao encontrado");
			return AtributoAluno.valueOf(atributo.toUpperCase()).getAtributo(this.alunos.get(matricula));			
		}
		
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro na obtencao de informacao de aluno: " + e.getMessage());
		}
	}
	
	private void criarNovoTutor(String matricula) {
		Aluno aluno = alunos.get(matricula);
		this.tutores.put(aluno.getMatricula(), new Tutor(aluno.getNome(), aluno.getMatricula(),
			    aluno.getCodigoCurso(), aluno.getTelefone(), aluno.getEmail()));
	}
	
	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		try {
			this.verificarAlunoInexistente(matricula, "Tutor nao encontrado");
			
			if (!this.tutores.keySet().contains(matricula)) {
				this.criarNovoTutor(matricula);
			}
			
			this.tutores.get(matricula).adicionarTutoria(disciplina, proficiencia);
		}
		
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro na definicao de papel: " + e.getMessage());
		}
	}
	
	public String recuperaTutor(String matricula) {
		try {
			this.verificarAlunoInexistente(matricula, "Tutor nao encontrado");
			return this.tutores.get(matricula).toString();
		}
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro na busca por tutor: " + e.getMessage());
		}
		
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
	
	public void cadastrarHorario(String email, String horario, String dia) {
		this.tutores.get(email).cadastrarHorario(horario, dia);
	}
	
	public void cadastrarLocalDeAtendimento(String email, String local) {
		this.tutores.get(email).cadastrarLocalDeAtendimento(local);
	}
	
	public boolean consultaHorario(String email, String horario, String dia) {
		return tutores.get(email).consultaHorario(horario, dia);
	}
	
	public boolean consultaLocal(String email, String local) {
		return tutores.get(email).consultaLocal(local);
	}

}
