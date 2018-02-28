package models;

import utility.Validador;
/**
 * Representacao abstrata de uma Pessoa. Como atribu-
 * tos, cada Pessoa possui o nome da pessoa, telefone e email.
 * 
 * Laboratorio de Programacao 2 - Projeto - Quem me ajuda
 * 
 * @author Mateus de Lima Oliveira  - 117110219
 * @author Misael Augusto Silva da Costa - 117110525
 * @author Matheus Alves dos Santos - 117110503
 *
 */
public abstract class Pessoa {
	
	private String nome;
	private String telefone;
	private String email;
	
	
	/**
	 * Constroi uma Pessoa a partir do nome, telefone (que pode ser vazio) e email.
	 * Nao eh permitido criar pessoas com nome e email vazio ou nulo.
	 * 
	 * @param nome O nome da pessoa.
	 * @param telefone O numero do telefone da pessoa.
	 * @param email O email da pessoa.
	 * 
	 */
	public Pessoa(String nome, String telefone, String email) {
		Validador.validarStringNaoVaziaNaoNula("Nome nao pode ser vazio ou nulo", nome);
		Validador.validarStringNaoNula("Telefone nao pode ser vazio ou nulo", telefone);
		Validador.validarEmail("Email invalido", email);
		
		this.nome = nome.trim();
		this.telefone = telefone.trim();
		this.email = email.trim();
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

}