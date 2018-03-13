package general;

/**
 * Excecao generalista para identificacao mais precisa de problemas envolvendo criacao, manipulacao
 * ou alteracao em Ajudas do Quem Me Ajuda.
 * 
 * Laboratorio de Programacao 2 - Projeto de Laboratorio - Quem Me Ajuda
 * 
 * @author Mateus de Lima Oliveira  - 117110219
 * @author Matheus Alves dos Santos - 117110503
 * @author Misael Augusto Silva da Costa - 117110525
 *
 */
@SuppressWarnings("serial")
public class AjudaException extends RuntimeException {
	
	public AjudaException(String msg){
		super(msg);
	}

}
