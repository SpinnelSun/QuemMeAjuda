package models;

import java.util.HashSet;
import java.util.Set;

public class Tutor extends Aluno {
	
	private int dinheiroRecebido;
	private Set<Tutoria> tutorias;
	private Disponibilidade disponibilidade;
	
	public Tutor(String nome, String matricula, int codigoCurso, String telefone, String email) {
		super(nome, matricula, codigoCurso, telefone, email);
			
		this.dinheiroRecebido = 0;
		this.tutorias = new HashSet<Tutoria>();
		this.disponibilidade = new Disponibilidade();
		
		this.setNota(4.0);
	}
	
	public int getDinheiroRecebido() {
		return this.dinheiroRecebido;
	}
	
	private void verificaTutoriaRepetida(String disciplina, int proficiencia) {
		if (this.tutorias.contains(new Tutoria(disciplina, proficiencia))) {
			throw new IllegalArgumentException("Ja eh tutor dessa disciplina");
		}
	}
	
	public void adicionarTutoria(String disciplina, int proficiencia) {
		this.verificaTutoriaRepetida(disciplina, proficiencia);
		this.tutorias.add(new Tutoria(disciplina, proficiencia));
	}

	public void cadastrarHorario(String horario, String dia) {
		this.disponibilidade.adicionarHorario(horario, dia);
	}
	
	public void cadastrarLocalDeAtendimento(String local) {
		this.disponibilidade.adicionarLocal(local);
	}
	
	public boolean consultaHorario(String horario, String dia) {
		return this.disponibilidade.verificarHorarioCadastrado(horario, dia);
	}
	
	public boolean consultaLocal(String local) {
		return this.disponibilidade.verificarLocalCadastrado(local);
	}
	
}
