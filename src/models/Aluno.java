package models;

public class Aluno extends Pessoa {
	
	private String matricula;
	private String codigoCurso;
	private double nota;
	
	public Aluno(String nome, String matricula, String codigoCurso, String email) {
		super(nome, email);
		
		this.matricula = matricula.trim();
		this.codigoCurso = codigoCurso;
		this.nota = 5.0;
	}

	public Aluno(String matricula, String nome, String codigoCurso, String telefone, String email) {
		this(matricula, nome, codigoCurso, email);
		this.setTelefone(telefone);
	}
	
	public String getMatricula() {
		return this.matricula;
	}
	
	public String getCodigoCurso() {
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