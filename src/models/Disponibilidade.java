package models;

import java.util.HashSet;
import java.util.Set;

public class Disponibilidade {
	
	private Set<Local> locais;
	private Set<Horario> horarios;
	
	public Disponibilidade() {
		this.locais = new HashSet<Local>();
		this.horarios = new HashSet<Horario>();
	}
	
	public void adicionarLocal(String nomeLocal) {
		this.locais.add(new Local(nomeLocal));
	}
	
	public void adicionarHorario(String hora, String dia) {
		this.horarios.add(new Horario(hora, dia));
	}
	
	public boolean verificarHorarioCadastrado(String hora, String dia) {
		return this.horarios.contains(new Horario(hora, dia));
	}
	
	public boolean verificarLocalCadastrado(String nomeLocal) {
		return this.locais.contains(new Local(nomeLocal));
	}

}
