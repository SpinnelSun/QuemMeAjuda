package models;

import java.io.Serializable;

import general.Validador;

/**
 * Representacao de uma Habilidade de um Tutor. Como atributos, cada Habilidade possui o nome de uma
 * disciplina e o nivel de proficiencia do Tutor nessa disciplina.
 * 
 * Laboratorio de Programacao 2 - Projeto de Laboratorio - Quem Me Ajuda
 * 
 * @author Mateus de Lima Oliveira  - 117110219
 * @author Matheus Alves dos Santos - 117110503
 * @author Misael Augusto Silva da Costa - 117110525
 *
 */
public class Habilidade implements Serializable {
	
	private String disciplina;
	private int proficiencia;
	
	/**
	 * Constroi uma Habilidade a partir do nome da disciplina e da proficiencia do Tutor nela. Nao e
	 * permitida a criacao de Habilidades com disciplina vazia ou nula, tampouco com proficiencia
	 * nao-positiva.
	 * 
	 * @param disciplina O nome da disciplina da Habilidade.
	 * @param proficiencia O nivel de proficiencia do Tutor na disciplina.
	 * 
	 */
	public Habilidade(String disciplina, int proficiencia) {
		this.validarAtributos(disciplina, proficiencia);
		
		this.disciplina = disciplina.trim();
		this.proficiencia = proficiencia;
	}
	
	/**
	 * Valida os atributos a serem usados na construcao de uma Habilidade. Nao e permitida a criacao
	 * de Habilidades com disciplina vazia ou nula, tampouco com proficiencia nao-positiva.
	 * 
	 * @param disciplina O nome da disciplina da Habilidade.
	 * @param proficiencia O nivel de proficiencia do Tutor na disciplina.
	 * 
	 */
	private void validarAtributos(String disciplina, int proficiencia) {
		Validador.validarStringNaoVaziaNaoNula("Disciplina nao pode ser vazia ou nula", disciplina);
		Validador.validarIntUmACinco("Proficiencia invalida", proficiencia);
	}

	public String getDisciplina() {
		return this.disciplina;
	}

	public int getProficiencia() {
		return this.proficiencia;
	}
	
	/**
	 * Define o HashCode de uma Habilidade a partir da String armazenada no atributo disciplina.
	 * 
	 * @returns O HashCode da Habilidade.
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((this.disciplina == null) ? 0 : this.disciplina.hashCode());
		
		return result;
	}

	/**
	 * Avalia a igualdade entre a Habilidade executando o metodo e outro Object. Para que haja igual-
	 * dade, ambos devem ser o mesmo objeto ou o Object devera ser uma outra Habilidade com as mesmas
	 * Strings no atributo nome.
	 * 
	 * @param obj O objeto cuja igualdade sera avaliada.
	 * 
	 * @returns O boolean referente a avaliacao de igualdade.
	 * 
	 */
	@Override
	public boolean equals(Object object) {
		
		Habilidade other = (Habilidade) object;
		
		if (this == object) { return true; }
		
		if (object == null) { return false; }
		
		if (getClass() != object.getClass()) { return false; }
		
		if (this.disciplina.equals(other.disciplina)) { return true; }
		
		return false;
	}
	
	/**
	 * Retorna a representacao textual de uma Habilidade. Segue o padrao DISCIPLINA - PROFICIENCIA.
	 * 
	 * @returns A representacao textual de uma Habilidade.
	 * 
	 */
	@Override
	public String toString() {
		return this.getDisciplina() + " - " + this.getProficiencia();
	}
	
}
