package models;

public abstract class Pessoa {
	
	private String nome;
	private String telefone;
	private String email;
	
	public Pessoa(String nome, String telefone, String email) {
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
