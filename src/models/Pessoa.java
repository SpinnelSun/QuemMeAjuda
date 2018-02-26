package models;

import utility.Validador;

public abstract class Pessoa {
	
	private String nome;
	private String telefone;
	private String email;
	
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