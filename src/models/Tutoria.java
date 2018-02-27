package models;

import utility.Validador;

public class Tutoria {
	
	private String disciplina;
	private int proficiencia;
	
	public Tutoria(String disciplina, int proficiencia) {
		Validador.validarStringNaoVaziaNaoNula("Disciplina nao pode ser vazia ou nula", disciplina);
		Validador.validarIntUmACinco("Proficiencia invalida", proficiencia);
		
		this.disciplina = disciplina.trim();
		this.proficiencia = proficiencia;
	}

	public String getDisciplina() {
		return this.disciplina;
	}

	public int getProficiencia() {
		return this.proficiencia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((this.disciplina == null) ? 0 : this.disciplina.hashCode());
		
		return result;
	}

	@Override
	public boolean equals(Object object) {
		
		Tutoria other = (Tutoria) object;
		
		if (this == object) { return true; }
		
		if (object == null) { return false; }
		
		if (getClass() != object.getClass()) { return false; }
		
		if (this.disciplina.equals(other.disciplina)) { return true; }
		
		return false;
	}

	@Override
	public String toString() {
		return this.getDisciplina() + " - " + this.getProficiencia();
	}
	
}
