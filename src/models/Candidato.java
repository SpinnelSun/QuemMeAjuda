package models;

public class Candidato {
	
	private String matricula;
	private int proficiencia;
	private int numeroCadastro;
	
	public Candidato(String matricula, int proficiencia, int numeroCadastro) {
		this.matricula = matricula;
		this.proficiencia = proficiencia;
		this.numeroCadastro = numeroCadastro;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public int getProficiencia() {
		return this.proficiencia;
	}
	
	public int getNumeroCadastro() {
		return this.numeroCadastro;
	}

}
