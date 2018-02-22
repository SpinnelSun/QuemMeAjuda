package models;

import java.util.HashSet;

public class Tutor extends Aluno {
	
	private String disciplina;
	
	private int proficiencia;
	
	private HashSet<String> horariosAtendimento;
	
	private HashSet<String> locaisAtendimento;
	
	public Tutor(String matricula, String nome, String codigoCurso, String email, String disciplina, int proficiencia) {
		super(nome, matricula, codigoCurso, email);
			
		this.disciplina = disciplina;
			
		this.proficiencia = proficiencia;
		
		this.horariosAtendimento = new HashSet<>();
		
		this.locaisAtendimento = new HashSet<>();
	}
	
	public String getDisciplina() {
		return this.disciplina;
	}
	
	public int getProficiencia() {
		return this.proficiencia;
	}
	
	public void cadastraHorario(String horario, String dia) {
		this.horariosAtendimento.add(horario + " - " + dia);
	}
	
	public void cadastraLocal(String local) {
		this.locaisAtendimento.add(local);
	}
	
	public boolean consultaHorario(String horario, String dia) {
		String horarioConsultado = horario + " - " + dia;
	
		for (String horarioAtendimento : this.horariosAtendimento) {
			if (horarioConsultado.equals(horarioAtendimento)) {
				return true;
			}
		}
		
		return false;
	}

	public boolean consultaLocal(String localConsultado) {
		
		for (String localAtendimento : this.horariosAtendimento) {
			if (localConsultado.equals(localAtendimento)) {
				return true;
			}
		}
		
		return false;
	}
	
}
