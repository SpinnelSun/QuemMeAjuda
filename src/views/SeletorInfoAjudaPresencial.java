package views;

import models.AjudaPresencial;

/**
 * Representacao em interface do Seletor para informacoes de AjudaPresencial garantindo o uso de po-
 * limorfismo atraves de um Enum.
 * 
 * Laboratorio de Programacao 2 - Projeto de Laboratorio - Quem Me Ajuda
 * 
 * @author Mateus de Lima Oliveira  - 117110219
 * @author Matheus Alves dos Santos - 117110503
 * @author Misael Augusto Silva da Costa - 117110525
 *
 */
public interface SeletorInfoAjudaPresencial {
	
	/**
	 * Metodo a ser implementado pelas classes. A existencia desse metodo na interface obrigara cada
	 * valor de uma classe que implemente SeletorInfoAjudaPresencial a possuir seu proprio getInfo,
	 * garantindo o polimorfismo.
	 * 
	 * @param aluno Uma AjudaPresencial que tera uma informacao recuperada.
	 * 
	 * @returns A representacao textual da informacao recuperada.
	 * 
	 */
	public String getInfo(AjudaPresencial ajuda);

}
