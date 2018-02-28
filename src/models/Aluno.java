package models;

import utility.Validador;

/**
 * Representacao de um Aluno do sistema de ajuda. Todo aluno deve ter um nome, uma matricula, o co-
 * digo do curso no qual esta matriculado, um email, uma nota (inicializada com valor 5.0) e, opcio-
 * nalmente, um telefone.
 * 
 * Laboratorio de Programacao 2 - Projeto de Laboratorio - Quem Me Ajuda
 * 
 * @author Mateus de Lima Oliveira  - 117110219
 * @author Misael Augusto Silva da Costa - 117110525
 * @author Matheus Alves dos Santos - 117110503
 *
 */
public class Aluno extends Pessoa {
	
	private String matricula;
	private int codigoCurso;
	private double nota;
	
	/**
	 * Constroi um objeto do tipo Aluno a partir do nome, matricula, codigo do curso, telefone e
	 * email. Alem disso, verifica e trata invalidez nos atributos 'matricula', caso seja uma String
	 * vazia ou nula, e 'codigoCurso', caso seja um valor menor que 1.
	 * 
	 * 
	 * @param nome O nome do aluno
	 * @param matricula A matricula do aluno
	 * @param codigoCurso O codigo do curso no qual o aluno esta matriculado
	 * @param telefone O telefone do aluno
	 * @param email O email do aluno
	 */
	public Aluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		super(nome, telefone, email);
		
		Validador.validarStringNaoVaziaNaoNula("Matricula nao pode ser vazia ou nula", matricula);
		Validador.validarInteiroPositivo("Codigo do curso nao pode ser menor que 1", codigoCurso);
		
		this.matricula = matricula.trim();
		this.codigoCurso = codigoCurso;
		this.nota = 5.0;
	}
	
	public String getMatricula() {
		return this.matricula;
	}
	
	public int getCodigoCurso() {
		return this.codigoCurso;
	}
	
	public double getNota() {
		return this.nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	/**
	 * Monta e retorna uma mensagem em String da representacao textutal do objeto Aluno a partir dos
	 * seus atributos: matricula, nome, codigoCurso, telefone (caso nao seja vazio) e email respecti-
	 * vamente. Se o atributo telefone for uma String vazia, significa que o aluno nao possui o mes-
	 * mo, sendo assim, a representacao textual para este caso desconsidera o atributo telefone.
	 * 
	 * "matricula - nome - codigoCurso - telefone - email"
	 * "matricula - nome - codigoCurso - email" 
	 * 
	 * @returns A representacao textual do Aluno.
	 */
	@Override
	public String toString() {
		String toString = this.getMatricula() + " - " + this.getNome() + " - " + this.getCodigoCurso() + " - ";
					
		if (!this.getTelefone().isEmpty()) {
			toString += this.getTelefone() + " - ";
		}
		
		return toString + this.getEmail();
	}	

}