package controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.Map;

import general.AjudaException;
import general.AlunoException;
import general.AvaliacaoException;
import general.TutorException;
import general.Validador;
import models.Tutor;

/**
 * Representacao do Sistema que controla as entidades e suas respectivas propriedades do sistema
 * QuemMeAJuda. Todo sistema deve possuir um controller de Aluno, um controller de Tutor, um con-
 * troller de Ajuda e o caixa no qual sera depositado uma porcentagem de cada valor doado a um
 * Tutor.
 * 
 * Laboratorio de Programacao 2 - Projeto de Laboratorio - Quem Me Ajuda
 * 
 * @author Mateus de Lima Oliveira  - 117110219
 * @author Matheus Alves dos Santos - 117110503
 * @author Misael Augusto Silva da Costa - 117110525
 *
 */
public class Sistema implements Serializable {
	
	private AlunoController controladorAluno;
	private TutorController controladorTutor;
	private AjudaController controladorAjuda;
	
	private int caixa;
	
	/**
	 * Constroi o Sistema. Instancia os controllers de Alunos, Tutores e Ajudas, bem como inicia o
	 * caixa em zero..
	 * 
	 */
	public Sistema() {
		this.controladorAluno = new AlunoController();
		this.controladorTutor = new TutorController();
		this.controladorAjuda = new AjudaController();
		
		this.caixa = 0;
	}
	
	public int getCaixa() {
		return this.caixa;
	}
	
	public void setCaixa(int caixa) {
		this.caixa = caixa;
	}

	/**
	 * A partir das informacoes passadas como parametros desse metodo, solicita ao Controller de A-
	 * lunos o cadastro de um novo Aluno. Caso haja o lancamento de alguma excecao nesse processo,
	 * ela sera tratada e relancada.
	 * 
	 * @param nome O nome do Aluno a ser cadastrado.
	 * @param matricula A matricula do Aluno a ser cadastrado.
	 * @param codigoCurso O codigo do curso do Aluno a ser cadastrado.
	 * @param telefone O telefone do Aluno a ser cadastrado.
	 * @param email O email do Aluno a ser cadastrado.
	 * 
	 * @returns null.
	 * 
	 */
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		try {
			this.controladorAluno.cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
		}
		
		catch (RuntimeException e) {
			throw new AlunoException("Erro no cadastro de aluno: " + e.getMessage());
		}
	}
	
	/**
	 * Retorna a representacao textual de um dos Alunos cadastrados no AlunoController. O Aluno a
	 * ser recuperado sera aquele cuja matricula for informada como parametro do metodo. Caso haja
	 * o lancamento de alguma excecao nesse processo, ela sera tratada e relancada.
	 * 
	 * @param matricula A matricula do Aluno a ser acessado.
	 * 
	 * @returns A representacao textual do Aluno de interesse.
	 * 
	 */
	public String recuperaAluno(String matricula) {
		try {
			return this.controladorAluno.recuperaAluno(matricula);	
		}
		
		catch (RuntimeException e) {
			throw new AlunoException("Erro na busca por aluno: " + e.getMessage());
		}
	}

	/**
	 * Retorna a listagem dos Alunos atualmente cadastrados no AlunoController. Cada Aluno sera re-
	 * presentado por seu respectivo toString(). A listagem sera feita em linha unica (separando os
	 * Alunos por virgula).
	 * 
	 * @returns A listagem dos Alunos cadastrados.
	 * 
	 */
	public String listarAlunos() {
		return this.controladorAluno.listarAlunos();
	}
	
	/**
	 * Retorna a representacao textual de um dos atributos de um Aluno ja cadastrado no AlunoContro-
	 * ller. O Aluno que tera o atributo recuperado e aquele cuja matricula for igual a informada co-
	 * mo parametro do metodo. Caso haja o lancamento de alguma excecao nesse processo, ela sera tra-
	 * tada e relancada.
	 * 
	 * @param matricula A matricula do Aluno de interesse na consulta.
	 * @param atributo O nome do atributo de interesse na consulta.
	 * 
	 * @returns A informacao desejada sobre o Aluno consultado.
	 * 
	 */
	public String getInfoAluno(String matricula, String atributo) {
		try {
			return this.controladorAluno.getInfoAluno(matricula, atributo);
		}
		
		catch (RuntimeException e) {
			throw new AlunoException("Erro na obtencao de informacao de aluno: " + e.getMessage());
		}
	}
	
	/**
	 * Caso ainda nao haja cadastro de um Tutor com a matricula informada no TutorController, esse 
	 * metodo cadastrara um novo Tutor com os atributos passados como parametros no Controller ade-
	 * quado. Nao sera possivel cadastrar um Tutor que nao esta cadastrado como Aluno.
	 * 
	 * @param nome O nome do Tutor a ser cadastrado.
	 * @param matricula A matricula do Tutor a ser cadastrado.
	 * @param codigoCurso O codigo do curso do Tutor a ser cadastrado.
	 * @param telefone O telefone do Tutor a ser cadastrado.
	 * @param email O email do Tutor a ser cadastrado.
	 * 
	 * @returns null.
	 * 
	 */
	private void criarNovoTutor(String matricula) {
		try {
			this.controladorAluno.impedirAlunoNaoCadastrado(matricula, "Tutor nao encontrado");
			this.controladorTutor.criarNovoTutor(this.controladorAluno.getInfoAluno(matricula, "Matricula"), 
											 this.controladorAluno.getInfoAluno(matricula, "Nome"),
											 this.controladorAluno.getInfoAluno(matricula, "Curso"),
											 this.controladorAluno.getInfoAluno(matricula, "Telefone"),
											 this.controladorAluno.getInfoAluno(matricula, "Email"));
		}
		
		catch (RuntimeException e) {
			throw new AlunoException(e.getMessage());
		}
	}
	
	/**
	 * Adiciona uma Habilidade a um dos Tutores cadastrados no TutorController. Caso haja o lancamen-
	 * to de alguma excecao nesse processo, ela sera tratada e relancada.
	 * 
	 * @param matricula A matricula do Tutor a ser modificado.
	 * @param disciplina O nome da disciplina em que o Tutor possui Habilidade.
	 * @param proficiencia O nivel de proficiencia do Tutor na disciplina.
	 * 
	 * @returns null.
	 * 
	 */
	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		try {
			this.criarNovoTutor(matricula);
			this.controladorTutor.tornarTutor(matricula, disciplina, proficiencia);
		}
		
		catch (RuntimeException e) {
			throw new TutorException("Erro na definicao de papel: " + e.getMessage());
		}
		
	}
	
	/**
	 * Retorna a representacao textual de um dos Tutores cadastrados no TutorController. O Tutor a
	 * ser recuperado sera aquele cuja matricula for informada como parametro do metodo. Caso haja
	 * o lancamento de alguma excecao nesse processo, ela sera tratada e relancada.
	 * 
	 * @param matricula A matricula do Tutor a ser acessado.
	 * 
	 * @returns A representacao textual do Tutor de interesse.
	 * 
	 */
	public String recuperaTutor(String matricula) {
		try {
			return this.controladorTutor.recuperaTutor(matricula);
		}
		
		catch (RuntimeException e) {
			throw new TutorException("Erro na busca por tutor: " + e.getMessage());
		}
		
	}
	
	/**
	 * Retorna a listagem dos Tutores atualmente cadastrados no TutorController. Cada Tutor sera re-
	 * presentado por seu respectivo toString(). A listagem sera feita em linha unica (separando os
	 * Tutores por virgula).
	 * 
	 * @returns A listagem dos Tutores cadastrados.
	 * 
	 */
	public String listarTutores() {
		return this.controladorTutor.listarTutores();
	}
	
	/**
	 * Adiciona um Horario para atendimento na Disponibilidade de um dos Tutores cadastrados no Tu-
	 * torController. Caso haja o lancamento de alguma excecao nesse processo, ela sera tratada e
	 * relancada.
	 * 
	 * @param email O e-mail do Tutor a ser modificado.
	 * @param hora A hora a ser associada no Horario para atendimento.
	 * @param dia O dia da semana a ser associado no Horario para atendimento.
	 * 
	 * @returns null.
	 * 
	 */
	public void cadastrarHorario(String email, String hora, String dia) {
		try {
			this.controladorTutor.cadastrarHorario(email, hora, dia);
		}
		
		catch (RuntimeException e) {
			throw new TutorException("Erro no cadastrar horario: " + e.getMessage());
		}
	}
	
	/**
	 * Adiciona um Local para atendimento na Disponibilidade de um dos Tutores cadastrados no Tutor-
	 * Controller. Caso haja o lancamento de alguma excecao nesse processo, ela sera tratada e
	 * relancada.
	 * 
	 * @param email O e-mail do Tutor a ser modificado.
	 * @param local O nome do Local para atendimento a ser cadastrado.
	 * 
	 * @returns null.
	 * 
	 */
	public void cadastrarLocalDeAtendimento(String email, String local) {
		try {
			this.controladorTutor.cadastrarLocalDeAtendimento(email, local);
		}
		
		catch (RuntimeException e) {
			throw new TutorException("Erro no cadastrar local de atendimento: " + e.getMessage());
		}
	}
	
	/**
	 * Verifica se um Tutor cadastrado no TutorController possui um Horario especifico cadastrado em
	 * sua Disponibilidade. 
	 * 
	 * @param email O e-mail do Tutor a ser analisado.
	 * @param hora A hora de interesse para a verificacao.
	 * @param dia O dia de interesse para a verificacao.
	 * 
	 * @returns O boolean referente a disponibilidade do Horario de interesse.
	 * 
	 */
	public boolean consultaHorario(String email, String hora, String dia) {
		return this.controladorTutor.consultaHorario(email, hora, dia);
	}
	
	/**
	 * Verifica se um Tutor cadastrado no TutorController possui um Local especifico cadastrado em
	 * sua Disponibilidade.
	 * 
	 * @param email O e-mail do Tutor a ser analisado.
	 * @param local O nome do Localde interesse para a verificacao.
	 * 
	 * @returns O boolean referente a disponibilidade do Local de interesse.
	 * 
	 */
	public boolean consultaLocal(String email, String local) {
		return this.controladorTutor.consultaLocal(email, local);
	}
	
	/**
	 * Seleciona o mais apto dentre os Tutores cadastrados em TutorController que sao Candidatos ca-
	 * pazes de assumir os atendimentos de uma AjudaOnline de certa disciplina.
	 * 
	 * @param disciplina O nome da disciplina de interesse na selecao.
	 * 
	 * @returns A matricula do Candidato/Tutor selecionado para prestar o atendimento.
	 * 
	 */
	private String selecionarCandidato(String disciplina) {
		Validador.validarStringNaoVaziaNaoNula("disciplina nao pode ser vazio ou em branco", disciplina);
		return this.controladorTutor.selecionarCandidato(disciplina);
	}
	
	/**
	 * A partir das informacoes passadas como parametros desse metodo, cadasta uma nova AjudaOnline
	 * no AjudaController. O ID da nova AjudaOnline cadastrada sera retornado. Caso haja o lancamen-
	 * to de alguma excecao nesse processo, ela sera tratada e relancada.
	 * 
	 * @param matricula A matricula do Aluno solicitante da Ajuda.
	 * @param disciplina A disciplina referente a Ajuda.
	 * @param matriculaTutor A matricula do Tutor responsavel pelo atendimento.
	 * 
	 * @returns O ID da AjudaOnline cadastrada.
	 * 
	 */
	public int pedirAjudaOnline (String matriculaAluno, String disciplina) {
		try {
			return this.controladorAjuda.pedirAjudaOnline(matriculaAluno, disciplina,
				   this.selecionarCandidato(disciplina));
		}
		
		catch (RuntimeException e) {
			throw new AjudaException("Erro no pedido de ajuda online: " + e.getMessage());
		}
	}
	
	/**
	 * Seleciona o mais apto dentre os Tutores cadastrados em TutorController que sao Candidatos ca-
	 * pazes de assumir os atendimentos de uma AjudaPresencial de certa disciplina.
	 * 
	 * @param disciplina O nome da disciplina de interesse na selecao.
	 * @param hora A hora de interesse para atendimento.
	 * @param dia O dia de interesse na listagem para atendimento.
	 * @param local O nome do local de interesse para atendimento.
	 * 
	 * @returns A matricula do Candidato/Tutor selecionado para prestar o atendimento.
	 * 
	 */
	private String selecionarTutor(String disciplina, String horario, String dia, String localInteresse) {
		Validador.validarStringNaoVaziaNaoNula("disciplina nao pode ser vazio ou em branco", disciplina);
		return this.controladorTutor.selecionarCandidato(disciplina, horario, dia, localInteresse);
	}
	
	/**
	 * A partir das informacoes passadas como parametros desse metodo, cadasta uma nova AjudaPresen-
	 * cial no AjudaController. O ID da nova AjudaPresencial cadastrada sera retornado. Caso haja o
	 * lancamento de alguma excecao nesse processo, ela sera tratada e relancada.
	 * 
	 * @param matricula A matricula do Aluno solicitante da Ajuda.
	 * @param disciplina A disciplina referente a Ajuda.
	 * @param hora A hora do atendimento.
	 * @param dia O dia do atendimento.
	 * @param local O local do atendimento.
	 * @param matriculaTutor A matricula do Tutor responsavel pelo atendimento.
	 * 
	 * @returns O ID da AjudaOnline cadastrada.
	 * 
	 */
	public int pedirAjudaPresencial (String matriculaAluno, String disciplina, String horario, String dia, String localInteresse) {
		try {
			return this.controladorAjuda.pedirAjudaPresencial(matriculaAluno, disciplina, horario, dia,
				   localInteresse, this.selecionarTutor(disciplina, horario, dia, localInteresse));
		}
		
		catch (RuntimeException e) {
			throw new AjudaException("Erro no pedido de ajuda presencial: " + e.getMessage());
		}
	}
	
	/**
	 * Retorna a representacao textual do Tutor responsavel por atender a uma Ajuda castrada no Aju-
	 * daController a partir do ID dessa Ajuda. Caso haja o lancamento de alguma excecao nesse pro-
	 * cesso, ela sera tratada e relancada.
	 * 
	 * @param idAjuda O ID da Ajuda de interesse na consulta.
	 * 
	 * @returns A representacao textual do Tutor responsavel pela Ajuda.
	 * 
	 */
	public String pegarTutor(int idAjuda) {
		try {
			return this.controladorAjuda.pegarTutor(idAjuda);
		}
		
		catch (RuntimeException e) {
			throw new AjudaException("Erro ao tentar recuperar tutor : " + e.getMessage());
		}
	}
	
	/**
	 * Retorna a representacao textual de um dos atributos de uma Ajuda ja cadastrada. A Ajuda que
	 * tera o atributo recuperado e aquela cujo ID for igual ao informado como parametro do metodo.
	 * Caso haja o lancamento de alguma excecao nesse processo, ela sera tratada e relancada.
	 * 
	 * @param idAjuda O ID da Ajuda de interesse na consulta.
	 * @param atributo O nome do atributo de interesse na consulta.
	 * 
	 * @returns A informacao desejada sobre a Ajuda consultada.
	 * 
	 */
	public String getInfo(int idAjuda, String atributo) {
		try {
			return this.controladorAjuda.getInfoAjuda(idAjuda, atributo);
		}
		
		catch (RuntimeException e) {
			throw new AjudaException("Erro ao tentar recuperar info da ajuda : " + e.getMessage());
		}
	}
	
	/**
	 * Avalia o Tutor que prestou atendimento a uma das Ajudas cadastradas no AjudaController. Cada
	 * Ajuda so podera ser avaliada uma vez. Alem disso, a nota atribuida devera estar no intervalo
	 * adequado. Caso haja o lancamento de alguma excecao nesse processo, ela sera tratada e relan-
	 * cada.
	 *  
	 * @param idAjuda O id de identificacao da Ajuda
	 * @param nota O valor da nota a ser atribuida
	 * 
	 * @returns null.
	 */
	public void avaliarTutor (int idAjuda, int nota) {
		 try {
			 Validador.validarIntNaoNegativo("nota nao pode ser menor que 0", nota);
			 Validador.validarIntMenorQueCinco("nota nao pode ser maior que 5", nota);	
			 
			 this.controladorAjuda.registrarAvaliacao(idAjuda);
			 this.controladorTutor.adicionarAvaliacao(this.controladorAjuda.getInfoAjuda(idAjuda,
					 								  "TUTOR"), nota);
		 }
		 
		 catch (RuntimeException e) {
				throw new AvaliacaoException("Erro na avaliacao de tutor: " + e.getMessage());
		} 
	}
	
	/**
	 * Retorna a nota de avaliacao de um dos Tutores cadastrados no TutorController. O Tutor a ter
	 * sua nota recuperada sera aquele cuja matricula for informada como parametro do metodo. Caso
	 * haja o lancamento de alguma excecao nesse processo, ela sera tratada e relancada.
	 * 
	 * @param matricula A matricula do Tutor a ser acessado.
	 * 
	 * @returns A nota de avaliacao do Tutor de interesse.
	 * 
	 */ 
	public String pegarNota(String matriculaTutor) {
		try {
			return this.controladorTutor.pegarNota(matriculaTutor);
		}
		
		catch (RuntimeException e) {
			throw new AvaliacaoException("Erro ao tentar pegar nota de tutor : " + e.getMessage());
		}
	}
	
	/**
	 * Retorna o nivel de avaliacao de um dos Tutores cadastrados no TutorController. O Tutor a ter
	 * seu nivel recuperado sera aquele cuja matricula for informada como parametro do metodo. Caso
	 * haja o lancamento de alguma excecao nesse processo, ela sera tratada e relancada.
	 * 
	 * @param matricula A matricula do Tutor a ser acessado.
	 * 
	 * @returns O nivel de avaliacao do Tutor de interesse.
	 * 
	 */
	public String pegarNivel(String matriculaTutor) {
		try {
			return this.controladorTutor.pegarNivel(matriculaTutor);
		}
		
		catch (RuntimeException e) {
			throw new AvaliacaoException("Erro ao tentar pegar nivel de tutor : " + e.getMessage());
		}
	}
	
	/**
	 * Realiza uma doacao a um dos Tutores cadastrados no TutorController. O Sistema recebera uma
	 * comissao de cada doacao realizada aos Tutores, o percentual referente a essa comissao varia
	 * conforme o quao bem avaliado esta o Tutor a receber a doacao. Caso haja o lancamento de al-
	 * guma excecao nesse processo, ela sera tratada e relancada.
	 * 
	 * @param matriculaTutor A matricula do Tutor que recebera a doacao.
	 * @param totalCentavos A quantia (em centavos) a ser doada.
	 * 
	 * @returns null.
	 */
	public void doar(String matriculaTutor, int totalCentavos) {
		try {
			this.controladorTutor.adicionarDoacao(matriculaTutor, totalCentavos);
			this.setCaixa(this.totalDinheiroSistema() + this.controladorTutor.calcularComissao(matriculaTutor,
																				   totalCentavos));
		}

		catch (RuntimeException e) {
			throw new TutorException("Erro na doacao para tutor: " + e.getMessage());
		}
	}
	
	/**
	 * Retorna o total de dinheiro (em centavos) recebido por um Tutor cadastrado no TutorController.
	 * O Tutor a ter sua quantia ganha recuperada sera aquele cujo e-mail for informado como parame-
	 * tro do metodo. Caso haja o lancamento de alguma excecao nesse processo, ela sera tratada e re-
	 * lancada.
	 * 
	 * @param email O e-mail do Tutor a ser acessado.
	 * 
	 * @returns A quantia ja recebida pelo Tutor de interesse.
	 * 
	 */
	public int totalDinheiroTutor(String emailTutor) {
		try {
			Validador.validarStringNaoVaziaNaoNula("emailTutor nao pode ser vazio ou nulo", emailTutor);
			return this.controladorTutor.getTotalDinheiroTutor(emailTutor);
		}
		
		catch (RuntimeException e) {
			throw new TutorException("Erro na consulta de total de dinheiro do tutor: " +
												e.getMessage());
		}
	}
	
	/**
	 * Retorna o total de dinheiro (em centavos) recebido pelo QuemMeAjuda ate o presente momento, re-
	 * ferente as comissoes retiradas de cada doacao realizada a um dos Tutores cadastrados no Tutor-
	 * Controller.
	 * 
	 * @returns A quantia ja recebida pelo QuemMeAjuda.
	 * 
	 */
	public int totalDinheiroSistema() {
		return this.getCaixa();
	}
	
	/**
	 * Modifica a ordenacao utilizada em listarAlunos() e listarTutores().
	 * 
	 * @param atributo O nome do atributo a ser utilizado para a ordenacao.
	 * 
	 * @returns null.
	 * 
	 */
	public void configurarOrdem(String atributo) {
		this.controladorAluno.configurarOrdem(atributo);
		this.controladorTutor.configurarOrdem(atributo);
	}
	
    /**
   	 * Armazena o atual valor (em centavos) registrado no Caixa do Sistema.
   	 *  
   	 * @returns null.
   	 * 
   	 */
	private void salvarCaixaSistema() {
		try{
			File file = new File("database//CaixaSistema.dat");
			FileOutputStream fos = new FileOutputStream(file);		
			ObjectOutputStream oos = new ObjectOutputStream(fos);
		
			oos.writeObject(this.caixa);
			oos.close();
			fos.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
    /**
   	 * Armazena todos os dados dos Tutores, Alunos e Ajudas registrados atualmente no Sistema. Alem
   	 * disso, o valor atual no caixa do Sistema tambem sera armazenado. O armazenamento dos dados
   	 * sera feito em arquivos .dat.
   	 * 
   	 * @returns null.
   	 * 
	 */
	public void salvar() {
		this.salvarCaixaSistema();
		this.controladorAluno.salvar();
		this.controladorTutor.salvar();
		this.controladorAjuda.salvar();    	
    }
	
	/**
	 * Limpa todos os dados armazenados previamente pelo Quem Me Ajuda.
	 * 
	 * @returns null.
	 * 
	 */
    public void limpar()  {
    	this.setCaixa(0);
	    this.controladorAluno.limpar();
	    this.controladorAjuda.limpar();
	    this.controladorTutor.limpar();
    }
	
	/**
   	 * Carrega a quantia (em centavos) armazenada no caixa do Sistema no momento do ultimo armazena-
   	 * mento de dados.
   	 * 
   	 * @returns null.
   	 * 
	 */
	private void carregarCaixaSistema() {
		try {
			File file = new File("database//CaixaSistema.dat");
			FileInputStream fis = new FileInputStream(file);		
			ObjectInputStream ois = new ObjectInputStream(fis);
			   
			this.setCaixa(((int) ois.readObject())); 
			
			ois.close();
			fis.close();
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
   	 * Carrega todos os dados dos Tutores, Alunos e Ajudas (armazenados previamente) no Sistema. O
   	 * caixa do Sistema tambem voltara ao valor que contava no momento do armazenamento dos dados.
   	 * 
   	 * @returns null.
   	 * 
	 */
    public void carregar() {
    	this.controladorAluno.carregar();
    	this.controladorTutor.carregar();
    	this.controladorAjuda.carregar();
    }

}
