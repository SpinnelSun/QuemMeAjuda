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
		return disciplina;
	}

	public int getProficiencia() {
		return proficiencia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((disciplina == null) ? 0 : disciplina.hashCode());
		
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) { return true; }
		
		if (obj == null) { return false; }
		
		if (getClass() != obj.getClass()) { return false; }
		
		Tutoria other = (Tutoria) obj;
		
		if (disciplina == null) {
			if (other.disciplina != null) { return false; }
		} 
		
		if (disciplina.equals(other.disciplina)) { return true; }
		
		return true;
	}

	@Override
	public String toString() {
		return this.getDisciplina() + " - " + this.getProficiencia();
	}
	
}
