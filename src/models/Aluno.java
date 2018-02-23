package models;

public class Aluno extends Pessoa {
	
	private String matricula;
	private int codigoCurso;
	private double nota;
	
	public Aluno(String matricula, String nome, int codigoCurso, String email) {
		super(nome, email);
		
		this.matricula = matricula.trim();
		this.codigoCurso = codigoCurso;
		this.nota = 5.0;
	}

	public Aluno(String matricula, String nome, int codigoCurso, String telefone, String email) {
		this(nome, matricula, codigoCurso, email);
		this.setTelefone(telefone);
	}
	
	public String getMatricula() {
		return this.matricula;
	}
	
	public int getCodigoCurso() {
		return this.codigoCurso;
	}
	
	public double getNota() {
		return this.nota;
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