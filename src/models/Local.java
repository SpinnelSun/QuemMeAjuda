package models;

import utility.Validador;

public class Local {
	
	private String nome;
	
	public Local(String nome) {
		Validador.validarStringNaoVaziaNaoNula("local nao pode ser vazio ou em branco", nome);
		
		this.nome = nome.trim();
	}

	public String getNome() {
		return this.nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		
		return result;
	}

	@Override
	public boolean equals(Object object) {
		
		Local other = (Local) object;
		
		if (this == object) { return true; }
		
		if (object == null) { return false; }
		
		if (getClass() != object.getClass()) { return false; }
		
		if (this.nome.equals(other.nome)) {	return true; }
		
		return false;
	}

	@Override
	public String toString() {
		return this.getNome();
	}
	
}
