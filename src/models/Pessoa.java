package models;

public abstract class Pessoa {
	
	private String nome;
	private String telefone;
	private String email;
	
	public Pessoa(String nome, String email) {
		this.nome = nome.trim();
		this.email = email.trim();
		this.telefone = "";
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

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
