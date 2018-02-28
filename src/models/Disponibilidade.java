package models;

import java.util.HashSet;
import java.util.Set;

/**
 * Representacao de uma Disponibilidade a ser registrada num Tutor. Como atributos, uma Disponibili-
 * dade possui um conjunto de locais e um conjunto de horarios. A Disponibilidade refere-se a um con-
 * junto de locais e horarios nos quais o tutor estara disponivel para atendimento.
 * 
 * Laboratorio de Programacao 2 - Projeto de Laboratorio - Quem Me Ajuda
 * 
 * @author Mateus de Lima Oliveira  - 117110219
 * @author Matheus Alves dos Santos - 117110503
 * @author Misael Augusto Silva da Costa - 117110525
 *
 */
public class Disponibilidade {
	
	private Set<Local> locais;
	private Set<Horario> horarios;
	
	/**
	 * Constroi um objeto Disponibilidade.
	 * 
	 */
	public Disponibilidade() {
		this.locais = new HashSet<Local>();
		this.horarios = new HashSet<Horario>();
	}
	
	/**
	 * Nao retorna nada, apenas cria e adiciona um local ao conjunto de locais da Disponibilidade a 
	 * partir do nome do local passado como parametro.
	 * 
	 * @param nomeLocal O nome do local.
	 * 
	 */
	public void adicionarLocal(String nomeLocal) {
		this.locais.add(new Local(nomeLocal));
	}
	
	/**
	 * Nao retorna nada, apenas cria e adiciona um horario ao conjunto de horarios da Disponibilidade 
	 * a partir da hora e do dia do horario passados como parametro.
	 * 
	 * @param hora A hora disponivel
	 * @param dia O dia disponivel
	 * 
	 */
	public void adicionarHorario(String hora, String dia) {
		this.horarios.add(new Horario(hora, dia));
	}
	
	/**
	 * Verifica se um horario esta cadastrado no conjunto de horarios a partir da hora e do dia pas-
	 * sados como parametro. Caso esteja cadastrado, retorna o valor booleano true, do contrario re-
	 * torna false.
	 * 
	 * @param hora A hora disponivel
	 * @param dia O dia disponivel
	 * 
	 * @returns Um valor booleano que indica se o horario esta ou nao cadastrado
	 */
	public boolean verificarHorarioCadastrado(String hora, String dia) {
		return this.horarios.contains(new Horario(hora, dia));
	}

	/**
	 * Verifica se um local esta cadastrado no conjunto de locais a partir do nome passado como para-
	 * metro. Caso esteja cadastrado, retorna o valor booleano true, do contrario retorna false.
	 * 
	 * @param nome O nome do local
	 * 
	 * @returns Um valor booleano que indica se o local esta ou nao cadastrado.
	 */
	public boolean verificarLocalCadastrado(String nomeLocal) {
		return this.locais.contains(new Local(nomeLocal));
	}
	
	/**
	 * Calcula e retorna a quantidade total de locais cadastrados.
	 * 
	 * @returns A quantidade total de locais cadastrados.
	 */
	public int totalLocaisCadastrados() {
		return this.locais.size();
	}
	
	/**
	 * Calcula e retorna a quantidade total de horarios cadastrados.
	 * 
	 * @returns A quantidade total de horarios cadastrados.
	 */
	public int totalHorariosCadastrados() {
		return this.horarios.size();
	}

}
