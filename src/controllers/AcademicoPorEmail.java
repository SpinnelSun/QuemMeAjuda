package controllers;

import java.util.Comparator;

import models.Academico;

/**
 * Representacao de um ordenador de Academicos cadastrados no Sistema do Quem Me Ajuda baseado nos
 * nomes desses Academicos. Essa classe implementa a interface Comparator.
 * 
 * Laboratorio de Programacao 2 - Projeto de Laboratorio - Quem Me Ajuda
 * 
 * @author Mateus de Lima Oliveira  - 117110219
 * @author Matheus Alves dos Santos - 117110503
 * @author Misael Augusto Silva da Costa - 117110525
 *
 */
public class AcademicoPorEmail implements Comparator<Academico> {

	/**
	 * Implementacao do metodo de Comparator que determina qual dos Academicos passados como parame-
	 * tros precede o outro. Um Academico A precedera o Academico B se seu email for lexicografica-
	 * mente menor que o de B. Caso haja equivalencia, a matricula dos Academicos e usada para "de-
	 * sempate".
	 * 
	 * @param academico1 O primeiro Academico.
	 * @param academico2 O segundo Academico.
	 * 
	 * @returns O inteiro que caracteriza a precedencia entre os Academicos.
	 * 
	 */
	@Override
	public int compare(Academico academico1, Academico academico2) {
		return !academico1.getEmail().equals(academico2.getEmail())
				? academico1.getEmail().compareTo(academico2.getEmail())
				: academico1.getMatricula().compareTo(academico2.getMatricula());
	}

}
