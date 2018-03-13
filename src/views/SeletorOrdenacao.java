package views;

import java.util.Comparator;

/**
 * Representacao em interface do Seletor para ordenacoes garantindo o uso de polimorfismo atraves 
 * de um Enum.
 * 
 * Laboratorio de Programacao 2 - Projeto de Laboratorio - Quem Me Ajuda
 * 
 * @author Mateus de Lima Oliveira  - 117110219
 * @author Matheus Alves dos Santos - 117110503
 * @author Misael Augusto Silva da Costa - 117110525
 *
 */
public interface SeletorOrdenacao {
	
	/**
	 * Metodo a ser implementado pelas classes. A existencia desse metodo na interface obrigara cada
	 * valor de uma classe que implemente SeletorOrdenacao a possuir seu proprio definirOrdenacao,
	 * garantindo o polimorfismo.
	 * 
	 * 
	 * @returns O Comparator adequado para ser utilizado na ordenacao.
	 * 
	 */
	public Comparator definirOrdenacao();

}