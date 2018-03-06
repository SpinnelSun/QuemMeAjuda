package controllers;

import easyaccept.EasyAccept;

/**
 * Facade Controller do Quem Me Ajuda.
 * 
 * Laboratorio de Programacao 2 - Projeto de Laboratorio - Quem Me Ajuda
 * 
 * @author Mateus de Lima Oliveira  - 117110219
 * @author Matheus Alves dos Santos - 117110503
 * @author Misael Augusto Silva da Costa - 117110525
 *
 */
public class Facade {
	
	private static Sistema sistema;
	
	public static void main(String[] args) {
		inicializar();
		
		args = new String[] {"controllers.Facade", "acc-tst/us1_test.txt", "acc-tst/us2_test.txt",
							 "acc-tst/us3_test.txt", "acc-tst/us4_test.txt", "acc-tst/us5_test.txt"};
		EasyAccept.main(args);
	}
	
	/**
	 * Inicializa o Sistema do Quem Me Ajuda.
	 * 
	 * @returns null.
	 * 
	 * @see Sistema#Sistema()
	 * 
	 */
	public static void inicializar() {
		Facade.sistema = new Sistema();
	}
	
	/**
	 * Cadastra um novo Aluno no Sistema.
	 * 
	 * @param nome O nome do Aluno a ser cadastrado.
	 * @param matricula A matricula do Aluno a ser cadastrado.
	 * @param codigoCurso O codigo do curso do Aluno a ser cadastrado.
	 * @param telefone O telefone do Aluno (se possuir) a ser cadastrado.
	 * @param email O email do Aluno a ser cadastrado.
	 * 
	 * @returns null.
	 * 
	 * @see Sistema#cadastrarAluno(String, String, int, String, String)
	 * 
	 */
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		Facade.sistema.cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
	}
	
	/**
	 * Retorna a representacao textual de um Aluno ja cadastrado no Sistema.
	 * 
	 * @param matricula A matricula do Aluno a ser recuperado.
	 * 
	 * @returns A representacao textual do Aluno.
	 * 
	 * @see Sistema#recuperaAluno(String)
	 * 
	 */
	public String recuperaAluno(String matricula) {
		return Facade.sistema.recuperaAluno(matricula);
	}
	
	/**
	 * Lista os Alunos atualmente cadastrados no Sistema do Quem Me Ajuda.
	 * 
	 * @returns A listagem dos Alunos cadastrados.
	 * 
	 * @see Sistema#listarAlunos()
	 * 
	 */
	public String listarAlunos() {
		return Facade.sistema.listarAlunos();
	}
	
	/**
	 * Recupera uma informacao especifica de um Aluno ja cadastrado no Sistema.
	 * 
	 * @param matricula A matricula do Aluno de interesse.
	 * @param atributo A informacao de interesse a ser recuperada.
	 * 
	 * @returns A representacao textual da informacao solicitada ao Sistema.
	 * 
	 * @see Sistema#getInfoAluno(String, String)
	 * 
	 */
	public String getInfoAluno(String matricula, String atributo) {
		return Facade.sistema.getInfoAluno(matricula, atributo);
	}
	
	/**
	 * Garante a Tutoria de uma certa disciplina a um Aluno ja cadastrado no Sistema.
	 * 
	 * @param matricula A matricula do Aluno que se tornara Tutor.
	 * @param disciplina A disciplina que recebera o novo Tutor.
	 * @param proficiencia O nivel de habilidade do Aluno na disciplina.
	 * 
	 * @returns null.
	 * 
	 * @see Sistema#tornarTutor(String, String, int)
	 * 
	 */
	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		Facade.sistema.tornarTutor(matricula, disciplina, proficiencia);
	}
	
	/**
	 * Recupera a representacao textual de um Tutor ja cadastrado no Sistema.
	 * 
	 * @param matricula A matricula do Tutor a ser recuperado.
	 * 
	 * @returns A representacao textual do Tutor recuperado.
	 * 
	 * @see Sistema#recuperaTutor(String)
	 * 
	 */
	public String recuperaTutor(String matricula) {
		return Facade.sistema.recuperaTutor(matricula);
	}
	
	/**
	 * Lista os Tutores atualmente cadastrados no Sistema do Quem Me Ajuda.
	 * 
	 * @returns A listagem dos Tutores cadastrados.
	 * 
	 * @see Sistema#listarTutores()
	 * 
	 */
	public String listarTutores() {
		return Facade.sistema.listarTutores();
	}
	
	/**
	 * Torna um Tutor disponivel em um determinado Horario da semana.
	 * 
	 * @param email O email do Tutor que possuira o Horario disponivel.
	 * @param horario A hora a ser cadastrada como disponivel.
	 * @param dia O dia da semana referente ao Horario disponivel.
	 * 
	 * @returns null.
	 * 
	 * @see Sistema#cadastrarHorario(String, String, String)
	 * 
	 */
	public void cadastrarHorario(String email, String horario, String dia) {
		Facade.sistema.cadastrarHorario(email, horario, dia); 
	}
	
	/**
	 * Torna um Tutor apto a atender os Alunos em um determinado Local.
	 * 
	 * @param email O email do Tutor que podera atender no Local.
	 * @param local O nome do Local de atendimento a ser cadastrado.
	 * 
	 * @returns null.
	 * 
	 * @see Sistema#cadastrarLocalDeAtendimento(String, String)
	 * 
	 */
	public void cadastrarLocalDeAtendimento(String email, String local) {
		Facade.sistema.cadastrarLocalDeAtendimento(email, local);
	}
	
	/**
	 * Verifica se um Tutor esta disponivel em um determinado Horario.
	 * 
	 * @param email O email do Tutor a ser verificado.
	 * @param horario A hora de interesse na verificacao.
	 * @param dia O dia de interesse na verificacao.
	 * 
	 * @returns O boolean referente a verificacao de disponibilidade.
	 * 
	 * @see Sistema#consultaHorario(String, String, String)
	 * 
	 */
	public boolean consultaHorario(String email, String horario, String dia) {
		return Facade.sistema.consultaHorario(email, horario, dia);
	}
	
	/**
	 * Verifica se um Tutor esta disponivel para atender em um determinado Local.
	 * 
	 * @param email O email do Tutor a ser verificado.
	 * @param local O nome do local de interesse na verificacao.
	 * 
	 * @returns O boolean referente a verificacao de disponibilidade.
	 * 
	 * @see Sistema#consultaLocal(String, String)
	 * 
	 */
	public boolean consultaLocal(String email, String local) {
		return Facade.sistema.consultaLocal(email, local);
	}
	
	public int pedirAjudaPresencial (String matrAluno, String disciplina, String horario, String dia, String localInteresse) {
		return Facade.sistema.pedirAjudaPresencial(matrAluno, disciplina, horario, dia, localInteresse);
	}
	
	public int pedirAjudaOnline (String matrAluno, String disciplina) {
		return Facade.sistema.pedirAjudaOnline(matrAluno, disciplina);
	}
	
	public String pegarTutor(int idAjuda) {
		return Facade.sistema.pegarTutor(idAjuda);
	}
	
	public String getInfoAjuda(int idAjuda, String atributo) {
		return Facade.sistema.getInfo(idAjuda, atributo);
	}
	
    public String avaliarTutor (int idAjuda, int nota) {
    	return ""; 
    }
    
    public double pegarNota(String matriculaTutor) {
    	return 0.0;
    }
    
    public String pegarNivel(String matriculaTutor) {
    	return Facade.sistema.pegarNivel(matriculaTutor);
    }
    
    public void doar(String matriculaTutor, int totalCentavos) {
    	Facade.sistema.doar(matriculaTutor, totalCentavos);
    }
    
    public int totalDinheiroTutor(String emailTutor) {
    	return Facade.sistema.getTotalDinheiroTutor(emailTutor);
    }
    
    public int totalDinheiroSistema() {
    	return 0;
    }
    
}