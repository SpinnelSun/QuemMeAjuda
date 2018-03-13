package models;

import java.io.Serializable;

/**
 * Representacao de uma AjudaOnline no sistema do Quem Me Ajuda. Como atributos, cada AjudaOnline pos-
 * sui o nome da disciplina, a matricula do Aluno solicitante e a matricula do Tutor responsavel re-
 * presentadas em String, alem de um boolean que sinaliza se a AjudaOnline em questao ja foi avaliada.
 * 
 * Laboratorio de Programacao 2 - Projeto de Laboratorio - Quem Me Ajuda
 * 
 * @author Mateus de Lima Oliveira  - 117110219
 * @author Matheus Alves dos Santos - 117110503
 * @author Misael Augusto Silva da Costa - 117110525
 *
 */
public class AjudaOnline extends Ajuda implements Serializable {
	
	/**
	 * Constroi uma AjudaOnline a partir da matricula do Aluno solicitante, do nome da disciplina 
	 * de interesse e da matricula do Tutor responsavel por aquela AjudaOnline. Nao e permitida a
	 * criacao de AjudaOnline cujos atributos sejam nulos, tampouco com matriculaAluno e/ou disci-
	 * plina vazios. Caso nao haja Tutor para prestar a AjudaOnline, matriculaTutor devera ser uma
	 * String vazia. 
	 * 
	 * @param matriculaAluno A matricula do Aluno solicitante.
	 * @param disciplina O nome da disciplina de interesse.
	 * @param matriculaTutor A matricula do Tutor responsavel.
	 * 
	 */
	public AjudaOnline(String matriculaAluno, String disciplina, String matriculaTutor) {
		super(matriculaAluno, disciplina, matriculaTutor);
	}

	/**
	 * Retorna a representacao textual de uma AjudaOnline a partir de seus atributos. Segue o pa-
	 * drão: "Tutor - MATRICULA DO TUTOR, disciplina - NOME DA DISCIPLINA".
	 * 
	 * @returns A representacao textual da AjudaOnline.
	 * 
	 */
	@Override
	public String toString() {
		return "Tutor - " + this.getMatriculaTutor() + ", disciplina - " + this.getDisciplina();
	}
	
}
