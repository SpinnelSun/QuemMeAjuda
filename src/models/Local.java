package models;

import java.io.Serializable;

import general.Validador;

/**
 * Representacao de um Local a ser registrado numa Disponibilidade. Como atributos, um Local pos-
 * sui apenas uma String representando seu nome.
 * 
 * Laboratorio de Programacao 2 - Projeto de Laboratorio - Quem Me Ajuda
 * 
 * @author Mateus de Lima Oliveira  - 117110219
 * @author Matheus Alves dos Santos - 117110503
 * @author Misael Augusto Silva da Costa - 117110525
 *
 */
public class Local implements Serializable {
	
	private String nome;

	/**
	 * Constroi um Local a partir do nome que o especifica. Nao e permitida a criacao de Local com
	 * nome nulo ou vazio.
	 * 
	 * @param nome O nome do Local a ser criado.
	 * 
	 */
	public Local(String nome) {
		Validador.validarStringNaoVaziaNaoNula("local nao pode ser vazio ou em branco", nome);
		
		this.nome = nome.trim();
	}

	public String getNome() {
		return this.nome;
	}

	/**
	 * Define o HashCode de um Local a partir da String armazenada no atributo nome.
	 * 
	 * @returns O HashCode do Local.
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		
		return result;
	}

	/**
	 * Avalia a igualdade entre o Local executando o metodo e outro Object. Para que haja igualdade,
	 * ambos devem ser o mesmo objeto ou o Object devera ser um outro Local com as mesmas Strings no
	 * atributo nome.
	 * 
	 * @param obj O objeto cuja igualdade sera avaliada.
	 * 
	 * @returns O boolean referente a avaliacao de igualdade.
	 * 
	 */
	@Override
	public boolean equals(Object object) {
		
		Local other = (Local) object;
		
		if (this == object) { return true; }
		
		if (object == null) { return false; }
		
		if (getClass() != object.getClass()) { return false; }
		
		if (this.nome.equals(other.nome)) {	return true; }
		
		return false;
	}

	/**
	 * Retorna a representacao textual de um Local. Segue o padrao NOME.
	 * 
	 * @returns A representacao textual de um Local.
	 * 
	 */
	@Override
	public String toString() {
		return this.getNome();
	}
	
}
