package controllers;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Comparator;

import models.InfoAluno;
import models.Ordenacao;
import models.Academico;
import models.Aluno;

/**
 * Representacao do Controlador dos Alunos cadastrados no Sistema do Quem Me Ajuda. Como atributos,
 * o AlunoController possui um Map contendo os Alunos cadastrados (mapeados a partir de suas respec-
 * tivas matriculas) e um Comparator que define a atual ordenacao desses Alunos.
 * 
 * Laboratorio de Programacao 2 - Projeto de Laboratorio - Quem Me Ajuda
 * 
 * @author Mateus de Lima Oliveira  - 117110219
 * @author Matheus Alves dos Santos - 117110503
 * @author Misael Augusto Silva da Costa - 117110525
 *
 */
public class AlunoController {
	
	private Map<String, Aluno> alunos;
	private Comparator<Academico> ordenadorAlunos;
	
	/**
	 * Constroi o AlunoController. O Map de Alunos sera inicialmente vazio, enquanto a ordenacao
	 * dos Alunos sera inicialmente feita a partir de seus respectivos nomes.
	 * 
	 */
	public AlunoController() {
		this.alunos = new HashMap<String, Aluno>();
		this.ordenadorAlunos = new AcademicoPorNome();
	}
	
	/**
	 * Retorna a quantidade de Alunos atualmente mapeados pelo AlunoController. 
	 * 
	 * @returns A quantidade atual de Alunos cadastrados.
	 * 
	 */
	public int getTotalAlunos() {
		return this.alunos.size();
	}
	
	/**
	 * Verifica se ja existe cadastro de um Aluno cuja matricula e a informada atraves do primeiro
	 * parametro desse metodo. Caso o Aluno ja tenha sido cadastrado, uma excecao adequada sera lan-
	 * cada com a mensagem tambem informada como parametro.
	 * 
	 * @param matricula A matricula do Aluno a ser verificada.
	 * @param msg A mensagem a ser associada a excecao possivelmente lancada.
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
	 * A partir das informacoes passada como parametros desse metodo, cria um novo Aluno e o mapeia
	 * a partir de sua matricula. Caso a matricula informada pertenca a algum Aluno ja cadastrado, a
	 * excecao adequada sera lancada.
	 * 
	 * @param nome O nome do Aluno a ser cadastrado.
	 * @param matricula A matricula do Aluno a ser cadastrado.
	 * @param codigoCurso O codigo do curso do Aluno a ser cadastrado.
	 * @param telefone O telefone do Aluno a ser cadastrado.
	 * @param email O email do Aluno a ser cadastrado.
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
	 * Verifica se existe cadastro de um Aluno cuja matricula e a informada atraves do primeiro pa-
	 * rametro desse metodo. Caso o Aluno nao tenha sido cadastrado, uma excecao adequada sera lan-
	 * cada com a mensagem tambem informada como parametro.
	 * 
	 * @param matricula A matricula do Aluno a ser verificada.
	 * @param msg A mensagem a ser associada a excecao possivelmente lancada.
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
	 * Retorna a representacao textual de um dos Alunos cadastrados. O Aluno a ser recuperado sera
	 * aquele cuja matricula for informada como parametro do metodo. Caso a matricula informada nao
	 * pertenca a nenhum dos Alunos cadastrados, a excecao adequada sera lancada.
	 * 
	 * @param matricula A matricula do Aluno a ser acessado.
	 * 
	 * @returns A representacao textual do Aluno de interesse.
	 * 
	 */
	public String recuperaAluno(String matricula) {
		this.impedirAlunoNaoCadastrado(matricula, "Aluno nao encontrado");
		return this.alunos.get(matricula).toString();
	}
	
	/**
	 * A partir do atributo ordenadorAlunos de AlunoController, esse metodo retornara a lista dos
	 * Alunos cadastrados organizando-os de acordo com a ordem atualmente configurada.
	 * 
	 * @returns A List ordenada dos Alunos cadastrados.
	 * 
	 */
	private List<Aluno> ordenarAlunos() {
		List<Aluno> listaDeAlunos = new ArrayList<Aluno>();
		listaDeAlunos.addAll(this.alunos.values());
		listaDeAlunos.sort(this.ordenadorAlunos);
		
		return listaDeAlunos;
	}
	
	/**
	 * Retorna a listagem dos Alunos atualmente cadastrados. Cada Aluno sera representado por seu
	 * respectivo toString(). A listagem sera feita em linha unica (separando os Alunos por virgu-
	 * la).
	 * 
	 * @returns A listagem dos Alunos cadastrados.
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
	 * Retorna a representacao textual de um dos atributos de um Aluno ja cadastrado. O Aluno que
	 * tera o atributo recuperado e aquele cuja matriculada for igual a informada como parametro
	 * do metodo. Caso nenhum dos Alunos cadastrados possua a matricula informada, a excecao ade-
	 * quada sera lancada.
	 * 
	 * @param matricula A matricula do Aluno de interesse na consulta.
	 * @param atributo O nome do atributo de interesse na consulta.
	 * 
	 * @returns A informacao desejada sobre o Aluno consultado.
	 * 
	 */
	public String getInfoAluno(String matricula, String atributo) {
		this.impedirAlunoNaoCadastrado(matricula, "Aluno nao encontrado");
		return InfoAluno.valueOf(atributo.toUpperCase()).getInfo(this.alunos.get(matricula));			
	}
	
	/**
	 * Modifica a ordenacao utilizada em listarAlunos() para gerar uma listagem dos Alunos cadas-
	 * trados.
	 * 
	 * @param atributo O nome do atributo a ser utilizado para a ordenacao.
	 * 
	 * @returns null.
	 * 
	 */
	public void configurarOrdem(String atributo) {
		this.ordenadorAlunos = Ordenacao.valueOf(atributo.toUpperCase()).definirOrdenacao();
	}

}