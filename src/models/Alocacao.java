package models;

import java.util.List;

public class Alocacao {
	private List<String> locaisDeAtendimento;
	private List<String> diasDeAtendimento;
	private String horarioDeAtendimento;
	
	
	public List<String> getLocaisDeAtendimento() {
		return locaisDeAtendimento;
	}
	public void setLocaisDeAtendimento(String locailDeAtendimento) {
		this.locaisDeAtendimento.add(locailDeAtendimento);
	}
	public List<String> getDiasDeAtendimento() {
		return diasDeAtendimento;
	}
	public void setDiasDeAtendimento(String dia) {
		this.diasDeAtendimento.add(dia);
	}
	public String getHorarioDeAtendimento() {
		return horarioDeAtendimento;
	}
	public void setHorarioDeAtendimento(String horarioDeAtendimento) {
		this.horarioDeAtendimento = horarioDeAtendimento;
	}
	
	

}
