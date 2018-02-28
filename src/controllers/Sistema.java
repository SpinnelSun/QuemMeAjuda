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
 * Representação de um Sistema que tem como objetivo aproximar alunos
 * que precisam de ajuda em disciplinas dos demais alunos capacitados
 * para oferecer ajuda. No sistema, o aluno pode realizar seu cadastro e 
 * se colocar como tutor. O software deve dar suporte a listagem de 
 * alunos e tutores e deve permitir a criação de ajudas.
 * 
 * Laboratório de Programação 2 - Projeto - Quem me ajuda
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
	 * Constrói um Sistema.
	 * 
	 */
	public Sistema() {
		this.alunos = new HashMap<String, Aluno>();
		this.tutores = new HashMap<String, Tutor>();
		this.ordenadorAlunos = new AlunoPorNome();
	}
	
	/**
	 * Verifica se determinada matricula já está no sistema.
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
	 * Cadastra um anulo no sistema. Não é permitido o cadastro de alunos repetidos, com dados vazios ou nulos ou email inválido. Porém, telefone pode ser vazio
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
	 * Verifica se a matricula passada existe ou não no sistema.
	 * 
	 * @param matricula Representação de matricula.
	 * @param msg Mensagem à ser retornada ao user caso tenha algum erro.
	 * 
	 * @returns null
	 */
	private void verificarAlunoInexistente(String matricula, String msg) {
		if (!this.alunos.containsKey(matricula)) {
			throw new IllegalArgumentException(msg);
		}
	}
	
	/**
	 * Recupera representação de Aluno contendo suas informações caso os dados passados estejam corretos.
	 * 
	 * @param matricula Representação de matricula do aluno.
	 * 
	 * @returns String Representação de Aluno.
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
	 * @returns String Representação de todos os alunos separados por vírgula.
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
	 * Recupera determinado atributo de Aluno. Tal atributo é passado nos parametros e não são aceitos atributos vazios ou nulos
	 * 
	 * @param matricula Representação de matricula do aluno.
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
	 * @param matricula Representação de matricula do aluno.
	 * 
	 * @returns null
	 */
	private void criarNovoTutor(String matricula) {
		Aluno aluno = alunos.get(matricula);
		this.tutores.put(aluno.getMatricula(), new Tutor(aluno.getNome(), aluno.getMatricula(),
			    aluno.getCodigoCurso(), aluno.getTelefone(), aluno.getEmail()));
	}
	
	/**
	 * Torna Aluno um Tutor, não sendo possivel matriculas invalidas, proficiencias erradas e disciplinas vazias ou nulas. 
	 * 
	 * @param matricula Representação de matricula do aluno.
	 * @param disciplina Disciplina que o aluno será tutor.
	 * @param proficiencia Avaliação de sua tutoria.
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
	 * Recupera representação de Tutor contendo suas informações caso os dados passados estejam corretos.
	 * 
	 * @param matricula Representação de matricula do tutor.
	 * 
	 * @returns String Representação de Tutor.
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
	 * Gera lista de tutores para facilitar verificações.
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
	 * @returns String Representação de todos os tutores separados por vírgula.
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
	 * Cadastra horário de atendimento do tutor aos demais alunos. Não são permitidos dados vazios ou nulos. 
	 * 
	 * @param email Email do tutor.
	 * @param horario Horario disponivel para atendimento.
	 * @param dia Dia que serão disponibilizadas as tutorias. 
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
	 * Cadastra local de atendimento do tutor aos demais alunos. Não são permitidos dados vazios ou nulos. 
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
	 * Verifica horário de atendimento do tutor aos demais alunos, caso o horario e dia estejam disponiveis é retornado True, se não, é 
	 * retornado False. Não são permitidos dados vazios ou nulos. 
	 * 
	 * @param email Email do tutor.
	 * @param horario Horario disponivel para atendimento.
	 * @param dia Dia que serão disponibilizadas as tutorias. 
	 * 
	 * @returns boolean True se houver o horario ou False se não houver.
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
	 * Verifica o local de atendimento do tutor aos demais alunos, caso o local esteja correto é retornado True, se não, é 
	 * retornado False. Não são permitidos dados vazios ou nulos. 
	 * 
	 * @param email Email do tutor.
	 * @param local Local disponivel para atendimento dos alunos.
	 * 
	 * @returns boolean True se houver o local registrado ou False se não houver.
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
