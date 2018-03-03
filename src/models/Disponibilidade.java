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
	 * Constroi um objeto Disponibilidade iniciando seus atributos como conjuntos vazios.
	 * 
	 */
	public Disponibilidade() {
		this.locais = new HashSet<Local>();
		this.horarios = new HashSet<Horario>();
	}
	
	/**
	 * Cria e adiciona um Local ao conjunto de locais da Disponibilidade a partir do nome do Local
	 * passado como parametro.
	 * 
	 * @param nomeLocal O nome do Local.
	 * 
	 * @returns null.
	 * 
	 */
	public void adicionarLocal(String nomeLocal) {
		this.locais.add(new Local(nomeLocal));
	}
	
	/**
	 * Cria e adiciona um Horario ao conjunto de horarios da Disponibilidade a partir da hora e do
	 * dia do Horario passados como parametro.
	 * 
	 * @param hora A hora em que ha disponibilidade.
	 * @param dia O dia da semana referente ao Horario.
	 * 
	 * @returns null.
	 * 
	 */
	public void adicionarHorario(String hora, String dia) {
		this.horarios.add(new Horario(hora, dia));
	}
	
	/**
	 * Verifica se um Horario esta cadastrado na Disponibilidade a partir da hora e do dia passados
	 * como parametros. Caso esteja cadastrado, retorna true, caso contrario retorna false.
	 * 
	 * @param hora A hora em que se espera disponibilidade.
	 * @param dia O dia da semana referente ao Horario.
	 * 
	 * @returns O boolean que indica a existencia do cadastro do Horario.
	 * 
	 */
	public boolean verificarHorarioCadastrado(String hora, String dia) {
		return this.horarios.contains(new Horario(hora, dia));
	}

	/**
	 * Verifica se um local esta cadastrado no conjunto de locais a partir do nome passado como para-
	 * metro. Caso esteja cadastrado, retorna true, caso contrario, retorna false.
	 * 
	 * @param nome O nome do local em que se espera disponibilidade.
	 * 
	 * @returns O boolean que indica a existencia do cadastro do Local.
	 * 
	 */
	public boolean verificarLocalCadastrado(String nomeLocal) {
		return this.locais.contains(new Local(nomeLocal));
	}
	
	/**
	 * Retorna a quantidade de Locais cadastrados na Disponibilidade.
	 * 
	 * @returns A quantidade de Locais cadastrados.
	 * 
	 */
	public int totalLocaisCadastrados() {
		return this.locais.size();
	}
	
	/**
	 * Retorna a quantidade de Horarios cadastrados na Disponibilidade.
	 * 
	 * @returns A quantidade de Horarios cadastrados.
	 * 
	 */
	public int totalHorariosCadastrados() {
		return this.horarios.size();
	}

	public Set<Local> getLocais() {
		return locais;
	}

	public Set<Horario> getHorarios() {
		return horarios;
	}
	
	

}