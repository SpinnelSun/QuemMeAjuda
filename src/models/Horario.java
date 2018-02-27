package models;

import utility.Validador;

public class Horario {
	
	private String horario;
	private String dia;
	
	public Horario(String horario, String dia) {
		Validador.validarStringNaoVaziaNaoNula("horario nao pode ser vazio ou em branco", horario);
		Validador.validarStringNaoVaziaNaoNula("dia nao pode ser vazio ou em branco", dia);
		
		this.horario = horario.trim();
		this.dia = dia.trim();
	}

	public String getHorario() {
		return this.horario;
	}

	public String getDia() {
		return this.dia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((this.dia == null) ? 0 : this.dia.hashCode());
		result = prime * result + ((this.horario == null) ? 0 : this.horario.hashCode());
		
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		Horario other = (Horario) obj;
		
		if (this == obj) { return true; }
		
		if (obj == null) { return false; }
		
		if (getClass() != obj.getClass()) { return false; }
		
		if (this.dia.equals(other.dia) && (this.horario.equals(other.horario))) {
			return true;
		}
		
		return false;
	}

	@Override
	public String toString() {
		return this.getHorario() + " - " + this.getDia();
	}

}
