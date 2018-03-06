package models;

import utility.Validador;

/**
 * Representacao de um Candidato no sistema do Quem Me Ajuda. O Candidato e uma versao simplificada
 * de um Tutor que esta apto a se responsabilizar por uma Ajuda do Quem Me Ajuda, possuindo apenas
 * as informacoes interessantes para a vaga de tutoria em questao. Como atributos, cada Candidato
 * possui a matricula representada em String, o numero de cadastro representado como um numero in-
 * teiro e seu nivel de proficienca na disciplina da Ajuda.
 * 
 * Laboratorio de Programacao 2 - Projeto de Laboratorio - Quem Me Ajuda
 * 
 * @author Mateus de Lima Oliveira  - 117110219
 * @author Matheus Alves dos Santos - 117110503
 * @author Misael Augusto Silva da Costa - 117110525
 *
 */
public class Candidato {
	
	private String matricula;
	private int proficiencia;
	private int numeroCadastro;
	
	/**
	 * Constroi um Candidato a partir de sua matricula, de sua proficiencia na disciplina e de seu
	 * numero de cadastro. Nao e permitida a criacao de Candidatos com matricula vazia ou nula. Nao
	 * e permitida a criacao de Candidatos com proficiencia e/ou numero de cadastro inferior a 1.
	 * 
	 * @param matricula A matricula do Candidato.
	 * @param proficiencia O nivel de proficiencia do Candidato na disciplina.
	 * @param numeroCadastro O numero de cadastro do Candidato no Quem Me Ajuda.
	 * 
	 */
	public Candidato(String matricula, int proficiencia, int numeroCadastro) {
		this.validarAtributos(matricula, proficiencia, numeroCadastro);
		
		this.matricula = matricula;
		this.proficiencia = proficiencia;
		this.numeroCadastro = numeroCadastro;
	}
	
	/**
	 * Valida os atributos a serem usados na construcao de um Candidato. Nao e permitida a criacao
	 * de Candidatos com matricula vazia ou nula. Nao e permitida a criacao de Candidatos com profi-
	 * ciencia e/ou numero de cadastro inferior a 1.
	 * 
	 * @param matricula A matricula do Candidato.
	 * @param proficiencia O nivel de proficiencia do Candidato na disciplina.
	 * @param numeroCadastro O numero de cadastro do Candidato no Quem Me Ajuda.
	 * 
	 */
	private void validarAtributos(String matricula, int proficiencia, int numeroCadastro) {
		Validador.validarStringNaoVaziaNaoNula("matricula nao pode ser vazio ou em branco", matricula);
		Validador.validarInteiroPositivo("proficiencia nao pode ser menor que 1", proficiencia);
		Validador.validarInteiroPositivo("numero de cadastro nao pode ser menor que 1", proficiencia);
	}

	public String getMatricula() {
		return this.matricula;
	}

	public int getProficiencia() {
		return this.proficiencia;
	}
	
	public int getNumeroCadastro() {
		return this.numeroCadastro;
	}

}
