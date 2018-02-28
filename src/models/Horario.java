package models;

import utility.Validador;

/**
 * Representacao de um Horario a ser registrado numa Disponibilidade. Como atributos, um Horario pos-
 * sui uma String representando um horario e uma String representando um dia. O Horario refere-se a
 * um horario especifico de um dia especifico da semana.
 * 
 * Laboratorio de Programacao 2 - Projeto de Laboratorio - Quem Me Ajuda
 * 
 * @author Mateus de Lima Oliveira  - 117110219
 * @author Matheus Alves dos Santos - 117110503
 * @author Misael Augusto Silva da Costa - 117110525
 *
 */
public class Horario {
	
	private String horario;
	private String dia;
	
	
	/**
	 * Constroi um Horario a partir da hora e do dia da semana que o especificam. Nao e permitida a 
	 * criacao de Horarios cuja hora e/ou dia seja null ou uma String vazia.
	 * 
	 * @param horario A hora do Horario.
	 * @param dia O dia do Horario.
	 * 
	 */
	public Horario(String horario, String dia) {
		Validador.validarStringNaoVaziaNaoNula("horario nao pode ser vazio ou em branco", horario);
		Validador.validarStringNaoVaziaNaoNula("dia nao pode ser vazio ou em branco", dia);
		
		this.horario = horario.trim();
		this.dia = dia.trim();
	}

	public String getHorario() {
		return this.horario;
	}

	public String getDia() {
		return this.dia;
	}

	/**
	 * Define o HashCode de um Horario a partir da Strings armazenadas nos parametros hora e dia.
	 * 
	 * @returns O HashCode do Horario.
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((this.dia == null) ? 0 : this.dia.hashCode());
		result = prime * result + ((this.horario == null) ? 0 : this.horario.hashCode());
		
		return result;
	}

	/**
	 * Avalia a igualdade entre o Horario executando o metodo e outro Object. Para que haja igualdade,
	 * ambos devem ser o mesmo objeto ou o Object devera ser um outro Horario com mesmas Strings nos
	 * parametros hora e dia.
	 * 
	 * @param obj O objeto cuja igualdade sera avaliada.
	 * 
	 * @returns O boolean referente à avaliacao de igualdade.
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		
		Horario other = (Horario) obj;
		
		if (this == obj) { return true; }
		
		if (obj == null) { return false; }
		
		if (getClass() != obj.getClass()) { return false; }
		
		if (this.dia.equals(other.dia) && (this.horario.equals(other.horario))) {
			return true;
		}
		
		return false;
	}

	/**
	 * Retorna a representacao textual de um Horario. Segue o padrao HORA - DIA DA SEMANA.
	 * 
	 * @returns A representacao textual de um Horario.
	 * 
	 */
	@Override
	public String toString() {
		return this.getHorario() + " - " + this.getDia();
	}

}
