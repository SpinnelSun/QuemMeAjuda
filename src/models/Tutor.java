package models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
* Representacao de um Tutor.
* Como atributos, cada Tutor possui o nome, telefone, matricula, codigo do curso, email, proficiencias, 
* disciplinas (tutorias) e disponibilidade.
* 
* Laboratorio de Programacao 2 - Projeto - Quem me ajuda
 * 
 * @author Mateus de Lima Oliveira  - 117110219
 * @author Misael Augusto Silva da Costa - 117110525
 * @author Matheus Alves dos Santos - 117110503
*
*/
public class Tutor extends Aluno {
	
	private int dinheiroRecebido;
	private Set<Tutoria> tutorias;
	private Disponibilidade disponibilidade;
	
	
	/**
	 * Constroi um Tutor a partir do nome, telefone, matricula, codigo do curso, email.
	 * Nao eh permitido criar apostas de pessoa com atributos vazio ou nulo (alem de telefone).
	 * 
	 * @param nome O nome da pessoa.
	 * @param matricula A matricula do tutor
	 * @param codigoCurso O codigo do curso do Tutor
	 * @param telefone O numero do telefone do tutor.
	 * @param email O email do tutor.
	 * 
	 */
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
	
	/**
	 * Verifica se tutor ja contem determinada tutoria
	 * 
	 * 
	 * @param disciplina Disciplina a ser verificada
	 * @param proficiencia Proficiencia da disciplina a ser verificada 
	 * 
	 * @returns null
	 * 
	 */
	private void verificaTutoriaRepetida(String disciplina, int proficiencia) {
		if (this.tutorias.contains(new Tutoria(disciplina, proficiencia))) {
			throw new IllegalArgumentException("Ja eh tutor dessa disciplina");
		}
	}
	
	/**
	 * Adiciona uma nova Tutoria ao Tutor
	 * 
	 * 
	 * @param disciplina Disciplina a ser adicionada
	 * @param proficiencia Proficiencia da disciplina a ser adicionada
	 *  
	 * @returns null
	 * 
	 */
	public void adicionarTutoria(String disciplina, int proficiencia) {
		this.verificaTutoriaRepetida(disciplina, proficiencia);
		this.tutorias.add(new Tutoria(disciplina, proficiencia));
	}

	/**
	 * Cadastra horario de atendimento do tutor aos demais alunos.  
	 * 
	 * @param email Email do tutor.
	 * @param horario Horario disponivel para atendimento.
	 * @param dia Dia que sero disponibilizadas as tutorias. 
	 * 
	 * @returns null
	 */
	public void cadastrarHorario(String horario, String dia) {
		this.disponibilidade.adicionarHorario(horario, dia);
	}
	
	/**
	 * Cadastra local de atendimento do tutor aos demais alunos.  
	 * 
	 * @param email Email do tutor.
	 * @param local Local disponivel para atendimento dos alunos.
	 * 
	 * @returns null
	 */
	public void cadastrarLocalDeAtendimento(String local) {
		this.disponibilidade.adicionarLocal(local);
	}
	
	/**
	 * Verifica horario de atendimento do tutor aos demais alunos, caso o horario e dia estejam disponiveis eh retornado True, se nao, eh 
	 * retornado False.  
	 * 
	 * @param horario Horario disponivel para atendimento.
	 * @param dia Dia que sero disponibilizadas as tutorias. 
	 * 
	 * @returns boolean True se houver o horario ou False se no houver.
	 */
	public boolean consultaHorario(String horario, String dia) {
		return this.disponibilidade.verificarHorarioCadastrado(horario, dia);
	}
	
	/**
	 * Verifica o local de atendimento do tutor aos demais alunos, caso o local esteja correto e retornado True, se nao, e 
	 * retornado False.
	 * 
	 * @param local Local disponivel para atendimento dos alunos.
	 * 
	 * @returns boolean True se houver o local registrado ou False se no houver.
	 */
	public boolean consultaLocal(String local) {
		return this.disponibilidade.verificarLocalCadastrado(local);
	}
	
	public boolean tutorContainsTutorias(String disciplina){
		List<Tutoria> tutorias = new ArrayList<>();
		for(Tutoria tutoria : this.tutorias) {
			if(tutoria.getDisciplina().equals(disciplina)) {
				return true;
			}
		}
		return false;
	}

	public Disponibilidade getDisponibilidade() {
		return disponibilidade;
	}

	public Set<Tutoria> getTutorias() {
		return tutorias;
	}
	
	
	
	
	
}
