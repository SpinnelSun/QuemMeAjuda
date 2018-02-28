package controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.AtributoAluno;
import models.Aluno;
import models.Tutor;
import utility.Validador;

/**
 * Representa��o de um Sistema que tem como objetivo aproximar alunos
 * que precisam de ajuda em disciplinas dos demais alunos capacitados
 * para oferecer ajuda. No sistema, o aluno pode realizar seu cadastro e 
 * se colocar como tutor. O software deve dar suporte a listagem de 
 * alunos e tutores e deve permitir a cria��o de ajudas.
 * 
 * Laborat�rio de Programa��o 2 - Projeto - Quem me ajuda
 * 
 * @author Mateus de Lima Oliveira  - 117110219
 * @author Misael Augusto Silva da Costa - 117110525
 * @author Matheus Alves dos Santos - 117110503
 *
 */
public class Sistema {
	
	private Map<String, Aluno> alunos;
	private Map<String, Tutor> tutores;
	private Comparator<Aluno> ordenadorAlunos;
	
	
	/**
	 * Constr�i um Sistema.
	 * 
	 */
	public Sistema() {
		this.alunos = new HashMap<String, Aluno>();
		this.tutores = new HashMap<String, Tutor>();
		this.ordenadorAlunos = new AlunoPorNome();
	}
	
	/**
	 * Verifica se determinada matricula j� est� no sistema.
	 * 
	 * @param matricula Matricula do aluno
	 * 
	 * @returns null
	 */
	private void verificarAlunoRepetido(String matricula, String msg) {
		if (this.alunos.containsKey(matricula)) {
			throw new IllegalArgumentException(msg);
		}
	}
	
	/**
	 * Cadastra um anulo no sistema. N�o � permitido o cadastro de alunos repetidos, com dados vazios ou nulos ou email inv�lido. Por�m, telefone pode ser vazio
	 * 
	 * @param nome O nome do Aluno.
	 * @param matricula A matricula do Aluno. 
	 * @param codigoCurso Codigo do curso do Aluno.
	 * @param telefone Numero do telefone do Aluno.
	 * @param email Email do Aluno.
	 * 
	 * @returns null.
	 * 
	 */
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		try {
			Aluno aluno = new Aluno(nome, matricula, codigoCurso, telefone, email);
			this.verificarAlunoRepetido(matricula, "Aluno de mesma matricula ja cadastrado");
			
			this.alunos.put(matricula, aluno);
		}
		
		catch (IllegalArgumentException e1) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: " + e1.getMessage());
		}
		
		catch (NullPointerException e2) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: " + e2.getMessage());
		}
	}
	
	/**
	 * Verifica se a matricula passada existe ou n�o no sistema.
	 * 
	 * @param matricula Representa��o de matricula.
	 * @param msg Mensagem � ser retornada ao user caso tenha algum erro.
	 * 
	 * @returns null
	 */
	private void verificarAlunoInexistente(String matricula, String msg) {
		if (!this.alunos.containsKey(matricula)) {
			throw new IllegalArgumentException(msg);
		}
	}
	
	/**
	 * Recupera representa��o de Aluno contendo suas informa��es caso os dados passados estejam corretos.
	 * 
	 * @param matricula Representa��o de matricula do aluno.
	 * 
	 * @returns String Representa��o de Aluno.
	 */
	public String recuperaAluno(String matricula) {
		try {
			this.verificarAlunoInexistente(matricula, "Aluno nao encontrado");
			return this.alunos.get(matricula).toString();
		}
		
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro na busca por aluno: " + e.getMessage());
		}
	}
	
	/**
	 * Ordena os alunos por ordem alfabetica dos seus respectivos nomes.
	 * 
	 * 
	 * @returns List<Alunos> Lista de alunos em ordem.
	 */
	private List<Aluno> ordenarAlunos() {
		List<Aluno> alunosPorNome = new ArrayList<Aluno>();
		alunosPorNome.addAll(this.alunos.values());
		alunosPorNome.sort(this.ordenadorAlunos);
		
		return alunosPorNome;
	}
	
	/**
	 * Recupera lista de alunos registrados no sistema por ordem alfabetica.
	 * 
	 * 
	 * @returns String Representa��o de todos os alunos separados por v�rgula.
	 */
	public String listarAlunos() {
		String listagemAlunos = "";
		for (int i = 0; i < this.ordenarAlunos().size() - 1; i++) {
			listagemAlunos += ordenarAlunos().get(i).toString() + ", ";
		}
		
		listagemAlunos += ordenarAlunos().get(ordenarAlunos().size() - 1).toString();
		return listagemAlunos;
	}
	
	/**
	 * Recupera determinado atributo de Aluno. Tal atributo � passado nos parametros e n�o s�o aceitos atributos vazios ou nulos
	 * 
	 * @param matricula Representa��o de matricula do aluno.
	 * @param atribulo Atributo requisitado. 
	 * 
	 * @returns String Valor do atributo requisitado.
	 */
	public String getInfoAluno(String matricula, String atributo) {
		try {
			this.verificarAlunoInexistente(matricula, "Aluno nao encontrado");
			return AtributoAluno.valueOf(atributo.toUpperCase()).getAtributo(this.alunos.get(matricula));			
		}
		
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro na obtencao de informacao de aluno: " + e.getMessage());
		}
	}
	
	/**
	 * Registra no sistema um novo tutor com base nos seus atributos de Aluno.
	 * 
	 * @param matricula Representa��o de matricula do aluno.
	 * 
	 * @returns null
	 */
	private void criarNovoTutor(String matricula) {
		Aluno aluno = alunos.get(matricula);
		this.tutores.put(aluno.getMatricula(), new Tutor(aluno.getNome(), aluno.getMatricula(),
			    aluno.getCodigoCurso(), aluno.getTelefone(), aluno.getEmail()));
	}
	
	/**
	 * Torna Aluno um Tutor, n�o sendo possivel matriculas invalidas, proficiencias erradas e disciplinas vazias ou nulas. 
	 * 
	 * @param matricula Representa��o de matricula do aluno.
	 * @param disciplina Disciplina que o aluno ser� tutor.
	 * @param proficiencia Avalia��o de sua tutoria.
	 * 
	 * @returns null
	 */
	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		try {
			this.verificarAlunoInexistente(matricula, "Tutor nao encontrado");
			
			if (!this.tutores.keySet().contains(matricula)) {
				this.criarNovoTutor(matricula);
			}
			
			this.tutores.get(matricula).adicionarTutoria(disciplina, proficiencia);
		}
		
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro na definicao de papel: " + e.getMessage());
		}
	}
	
	/**
	 * Recupera representa��o de Tutor contendo suas informa��es caso os dados passados estejam corretos.
	 * 
	 * @param matricula Representa��o de matricula do tutor.
	 * 
	 * @returns String Representa��o de Tutor.
	 */
	public String recuperaTutor(String matricula) {
		try {
			this.verificarAlunoInexistente(matricula, "Tutor nao encontrado");
			return this.tutores.get(matricula).toString();
		}
		
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro na busca por tutor: " + e.getMessage());
		}
		
	}
	
	/**
	 * Gera lista de tutores para facilitar verifica��es.
	 * 
	 * 
	 * @returns List<Tutor> Lista de tutores cadastrados.
	 */
	private List<Tutor> tutoresToList() {
		List<Tutor> listaDeTutores = new ArrayList<Tutor>();
		listaDeTutores.addAll(this.tutores.values());
		
		return listaDeTutores;
	}
	
	/**
	 * Recupera lista de tutores registrados no sistema.
	 * 
	 * 
	 * @returns String Representa��o de todos os tutores separados por v�rgula.
	 */
	public String listarTutores() {
		String listagemTutores = "";
		
		for (int i = 0; i < this.tutoresToList().size() - 1; i++) {
			listagemTutores += tutoresToList().get(i).toString() + ", ";
		}
		
		listagemTutores += tutoresToList().get(tutoresToList().size() - 1).toString();		
		return listagemTutores;
	}
	
	/**
	 * Recupera matricula de tutores a partir do email do mesmo.
	 * 
	 * @param email Email do tutor.
	 * 
	 * @returns String matricula do tutor.
	 */
	private String getMatriculaPorEmail(String email) {
		for(Tutor tutor : this.tutoresToList()) {
			if(tutor.getEmail().equals(email)) {
				return tutor.getMatricula();
			}
		}
		
		return "";
	}
	
	/**
	 * Cadastra hor�rio de atendimento do tutor aos demais alunos. N�o s�o permitidos dados vazios ou nulos. 
	 * 
	 * @param email Email do tutor.
	 * @param horario Horario disponivel para atendimento.
	 * @param dia Dia que ser�o disponibilizadas as tutorias. 
	 * 
	 * @returns null
	 */
	public void cadastrarHorario(String email, String horario, String dia) {
		try {
			Validador.validarStringNaoVaziaNaoNula("email nao pode ser vazio ou em branco", email);
			Validador.validarStringNaoVazia("tutor nao cadastrado", this.getMatriculaPorEmail(email));
			
			this.tutores.get(this.getMatriculaPorEmail(email)).cadastrarHorario(horario, dia);
		}
		
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro no cadastrar horario: " + e.getMessage());
		}
	}
	
	/**
	 * Cadastra local de atendimento do tutor aos demais alunos. N�o s�o permitidos dados vazios ou nulos. 
	 * 
	 * @param email Email do tutor.
	 * @param local Local disponivel para atendimento dos alunos.
	 * 
	 * @returns null
	 */
	public void cadastrarLocalDeAtendimento(String email, String local) {
		try {
			Validador.validarStringNaoVaziaNaoNula("email nao pode ser vazio ou em branco", email);
			Validador.validarStringNaoVazia("tutor nao cadastrado", this.getMatriculaPorEmail(email));
			
			this.tutores.get(this.getMatriculaPorEmail(email)).cadastrarLocalDeAtendimento(local);
		}
		
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro no cadastrar local de atendimento: " + e.getMessage());
		}
	}
	
	/**
	 * Verifica hor�rio de atendimento do tutor aos demais alunos, caso o horario e dia estejam disponiveis � retornado True, se n�o, � 
	 * retornado False. N�o s�o permitidos dados vazios ou nulos. 
	 * 
	 * @param email Email do tutor.
	 * @param horario Horario disponivel para atendimento.
	 * @param dia Dia que ser�o disponibilizadas as tutorias. 
	 * 
	 * @returns boolean True se houver o horario ou False se n�o houver.
	 */
	public boolean consultaHorario(String email, String horario, String dia) {
		try {
			Validador.validarStringNaoVaziaNaoNula("email nao pode ser vazio ou em branco", email);
			Validador.validarStringNaoVazia("tutor nao cadastrado", this.getMatriculaPorEmail(email));
			
			return this.tutores.get(this.getMatriculaPorEmail(email)).consultaHorario(horario, dia);
		}
		
		catch (IllegalArgumentException e) {
			return false;
		}
	}
	
	/**
	 * Verifica o local de atendimento do tutor aos demais alunos, caso o local esteja correto � retornado True, se n�o, � 
	 * retornado False. N�o s�o permitidos dados vazios ou nulos. 
	 * 
	 * @param email Email do tutor.
	 * @param local Local disponivel para atendimento dos alunos.
	 * 
	 * @returns boolean True se houver o local registrado ou False se n�o houver.
	 */
	public boolean consultaLocal(String email, String local) {
		try {
			Validador.validarStringNaoVaziaNaoNula("email nao pode ser vazio ou em branco", email);
			Validador.validarStringNaoVazia("tutor nao cadastrado", this.getMatriculaPorEmail(email));
			
			return this.tutores.get(this.getMatriculaPorEmail(email)).consultaLocal(local);
		}
		
		catch (IllegalArgumentException e) {
			return false;
		}
	}

}
