package models;

public class Aluno extends Pessoa {
	
	private String matricula;
	private int codigoCurso;
	private double nota;
	
	public Aluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		super(nome, telefone, email);
		
		this.matricula = matricula.trim();
		this.codigoCurso = codigoCurso;
		this.nota = 5.0;
	}
	
	public String getMatricula() {
		return this.matricula;
	}
	
	public String getCodigoCurso() {
		return Integer.toString(this.codigoCurso);
	}
	
	public String getNota() {
		return Double.toString(this.nota);
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		String toString = this.getMatricula() + " - " + this.getNome() + " - " + this.getCodigoCurso() + " - ";
					
		if (!this.getTelefone().isEmpty()) {
			toString += this.getTelefone() + " - ";
		}
		
		return toString + this.getEmail();
	}	

}