package views;

import models.Aluno;

/**
 * Representacao em interface do Strategy para Atributo garantindo o uso de polimorfismo atraves de
 * um Enum.
 * 
 * Laboratorio de Programacao 2 - Projeto de Laboratorio - Quem Me Ajuda
 * 
 * @author Mateus de Lima Oliveira  - 117110219
 * @author Matheus Alves dos Santos - 117110503
 * @author Misael Augusto Silva da Costa - 117110525
 *
 */
public interface AtributoStrategy {
	
	/**
	 * Metodo a ser implementado por Atributo. A existencia desse metodo na interface obrigara cada
	 * valor de Atributo a implementar seu proprio getAtributo, garantindo o polimorfismo.
	 * 
	 * @param aluno Um Aluno que tera um atributo recuperado
	 * 
	 * @returns A representacao textual do atributo recuperado.
	 * 
	 */
	public String getAtributo(Aluno aluno);

}
