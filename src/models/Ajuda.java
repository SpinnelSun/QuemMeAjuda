package models;

public abstract class Ajuda {
	
	private String descricao;
	
	public Ajuda(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public abstract String toString();
	
}
