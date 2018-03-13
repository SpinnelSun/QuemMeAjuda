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
							 "acc-tst/us3_test.txt", "acc-tst/us4_test.txt", "acc-tst/us5_test.txt",
							 "acc-tst/us6_test.txt"};
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
	
	/**
	 * Registra um novo pedido de Ajuda Presencial no Sistema.
	 * 
	 * @param matrAluno A matricula do Aluno solicitando Ajuda.
	 * @param disciplina O nome da disciplina de interesse do Aluno.
	 * @param horario A hora para atendimento de interesse do Aluno.
	 * @param dia O dia para atendimento de interesse do Aluno.
	 * @param localInteresse O nome do local de interesse para atendimento do Aluno.
	 * 
	 * @returns O ID da Ajuda Presencial registrada.
	 * 
	 * @see Sistema#pedirAjudaPresencial(String, String, String, String, String)
	 * 
	 */
	public int pedirAjudaPresencial (String matrAluno, String disciplina, String horario, String dia, String localInteresse) {
		return Facade.sistema.pedirAjudaPresencial(matrAluno, disciplina, horario, dia, localInteresse);
	}

	/**
	 * Registra um novo pedido de Ajuda Online no Sistema.
	 * 
	 * @param matrAluno A matricula do Aluno solicitando Ajuda.
	 * @param disciplina O nome da disciplina de interesse do Aluno.
	 * 
	 * @returns O ID da Ajuda Online registrada.
	 * 
	 * @see Sistema#pedirAjudaOnline(String, String)
	 * 
	 */
	public int pedirAjudaOnline (String matrAluno, String disciplina) {
		return Facade.sistema.pedirAjudaOnline(matrAluno, disciplina);
	}
	
	/**
	 * Retorna a representacao textual do Tutor responsavel por uma Ajuda especifica.
	 * 
	 * @param idAjuda O ID da Ajuda a ser consultada.
	 * 
	 * @returns A representacao textual do Tutor responsavel pela Ajuda consultada.
	 * 
	 * @see Sistema#pegarTutor(int)
	 * 
	 */
	public String pegarTutor(int idAjuda) {
		return Facade.sistema.pegarTutor(idAjuda);
	}
	
	/**
	 * Recupera uma informacao especifica de uma Ajuda ja cadastrada no Sistema.
	 * 
	 * @param idAjuda O ID da Ajuda a ser consultada.
	 * @param atributo A informacao de interesse a ser recuperada.
	 * 
	 * @returns A representacao textual da informacao solicitada ao Sistema.
	 * 
	 * @see Sistema#getInfoAjuda(int, String)
	 * 
	 */
	public String getInfoAjuda(int idAjuda, String atributo) {
		return Facade.sistema.getInfo(idAjuda, atributo);
	}
	
	/**
	 * Avalia o atendimento prestado por um Tutor durante uma Ajuda registrada no Sistema.
	 * 
	 * @param idAjuda O ID da Ajuda referente a avaliacao.
	 * @param nota A nota atribuida a avaliacao da Ajuda.
	 * 
	 * @returns null.
	 * 
	 * @see Sistema#avaliarTutor(int, int)
	 * 
	 */
    public void avaliarTutor (int idAjuda, int nota) {
    	Facade.sistema.avaliarTutor(idAjuda, nota); 
    }
    
    /**
	 * Retorna a nota de avaliacao de um Tutor ja registrado no Sistema.
	 * 
	 * @param matrTutor A matricula do Tutor de interesse na consulta.
	 * 
	 * @returns A nota de avaliacao do Tutor consultado.
	 * 
	 * @see Sistema#pegarNota(String)
	 * 
	 */
    public String pegarNota(String matriculaTutor) {
    	return Facade.sistema.pegarNota(matriculaTutor);
    }
    
    /**
	 * Retorna o nivel de avaliacao de um Tutor ja registrado no Sistema.
	 * 
	 * @param matrTutor A matricula do Tutor de interesse na consulta.
	 * 
	 * @returns O nivel de avaliacao do Tutor consultado.
	 * 
	 * @see Sistema#pegarNivel(String)
	 * 
	 */
    public String pegarNivel(String matriculaTutor) {
    	return Facade.sistema.pegarNivel(matriculaTutor);
    }
    
    /**
	 * Registra a doacao de uma quantia de dinheiro para um Tutor ja registrado no Sistema.
	 * 
	 * @param matrTutor A matricula do Tutor de interesse na consulta.
	 * @param matrTutor A quantia (em centavos) a ser doada.
	 * 
	 * @returns null.
	 * 
	 * @see Sistema#doar(String, int)
	 * 
	 */
    public void doar(String matriculaTutor, int totalCentavos) {
    	Facade.sistema.doar(matriculaTutor, totalCentavos);
    }
    
    /**
	 * Retorna a quantia de dinheiro ja recebida por um Tutor especifico registrado no Sistema.
	 * 
	 * @param emailTutor O email do Tutor de interesse na consulta.
	 * 
	 * @returns A quantia (em centavos) ja recebida pelo Tutor consultado.
	 * 
	 * @see Sistema#totalDinheiroTutor(String)
	 * 
	 */
    public int totalDinheiroTutor(String emailTutor) {
    	return Facade.sistema.totalDinheiroTutor(emailTutor);
    }
    
    /**
	 * Retorna a quantia de dinheiro ja recebida pela Sistema do Quem Me Ajuda a partir das doacoes.
	 * 
	 * @returns A quantia (em centavos) ja recebida pelo Sistema do Quem Me Ajuda.
	 * 
	 * @see Sistema#totalDinheiroSistema(String)
	 * 
	 */
    public int totalDinheiroSistema() {
    	return Facade.sistema.totalDinheiroSistema();
    }
    
    public void salvar() {
    	Facade.sistema.salvar();
    }
    
    public void carregar() {
    	Facade.sistema.carregar();
    }
    
    public void limpar() {
    	Facade.sistema.limpar();
    }
    
}