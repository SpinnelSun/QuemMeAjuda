package models;

import java.io.Serializable;

/**
 * Representacao de um Aluno no sistema do Quem Me Ajuda. Como atributos, cada Aluno possui o nome,
 * o telefone, o email e matricula representados em Strings, o codigo de seu curso representado em
 * int e sua nota de avaliacao representada em double.
 * 
 * Laboratorio de Programacao 2 - Projeto de Laboratorio - Quem Me Ajuda
 * 
 * @author Mateus de Lima Oliveira  - 117110219
 * @author Matheus Alves dos Santos - 117110503
 * @author Misael Augusto Silva da Costa - 117110525
 *
 */
public class Aluno extends Academico implements Serializable {
	
	private double nota;
	
	/**
	 * Constroi um Aluno a partir de seu nome, de seu telefone, de sua matricula, do codigo de seu
	 * curso e de seu email. Nao e permitida a criacao de Alunos com atributos vazios e/ou nulos.
	 * Excetua-se o telefone, que podera ser uma String vazia (telefone nao informado). O codigo do
	 * curso nao podera ser inferior a 1. A nota de avaliacao do Aluno sera, inicialmente, 5.0. 
	 * 
	 * @param nome O nome do Aluno.
	 * @param matricula A matricula do Aluno.
	 * @param codigoCurso O codigo do curso do Aluno.
	 * @param telefone O numero do telefone do Aluno.
	 * @param email O email do Aluno.
	 * 
	 */
	public Aluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		super(nome, telefone, email, matricula, codigoCurso);
		this.nota = 5.0;
	}
	
	public double getNota() {
		return this.nota;
	}

}