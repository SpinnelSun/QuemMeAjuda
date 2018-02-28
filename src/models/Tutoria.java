package models;

import utility.Validador;

/**
* Representacao de uma Tutoria como sendo uma disciplina de tutor.
* Como atributos, cada Tutoria possui o nome da disciplina e a proficiencia na mesma.
* 
* Laboratorio de Programacao 2 - Projeto - Quem me ajuda
 * 
 * @author Mateus de Lima Oliveira  - 117110219
 * @author Misael Augusto Silva da Costa - 117110525
 * @author Matheus Alves dos Santos - 117110503
*
*/
public class Tutoria {
	
	private String disciplina;
	private int proficiencia;
	
	/**
	 * Constroi uma Tutoria a partir do nome da disciplina e da proficiencia.
	 * Nao eh permitido criar tutorias com nome e proficiencia vazios ou nulos.
	 * 
	 * @param disciplina O nome da disciplina.
	 * @param proficiencia A media de avaliacao do tutor nessa disciplina.
	 * 
	 */
	public Tutoria(String disciplina, int proficiencia) {
		Validador.validarStringNaoVaziaNaoNula("Disciplina nao pode ser vazia ou nula", disciplina);
		Validador.validarIntUmACinco("Proficiencia invalida", proficiencia);
		
		this.disciplina = disciplina.trim();
		this.proficiencia = proficiencia;
	}

	public String getDisciplina() {
		return this.disciplina;
	}

	public int getProficiencia() {
		return this.proficiencia;
	}
	
	/**
	 * Gera o HashCode de uma Tutoria a partir de seu atributo disciplina.
	 * 
	 * @returns O Hashcode de Tutoria.
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
	 * Avalia se o Tutoria eh ou nao igual a outro Object. Para que haja igualdade, deverao possuir 
	 * o atributo disciplina iguais.
	 * 
	 * @param obj O objeto a ser comparado com o Tutoria executando o equals.
	 * 
	 * @returns O boolean equivalente ao resultado do teste de igualdade.
	 * 
	 */
	@Override
	public boolean equals(Object object) {
		
		Tutoria other = (Tutoria) object;
		
		if (this == object) { return true; }
		
		if (object == null) { return false; }
		
		if (getClass() != object.getClass()) { return false; }
		
		if (this.disciplina.equals(other.disciplina)) { return true; }
		
		return false;
	}
	/**
	 * Retorna a String que representa a Tutoria. 
	 * 
	 * @returns A representacao, em String, da Tutoria.
	 * 
	 */
	@Override
	public String toString() {
		return this.getDisciplina() + " - " + this.getProficiencia();
	}
	
}
