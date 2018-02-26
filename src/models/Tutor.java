package models;

import java.util.HashSet;
import java.util.Set;

public class Tutor extends Aluno {
	
	private Set<Tutoria> tutorias;
	private int dinheiroRecebido;
	private Alocacao alocacao;
	
	public Tutor(String nome, String matricula, int codigoCurso, String telefone, String email) {
		super(nome, matricula, codigoCurso, telefone, email);
			
		this.dinheiroRecebido = 0;
		this.tutorias = new HashSet<Tutoria>();
		this.alocacao = new Alocacao();
		
		this.setNota(4.0);
	}
		
	public String getTutorias() {
		String listagemTutorias = "";
		for (Tutoria tutoria : this.tutorias) {
			listagemTutorias += tutoria.toString() + System.lineSeparator();
		}
		
		return listagemTutorias;
	}

	public int getDinheiroRecebido() {
		return this.dinheiroRecebido;
	}
	
	private void verificaTutoriaRepetida(String disciplina, int proficiencia) {
		for (Tutoria tutoria : this.tutorias) {
			if (tutoria.getDisciplina().equals(disciplina)) {
				throw new IllegalArgumentException("Ja eh tutor dessa disciplina");
			}
		}
	}
	
	public void adicionarTutoria(String disciplina, int proficiencia) {
		this.verificaTutoriaRepetida(disciplina, proficiencia);
		
		this.tutorias.add(new Tutoria(disciplina, proficiencia));
	}

	public void cadastrarHorario(String horario, String dia) {
		alocacao.setHorarioDeAtendimento(horario);
		alocacao.setDiasDeAtendimento(dia);
	}
	
	public void cadastrarLocalDeAtendimento(String local) {
		alocacao.setLocaisDeAtendimento(local);
	}
	public boolean consultaHorario(String horario, String dia) {
		if(!alocacao.getDiasDeAtendimento().contains(dia))
			return false;
		if(!alocacao.getHorarioDeAtendimento().contains(horario))
			return false;
		return true;
	}
	public boolean consultaLocal(String local) {
		if(!alocacao.getLocaisDeAtendimento().contains(local))
			return false;
		return true;
	}
	
}
