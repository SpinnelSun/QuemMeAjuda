package controllers;

import java.util.Comparator;

import models.Aluno;

/**
 * Representaçao de um ordenador de Alunos cadastrados no Sistema do Quem Me Ajuda baseado nos nomes
 * desses Alunos. Essa classe implementa a interface Comparator.
 * 
 * Laboratorio de Programacao 2 - Projeto de Laboratorio - Quem Me Ajuda
 * 
 * @author Mateus de Lima Oliveira  - 117110219
 * @author Matheus Alves dos Santos - 117110503
 * @author Misael Augusto Silva da Costa - 117110525
 *
 */
public class AlunoPorNome implements Comparator<Aluno> {

	/**
	 * Implementaçao do metodo de Comparator que determina qual dos Alunos passados como parametros
	 * precede o outro. Um Aluno A precedera o Aluno B se seu nome for lexicograficamente menor que
	 * o de B. Caso haja equivalencia, a matricula dos Alunos e usada para "desempate".
	 * 
	 * @param aluno1 O primeiro Aluno.
	 * @param aluno2 O segundo Aluno.
	 * 
	 * @returns O inteiro que caracteriza a precedencia entre os Alunos.
	 * 
	 */
	@Override
	public int compare(Aluno aluno1, Aluno aluno2) {
		return !aluno1.getNome().equals(aluno2.getNome())
				? aluno1.getNome().compareTo(aluno2.getNome())
				: aluno1.getMatricula().compareTo(aluno2.getMatricula());
	}

}