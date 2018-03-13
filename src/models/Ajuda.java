package models;

import java.io.Serializable;

import utility.Validador;

/**
 * Representacao abstrata de uma Ajuda. Como atributos, cada Ajuda possui o nome da disciplina, a ma- 
 * tricula do Aluno solicitante e a matricula do Tutor responsavel representadas em String, alem de
 * um boolean que sinaliza se a Ajuda em questao ja foi avaliada.
 * 
 * Laboratorio de Programacao 2 - Projeto de Laboratorio - Quem Me Ajuda
 * 
 * @author Mateus de Lima Oliveira  - 117110219
 * @author Matheus Alves dos Santos - 117110503
 * @author Misael Augusto Silva da Costa - 117110525
 *
 */
public abstract class Ajuda implements Serializable {
	
	private String disciplina;
	private String matriculaAluno;
	private String matriculaTutor;
	private boolean avaliacaoConcluida;
	
	/**
	 * Constroi uma Ajuda a partir da matricula do Aluno solicitante, do nome da disciplina de inte-
	 * resse e da matricula do Tutor responsavel por aquela Ajuda. Nao e permitida a criacao de Aju-
	 * das cujos atributos sejam nulos, tampouco com matriculaAluno e/ou disciplina vazios. Caso nao
	 * haja Tutor para prestar a Ajuda, matriculaTutor devera ser uma String vazia. 
	 * 
	 * @param matriculaAluno A matricula do Aluno solicitante.
	 * @param disciplina O nome da disciplina de interesse.
	 * @param matriculaTutor A matricula do Tutor responsavel.
	 * 
	 */
	public Ajuda(String matriculaAluno, String disciplina, String matriculaTutor) {
		this.validarAtributos(matriculaAluno, disciplina, matriculaTutor);
		
		this.disciplina = disciplina;
		this.matriculaAluno = matriculaAluno;
		this.matriculaTutor = matriculaTutor;
		this.avaliacaoConcluida = false;
	}
	
	/**
	 * Valida os atributos a serem usados na construcao de uma Ajuda. Nao e permitida a criacao de 
	 * Ajudas cujos atributos sejam nulos, tampouco com matriculaAluno ou disciplina vazios. Caso 
	 * nao haja Tutor para prestar a Ajuda, matriculaTutor devera ser uma String vazia. 
	 * 
	 * @param matriculaAluno A matricula do Aluno solicitante.
	 * @param disciplina O nome da disciplina de interesse.
	 * @param matriculaTutor A matricula do Tutor responsavel.
	 * 
	 * @returns null.
	 * 
	 */
	private void validarAtributos(String matriculaAluno, String disciplina, String matriculaTutor) {
		Validador.validarStringNaoVaziaNaoNula("matricula de aluno nao pode ser vazio ou em branco", matriculaAluno);
		Validador.validarStringNaoVaziaNaoNula("disciplina nao pode ser vazio ou em branco", disciplina);
		Validador.validarStringNaoNula("matricula de tutor nao pode ser vazio", matriculaTutor);
	}

	public String getDisciplina() {
		return this.disciplina;
	}

	public String getMatriculaAluno() {
		return this.matriculaAluno;
	}
	
	public String getMatriculaTutor() {
		return this.matriculaTutor;
	}
	
	public boolean getAvaliacaoConcluida() {
		return this.avaliacaoConcluida;
	}
	
	/**
	 * Retorna a representacao textual de um dos atributos de uma Ajuda. O atributo a ser retornado
	 * deve ser especificado atraves de seu nome (passado como parametro desse metodo). Havera lan-
	 * camento de excecoes caso o atributo requisitado seja vazio, nulo ou inexistente para Ajuda.
	 * 
	 * @param atributo O nome do atributo a ser recuperado.
	 * 
	 * @returns A representacao textual de um atributo de Ajuda.
	 * 
	 */
	public String getInfo(String atributo) {
		Validador.validarStringNaoVaziaNaoNula("atributo nao pode ser vazio ou em branco", atributo);
		InfoAjuda.impedirAtributoInexistente(atributo.toUpperCase());
		
		return InfoAjuda.valueOf(atributo.toUpperCase()).getInfo(this);
	}
	
	/**
	 * Atraves do lancamento de uma excecao adequada, impede que uma Ajuda seja avaliada mais de uma
	 * vez.
	 * 
	 * @returns null.
	 * 
	 */
	private void impedirReavaliacao() {
		if (this.avaliacaoConcluida) { throw new IllegalArgumentException("Ajuda ja avaliada"); }
	}
	
	/**
	 * Registra a realizacao de avaliacao de uma Ajuda, modificado seu atributo avaliacaoConcluida
	 * para o valor booleano true. Caso esse metodo seja executado por uma Ajuda ja avaliada, ocor-
	 * re o lancamento de uma excecao.
	 * 
	 * @returns null.
	 * 
	 */
	public void registrarAvaliacao() {
		this.impedirReavaliacao();
		this.avaliacaoConcluida = true;
	}
	
}
