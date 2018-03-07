package controllers;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Comparator;

import models.InfoAluno;
import models.Academico;
import models.Aluno;


public class AlunoController {
	
	private Map<String, Aluno> alunos;
	private Comparator<Academico> ordenadorAlunos;
	
	/**
	 * Constroi um controlador para aluno, inicializando a colecao ultizada para armazenar alunos e especificando o tipo de ordena-
	 * cao que sera ultilizada na listagem de alunos.
	 * 
	 */
	public AlunoController() {
		this.alunos = new HashMap<String, Aluno>();
		this.ordenadorAlunos = new AcademicoPorNome();
	}
	
	/**
	 * Retorna a quantidade de Alunos cadastrados no sistema.
	 * 
	 * @returns int A quantidadede alunos cadastrados.
	 * 
	 */
	public int quantAlunos() {
		return alunos.size();
	}
	
	/**
	 * Metodo auxiliar que impede o cadastro de alunos de mesma matricula, ou seja, de alunos repetidos. Sendo retornado uma
	 * excecao caso esta tentativa de cadastro seja feita.
	 * 
	 * @param matricula Matricula do aluno a ser analisada.
	 * @param msg Mensagem retornada caso a matricula ja esteja cadastrada.
	 * 
	 * @returns null.
	 * 
	 */
	private void impedirCadastroAlunoRepetido(String matricula, String msg) {
		if (this.alunos.containsKey(matricula)) {
			throw new IllegalArgumentException(msg);
		}
	}
	
	/**
	 * Realiza o cadastro de Aluno no Sistema. Sendo passado o nome, matricula, codigo do curso e email obrigatoriamente,
	 * nao e permitido cadastro de alunos com matriculas ja cadastradas ou com demais atributos vazios (apenas telefone),
	 * nulos ou invalidos
	 * 
	 * @param nome O nome do Aluno.
	 * @param matricula A matricula do Aluno.
	 * @param codigoCurso O codigo do curso do Aluno.
	 * @param telefone O telefone do Aluno.
	 * @param email O email do Aluno.
	 * 
	 * @returns null.
	 * 
	 */
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		Aluno aluno = new Aluno(nome, matricula, codigoCurso, telefone, email);
		this.impedirCadastroAlunoRepetido(matricula, "Aluno de mesma matricula ja cadastrado");
			
		this.alunos.put(matricula, aluno);
	}
	
	/**
	 * Metodo auxiliar que impede recuperacao de alunos que nao estejam com matriculas no sistema, ou seja, de alunos 
	 * nao cadastrados. Sendo retornado uma excecao caso esta tentativa de cadastro seja feita.
	 * 
	 * @param matricula Matricula do aluno a ser analisada.
	 * @param msg Mensagem retornada caso a matriculan nao esteja cadastrada.
	 * 
	 * @returns null.
	 * 
	 */
	public void impedirAlunoNaoCadastrado(String matricula, String msg) {
		if (!this.alunos.containsKey(matricula)) {
			throw new IllegalArgumentException(msg);
		}
	}
	
	/**
	 * Realiza uma busca pelo matricula e retorna a representacao de um Aluno desejado. 
	 * A partir da matricula do Aluno eh retornado o Aluno.
	 * 
	 * @param matricula Matricula do Aluno.
	 * 
	 * @returns String Representacao textual do aluno, contendo suas informacoes.
	 * 
	 */
	public String recuperaAluno(String matricula) {
		this.impedirAlunoNaoCadastrado(matricula, "Aluno nao encontrado");
		return this.alunos.get(matricula).toString();
	}
	
	/**
	 * Metodo auxiliar que faz a ordenacao de alunos por ordem alfabetica para poderem ser listados.
	 * 
	 * @returns List<> Lista de alunos ordenados pelo nome.
	 * 
	 */
	private List<Aluno> ordenarAlunos() {
		List<Aluno> alunosPorNome = new ArrayList<Aluno>();
		alunosPorNome.addAll(this.alunos.values());
		alunosPorNome.sort(this.ordenadorAlunos);
		
		return alunosPorNome;
	}
	
	/**
	 * Retorna uma lista de representacoes de um Alunos registrados no sistema em ordem alfabetica pelo nome. 
	 * 
	 * @returns String Lista de alunos.
	 * 
	 */
	public String listarAlunos() {
		String listagemAlunos = "";
		for (int i = 0; i < this.ordenarAlunos().size() - 1; i++) {
			listagemAlunos += ordenarAlunos().get(i).toString() + ", ";
		}
		
		listagemAlunos += ordenarAlunos().get(ordenarAlunos().size() - 1).toString();
		return listagemAlunos;
	}
	
	/**
	 * Realiza uma busca pelo valor armazenado de determinado atributo de Aluno. 
	 * A partir da Matricula do Aluno e retornada a informacao desejada (atributo) do Aluno.
	 * Nao eh possivel fazer busca por matriculas nao cadastradas ou atributos inexistentes.
	 * 
	 * @param matricula Matricula do Aluno.
	 * @param atributo Informacao desejada do aluno.
	 * 
	 * @returns String o valor do atributo desejado.
	 * 
	 */
	public String getInfoAluno(String matricula, String atributo) {
		this.impedirAlunoNaoCadastrado(matricula, "Aluno nao encontrado");
		return InfoAluno.valueOf(atributo.toUpperCase()).getInfo(this.alunos.get(matricula));			
	}

}