package models;

public enum NivelAvaliacao {
	
	ALTO("TOP") ,
	
	MEDIO("Tutor") ,
	
	BAIXO("Aprendiz") ;
	
	private String nivel;
	
	NivelAvaliacao(String nivel) {
		this.nivel = nivel;
	}
	
	@Override
	public String toString() {
		return this.nivel;
	}

}