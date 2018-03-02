package models;

public abstract class Ajuda {
	
	private String disciplina;
	
	public Ajuda(String disciplina) {
		this.disciplina = disciplina;
	}
	
	@Override
	public String toString() {
		return this.disciplina;
	}
	
}
