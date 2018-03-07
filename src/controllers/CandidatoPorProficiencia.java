package controllers;

import java.util.Comparator;

import models.Candidato;

/**
 * Representacao de um ordenador de Candidatos cadastrados no Sistema do Quem Me Ajuda baseado na
 * proficiencia desses Candidatos na disciplina de interesse da comparacao. Essa classe implementa
 * a interface Comparator.
 * 
 * Laboratorio de Programacao 2 - Projeto de Laboratorio - Quem Me Ajuda
 * 
 * @author Mateus de Lima Oliveira  - 117110219
 * @author Matheus Alves dos Santos - 117110503
 * @author Misael Augusto Silva da Costa - 117110525
 *
 */
public class CandidatoPorProficiencia implements Comparator<Candidato> {
	
	/**
	 * Implementacao do metodo de Comparator que determina qual dos Candidatos passados como parame-
	 * tros precede o outro. Um Candidato A precedera o Candidato B se sua proficiencia na discipli-
	 * na for maior que a de B. Caso haja equivalencia, a ordem de cadastro dos Candidatos no Siste-
	 * ma e usada para "desempate".
	 * 
	 * @param candidato1 O primeiro Candidato.
	 * @param candidato2 O segundo Candidato.
	 * 
	 * @returns O inteiro que caracteriza a precedencia entre os Candidatos.
	 * 
	 */
	@Override
	public int compare(Candidato candidato1, Candidato candidato2) {
		return candidato1.getProficiencia() != candidato2.getProficiencia()
			 ? candidato2.getProficiencia() - candidato1.getProficiencia()
			 : candidato1.getNumeroCadastro() - candidato2.getNumeroCadastro();
	}

}
