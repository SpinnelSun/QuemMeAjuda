package models;

public class Aluno {
	
	private int matricula;
	private String nome;
	private String codigoCurso;
	private String telefone;
	private String email;
	
	public Aluno(int matricula, String nome, String codigoCurso, String email) {
		this.matricula = matricula;
		this.nome = nome;
		this.codigoCurso = codigoCurso;
		this.telefone = "";
		this.email = email;
	}

	public Aluno(int matricula, String nome, String codigoCurso, String telefone, String email) {
		this(matricula, nome, codigoCurso, email);
		this.telefone = telefone;
	}
	
	
	public int getMatricula() {
		return matricula;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCodigoCurso() {
		return codigoCurso;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public String getEmail() {
		return email;
	}	

}
