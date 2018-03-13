package models;

import java.io.Serializable;

import general.Validador;

/**
 * Representacao de uma AjudaPresencial no sistema do Quem Me Ajuda. Como atributos, cada AjudaPre-
 * sencial possui o nome da disciplina, a matricula do Aluno solicitante e a matricula do Tutor res-
 * ponsavel representadas em String, alem de um boolean que sinaliza se a AjudaPresencial em ques-
 * tao ja foi avaliada. Alem disso, possui um Local e um Horario referentes ao atendimento presen-
 * cial desse tipo de Ajuda.
 * 
 * Laboratorio de Programacao 2 - Projeto de Laboratorio - Quem Me Ajuda
 * 
 * @author Mateus de Lima Oliveira  - 117110219
 * @author Matheus Alves dos Santos - 117110503
 * @author Misael Augusto Silva da Costa - 117110525
 *
 */
public class AjudaPresencial extends Ajuda implements Serializable {

	private Horario horario;
	private Local local;
	
	/**
	 * Constroi uma AjudaPresencial a partir da matricula do Aluno solicitante, do nome da discipli-
	 * na de interesse, da matricula do Tutor responsavel, da hora, do dia e do local de atendimento
	 * da AjudaPresencial. Nao e permitida a criacao de AjudaPresencial cujos atributos sejam nulos
	 * ou vazios. Excetua-se a matriculaTutor que devera ser vazia caso nao haja Tutor capaz de aten-
	 * der a AjudaPresencial em questao.
	 * 
	 * @param matriculaAluno A matricula do Aluno solicitante.
	 * @param disciplina O nome da disciplina de interesse.
	 * @param hora A hora em que o atendimento sera realizado.
	 * @param dia O dia em que o atendimento sera realizado.
	 * @param local O local em que o atendimento sera realizado.
	 * @param matriculaTutor A matricula do Tutor responsavel.
	 * 
	 */
	public AjudaPresencial(String matriculaAluno, String disciplina, String hora, String dia, String local,
						   String matriculaTutor) {
		
		super(matriculaAluno, disciplina, matriculaTutor);
		this.validarAtributos(hora, dia, local);
		
		this.horario = new Horario(hora, dia);
		this.local = new Local(local);	
	}
	
	/**
	 * Valida alguns dos atributos a serem usados na construcao de uma AjudaPresencial. Nao e per-
	 * mitida a criacao de AjudaPresencial cujos parametros hora, dia e local do Construtor sejam
	 * vazios ou nulos. 
	 * 
	 * @param hora A hora em que o atendimento sera realizado.
	 * @param dia O dia em que o atendimento sera realizado.
	 * @param local O local em que o atendimento sera realizado.
	 * 
	 * @returns null.
	 * 
	 */
	private void validarAtributos(String hora, String dia, String local) {
		Validador.validarStringNaoVaziaNaoNula("horario nao pode ser vazio ou em branco", hora);
		Validador.validarStringNaoVaziaNaoNula("dia nao pode ser vazio ou em branco", dia);
		Validador.validarStringNaoVaziaNaoNula("local de interesse nao pode ser vazio ou em branco", local);
	}

	public String getHora() {
		return this.horario.getHora();
	}

	public String getDia() {
		return this.horario.getDia();
	}

	public String getLocal() {
		return this.local.getNome();
	}
	
	/**
	 * Retorna a representacao textual de um dos atributos de uma AjudaPresencial. O atributo a ser
	 * retornado deve ser especificado atraves de seu nome (passado como parametro desse metodo). Ha-
	 * vera lancamento de excecoes caso o atributo requisitado seja vazio, nulo ou inexistente para
	 * AjudaPresencial.
	 * 
	 * @param atributo O nome do atributo a ser recuperado.
	 * 
	 * @returns A representacao textual de um atributo de AjudaPresencial.
	 * 
	 */
	@Override
	public String getInfo(String atributo) {
		Validador.validarStringNaoVaziaNaoNula("atributo nao pode ser vazio ou em branco", atributo);
		InfoAjudaPresencial.impedirAtributoInexistente(atributo.toUpperCase());
		
		return InfoAjudaPresencial.valueOf(atributo.toUpperCase()).getInfo(this);
	}

	/**
	 * Retorna a representacao textual de uma AjudaPresencial a partir de seus atributos. Segue o pa-
	 * drão: "Tutor - MATRICULA DO TUTOR, horario - HORA, dia - DIA, local - NOME DO LOCAL, discipli-
	 * na - NOME DA DISCIPLINA".
	 * 
	 * @returns A representacao textual da AjudaPresencial.
	 * 
	 */
	@Override
	public String toString() {
		return "Tutor - " + this.getMatriculaTutor() + ", horario - " + this.getHora() + ", dia - " +
				this.getDia() + ", local - " + this.getLocal() + ", disciplina - " + this.getDisciplina();
	}
	
}