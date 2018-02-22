package models;

public class Aluno {
	
	private int matricula;
	private String nome;
	private String codigoCurso;
	private String telefone;
	private String email;
	private double nota;
	
	public Aluno(String nome, int matricula, String codigoCurso, String email) {
		this.nome = nome;
		this.matricula = matricula;
		this.codigoCurso = codigoCurso;
		this.telefone = "";
		this.email = email;
		this.nota = 5.0;
	}

	public Aluno(int matricula, String nome, String codigoCurso, String telefone, String email) {
		this(nome,matricula, codigoCurso, email);
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

	@Override
	public String toString() {
		if(this.getTelefone().trim().equals(""))
			return this.matricula + " - " + this.nome + " - " + this.codigoCurso + " - " + this.email;
		
		return this.matricula + " - " + this.nome + " - " + this.codigoCurso + " - " + this.telefone + " - " + this.email;
	}	
	
	

}
