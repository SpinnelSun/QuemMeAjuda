package models;

public class Aluno {
	
	private String matricula;
	private String nome;
	private int codigoCurso;
	private String telefone;
	private String email;
	private double nota;
	
	public Aluno(String matricula, String nome, int codigoCurso, String email) {
		this.nome = nome.trim();
		this.matricula = matricula.trim();
		this.codigoCurso = codigoCurso;
		this.email = email.trim();
		
		this.telefone = "";
		this.nota = 5.0;
	}

	public Aluno(String matricula, String nome,  int codigoCurso, String telefone, String email) {
		this(nome, matricula, codigoCurso, email);
		this.telefone = telefone.trim();
	}
	
	public String getMatricula() {
		return this.matricula;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public int getCodigoCurso() {
		return this.codigoCurso;
	}
	
	public String getTelefone() {
		return this.telefone;
	}
	
	public String getEmail() {
		return this.email;
	}

	public double getNota() {
		return this.nota;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		String toString = "";
		toString += this.getMatricula() + " - " + this.getNome() + " - " + this.getCodigoCurso() + " - ";
					
		if (!this.getTelefone().isEmpty())
			toString += this.getTelefone();
		
		return toString + this.getEmail();
	}	

}
