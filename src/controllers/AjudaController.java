package controllers;

import java.util.HashMap;
import java.util.Map;

import models.Ajuda;
import models.AjudaOnline;
import models.AjudaPresencial;
import models.InfoAjuda;
import models.InfoAluno;
import utility.Validador;

public class AjudaController {
	
	private Map<Integer, Ajuda> ajudas;
	
	public AjudaController() {
		this.ajudas = new HashMap<Integer, Ajuda>();
	}
	
	/**
	 * Solicita uma Ajuda Presencial no sitema, sendo passado a matricula do aluno que esta pedindo a ajuda, a disciplina 
	 * requisitada, horario e local desejados, alem da matricula do tutor que ira dar a tutoria. E retornado um identifi-
	 * cador do pedido que e gerado pela sua posicao na ordem de  pedidos.
	 * 
	 * @param matricula A matricula do Aluno.
	 * @param disciplina A disciplina que se precisa de ajuda.
	 * @param hora A hora desejada para haver a tutoria.
	 * @param dia O dia desejado para haver a tutoria.
	 * @param local O local desejado para haver a tutoria
	 * @param matriculaTutor A matricula do tutor que dará a tutoria.
	 * 
	 * @returns null.
	 * 
	 */
	public int pedirAjudaPresencial (String matriculaAluno, String disciplina, String hora, String dia,
									 String local, String matriculaTutor) {
		
		this.ajudas.put(this.ajudas.size() + 1, new AjudaPresencial(matriculaAluno, disciplina, hora, dia,
						local, matriculaTutor));
		
		return this.ajudas.size();
	}
	
	/**
	 * Solicita uma Ajuda Online no sitema, sendo passado a matricula do aluno que esta pedindo a ajuda, a disciplina 
	 * requisitada e a matricula do tutor que ira dar a tutoria. E retornado um identificador do pedido que e gerado
	 * pela sua posicao na ordem de  pedidos.
	 * 
	 * @param matricula A matricula do Aluno.
	 * @param disciplina A disciplina que se precisa de ajuda.
	 * @param matriculaTutor A matricula do tutor que dará a tutoria.
	 * 
	 * @returns null.
	 * 
	 */
	public int pedirAjudaOnline (String matriculaAluno, String disciplina, String matriculaTutor) {
		this.ajudas.put(this.ajudas.size() + 1, new AjudaOnline(matriculaAluno, disciplina, matriculaTutor));
		return this.ajudas.size();
	}
	
	/**
	 * Impede que seja possivel acessar uma Ajuda que nao esta cadastrada.
	 * 
	 * @param idAjuda Identificador da Ajuda.
	 * 
	 * @returns null.
	 * 
	 */
	private void impedirAjudaNaoCadastrada(int idAjuda) {
		if (!this.ajudas.containsKey(idAjuda)) {
			throw new IllegalArgumentException("id nao encontrado ");
		}
	}

	/**
	 * A partir das requisicoes da Ajuda, e buscado um tutor que seja compativel com as especificacoes de ajuda e que
	 * se sobressaia dos demais tutores em questao de proficiencia e posicao no sistema.
	 * 
	 * @param idAjuda Identificador da Ajuda.
	 * 
	 * @returns String representacao textual do uma Ajuda.
	 * 
	 */
	public String pegarTutor(int idAjuda) {
		Validador.validarInteiroPositivo("id nao pode menor que zero ", idAjuda);
		this.impedirAjudaNaoCadastrada(idAjuda);
		
		return this.ajudas.get(idAjuda).toString();
	}
	
	/**
	 * Realiza uma busca pelo valor de determinado atributo. 
	 * A partir do ID da Ajuda e retornada a informacao desejada (atributo) da Ajuda.
	 * 
	 * @param idAjuda Identificador da Ajuda.
	 * @param atributo Informacao desejada
	 * 
	 * @returns String o valor do atributo desejado.
	 * 
	 */
	public String getInfoAjuda(int idAjuda, String atributo) {
		Validador.validarInteiroPositivo("id nao pode menor que zero ", idAjuda);
		this.impedirAjudaNaoCadastrada(idAjuda);
		
		return this.ajudas.get(idAjuda).getInfo(atributo);
	}
	
	/**
	 *Registra avaliacao feita por aluno para determinada ajuda prestada por algum tutor. Sendo passado o ID de ajuda, a avali-
	 *acao e registrada e atribuida ao tutor daquela determinada ajuda. 
	 * 
	 * @param idAjuda Identificador da Ajuda.
	 * @param atributo Informacao desejada
	 * 
	 * @returns null.
	 * 
	 */
	public void registrarAvaliacao(int idAjuda) {
		this.impedirAjudaNaoCadastrada(idAjuda);
		this.ajudas.get(idAjuda).registrarAvaliacao();
	}

}
