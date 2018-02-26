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
	
	private void verificarMatriculaRepetida(String matricula) {
		if (this.alunos.containsKey(matricula)) {
			throw new IllegalArgumentException("Aluno de mesma matricula ja cadastrado");
		}
	}
	
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		try {
			Aluno aluno = new Aluno(nome, matricula, codigoCurso, telefone, email);
			this.verificarMatriculaRepetida(matricula);
			
			this.alunos.put(matricula, aluno);
		}
		
		catch (IllegalArgumentException e1) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: " + e1.getMessage());
		}
		
		catch (NullPointerException e2) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: " + e2.getMessage());
		}
	}
	
	private void verificarMatriculaInexistente(String matricula) {
		if (!this.alunos.containsKey(matricula)) {
			throw new IllegalArgumentException("Aluno nao encontrado");
		}
	}
	
	private void verificarMatriculaInexistenteTutor(String matricula) {
		boolean tem = false;
		
		for(Tutor t: tutores.values()) {
			if(t.getMatricula().equals(matricula))
				tem = true;
		}
		
		if(!tem)
			throw new IllegalArgumentException("Tutor nao encontrado");
	}

	private void verificaProficiencia(int proficiencia) {
		if(proficiencia < 0)
			throw new IllegalArgumentException("Proficiencia invalida");
	}
	
	public String recuperaAluno(String matricula) {
		try {
			this.verificarMatriculaInexistente(matricula);
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
	
	private List<Tutor> ordenarTutores() {
		List<Tutor> tutoresPorNome = new ArrayList<Tutor>();
		tutoresPorNome.addAll(this.tutores.values());
		tutoresPorNome.sort(this.ordenadorAlunos);
		
		return tutoresPorNome;
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
			this.verificarMatriculaInexistente(matricula);
			return AtributoAluno.valueOf(atributo.toUpperCase()).getAtributo(this.alunos.get(matricula));			
		}
		
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro na obtencao de informacao de aluno: " + e.getMessage());
		}
	}
	
	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		try {
			this.verificaProficiencia(proficiencia);
			Aluno a = alunos.get(matricula);
			
			Tutor t = new Tutor(a.getNome(), a.getMatricula(), Integer.parseInt(a.getCodigoCurso()),
					a.getTelefone(), a.getEmail(), disciplina, proficiencia);

			tutores.put(t.getEmail(), t);
		}
		
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro na definicao de papel: " + e.getMessage());
		}
	}
	
	public String recuperaTutor(String matricula) {
		try {
			this.verificarMatriculaInexistenteTutor(matricula);
			return this.tutores.get(alunos.get(matricula).getEmail()).toString();
		}
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro na busca por tutor: " + e.getMessage());
		}
		
	}
	
	public String listarTutores() {
		String listagemTutores = "";
		
		for (int i = 0; i < this.ordenarTutores().size() - 1; i++) {
			listagemTutores += ordenarTutores().get(i).toString() + ", ";
		}
		
		listagemTutores += ordenarTutores().get(ordenarTutores().size() - 1).toString();		
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
