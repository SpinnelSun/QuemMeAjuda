package models;

import java.util.HashSet;
import java.util.Set;

/**
 * Representacao de uma Disponibilidade a ser registrada num Tutor. Como atributos, uma Disponibili-
 * dade possui um conjunto de locais e um conjunto de horarios. A Disponibilidade refere-se aos lo-
 * cais e horarios nos quais o tutor estara disponivel para atendimento.
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
	 * Constroi uma Disponibilidade cujos parametros locais e horarios sao iniciados como Sets va-
	 * zios de Local e Horario, respectivamente.
	 * 
	 */
	public Disponibilidade() {
		this.locais = new HashSet<Local>();
		this.horarios = new HashSet<Horario>();
	}
	
	/**
	 * Cria um novo Local cujo nome sera a String passada como parametro desse metodo. O Local cria-
	 * do sera adicionado ao atributo locais da Disponibilidade.
	 * 
	 * @param nomeLocal O nome do Local disponivel disponivel para atendimento.
	 * 
	 * @returns null.
	 * 
	 */
	public void adicionarLocal(String nomeLocal) {
		this.locais.add(new Local(nomeLocal));
	}
	
	/**
	 * Cria um novo Horario cuja hora e dia serao as Strings passadas como parametro desse metodo.
	 * O Horario criado sera adicionado ao atributo horarios da Disponibilidade.
	 * 
	 * @param hora A hora disponivel para atendimento.
	 * @param dia O dia disponivel para atendimento.
	 * 
	 * @returns null.
	 * 
	 */
	public void adicionarHorario(String hora, String dia) {
		this.horarios.add(new Horario(hora, dia));
	}
	
	/**
	 * Verifica se a Disponibilidade executando esse metodo possui um Local especifico em seu Set
	 * de Locais. A hora e o dia de interesse devem ser passados como parametros do metodo. Sera
	 * retornado o boolean referente a disponibilidade do Local de interesse.
	 * 
	 * @param nomeLocal O nome do local de interesse na verificacao.
	 * 
	 * @returns O boolean que indica a existencia de disponibilidade para o Local de interesse.
	 * 
	 */
	public boolean verificarLocalCadastrado(String nomeLocal) {
		return this.locais.contains(new Local(nomeLocal));
	}
	
	/**
	 * Verifica se a Disponibilidade executando esse metodo possui um Horario especifico em seu Set
	 * de Horarios. A hora e o dia de interesse devem ser passados como parametros do metodo. Sera
	 * retornado o boolean referente a disponibilidade do Horario de interesse.
	 * 
	 * @param hora A hora de interesse na verificacao.
	 * @param dia A dia de interesse na verificacao.
	 * 
	 * @returns O boolean que indica a existencia de disponibilidade para o Horario de interesse.
	 * 
	 */
	public boolean verificarHorarioCadastrado(String hora, String dia) {
		return this.horarios.contains(new Horario(hora, dia));
	}

	/**
	 * Retorna a quantidade de Locais existentes no Set de Locais da Disponibilidade executando esse
	 * metodo.
	 * 
	 * @returns A quantidade de Locais ja cadastrados.
	 * 
	 */
	public int totalLocaisCadastrados() {
		return this.locais.size();
	}
	
	/**
	 * Retorna a quantidade de Horarios existentes no Set de Horarios da Disponibilidade executando
	 * esse metodo.
	 * 
	 * @returns A quantidade de Horarios ja cadastrados.
	 * 
	 */
	public int totalHorariosCadastrados() {
		return this.horarios.size();
	}
	
}