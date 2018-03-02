package controllers;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Comparator;

import models.AtributoAluno;
import models.Aluno;


public class AlunoController {
	
	private Map<String, Aluno> alunos;
	private Comparator<Aluno> ordenadorAlunos;
	
	public AlunoController() {
		this.alunos = new HashMap<String, Aluno>();
		this.ordenadorAlunos = new AlunoPorNome();
	}
	
	private void impedirCadastroAlunoRepetido(String matricula, String msg) {
		if (this.alunos.containsKey(matricula)) {
			throw new IllegalArgumentException(msg);
		}
	}
	
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		Aluno aluno = new Aluno(nome, matricula, codigoCurso, telefone, email);
		this.impedirCadastroAlunoRepetido(matricula, "Aluno de mesma matricula ja cadastrado");
			
		this.alunos.put(matricula, aluno);
	}
	
	public void impedirAlunoNaoCadastrado(String matricula, String msg) {
		if (!this.alunos.containsKey(matricula)) {
			throw new IllegalArgumentException(msg);
		}
	}
	
	public String recuperaAluno(String matricula) {
		this.impedirAlunoNaoCadastrado(matricula, "Aluno nao encontrado");
		return this.alunos.get(matricula).toString();
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
		this.impedirAlunoNaoCadastrado(matricula, "Aluno nao encontrado");
		return AtributoAluno.valueOf(atributo.toUpperCase()).getAtributo(this.alunos.get(matricula));			
	}

}