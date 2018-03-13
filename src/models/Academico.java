package models;

import java.io.Serializable;

import utility.Validador;

/**
 * Representacao abstrata de um Academico. Como atributos, cada Academico possui o nome, o telefone,
 * o email e a matricula representados em Strings, alem do codigo do curso ao qual e vinculado repre-
 * sentado em int.
 * 
 * Laboratorio de Programacao 2 - Projeto de Laboratorio - Quem Me Ajuda
 * 
 * @author Mateus de Lima Oliveira  - 117110219
 * @author Matheus Alves dos Santos - 117110503
 * @author Misael Augusto Silva da Costa - 117110525
 *
 */

public abstract class Academico implements Serializable {
	
	private String nome;
	private String matricula;
	private int codigoCurso;
	private String telefone;
	private String email;
	
	/**
	 * Constroi um Academico a partir de seu nome, de seu telefone, de seu email, de sua matricula,
	 * e do codigo de seu curso de vinculo. Nao e permitida a criacao de Academicos com atributos
	 * vazios e/ou nulos. Excetua-se o telefone, que podera ser uma String vazia (telefone nao in-
	 * formado). O codigo do curso nao podera ser inferior a 1. 
	 * 
	 * @param nome O nome do Academico.
	 * @param matricula A matricula do Academico.
	 * @param codigoCurso O codigo do curso do Academico.
	 * @param telefone O numero do telefone do Academico.
	 * @param email O email do Academico.
	 * 
	 */
	public Academico(String nome, String telefone, String email, String matricula, int codigoCurso) {
		this.validarAtributos(nome, telefone, email, matricula, codigoCurso);
		
		this.nome = nome.trim();
		this.telefone = telefone.trim();
		this.email = email.trim();
		this.matricula = matricula.trim();
		this.codigoCurso = codigoCurso;
	}
	
	/**
	 * Valida os atributos a serem usados na construcao de um Academico. Nao e permitida a criacao
	 * de Academicos com atributos vazios e/ou nulos. Excetua-se o telefone, que podera ser uma String
	 * vazia (telefone nao informado). O codigo do curso nao podera ser inferior a 1. 
	 * 
	 * @param nome O nome do Academico.
	 * @param matricula A matricula do Academico.
	 * @param codigoCurso O codigo do curso do Academico.
	 * @param telefone O numero do telefone do Academico.
	 * @param email O email do Academico.
	 * 
	 * @returns null.
	 * 
	 */
	private void validarAtributos(String nome, String telefone, String email, String matricula, int codigoCurso) {
		Validador.validarEmail("Email invalido", email);
		Validador.validarStringNaoVaziaNaoNula("Nome nao pode ser vazio ou nulo", nome);
		Validador.validarStringNaoNula("Telefone nao pode ser vazio ou nulo", telefone);
		Validador.validarStringNaoVaziaNaoNula("Matricula nao pode ser vazia ou nula", matricula);
		Validador.validarInteiroPositivo("Codigo do curso nao pode ser menor que 1", codigoCurso);
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getTelefone() {
		return this.telefone;
	}
	
	public String getEmail() {
		return this.email;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public int getCodigoCurso() {
		return this.codigoCurso;
	}
	
	/**
	 * Retorna a representacao textual de um Academico a partir de seus atributos. Segue os padrões:
	 * MATRICULA - NOME - CODIGOCURSO - TELEFONE - EMAIL ou MATRICULA - NOME - CODIGOCURSO - EMAIL
	 * (em caso de telefone nao informado).
	 * 
	 * @returns A representacao textual do Academico.
	 * 
	 */
	@Override
	public String toString() {
		String toString = this.getMatricula() + " - " + this.getNome() + " - " + this.getCodigoCurso() + " - ";
					
		if (!this.getTelefone().isEmpty()) {
			toString += this.getTelefone() + " - ";
		}
		
		return toString + this.getEmail();
	}	

}