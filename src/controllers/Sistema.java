package controllers;

import java.text.DecimalFormat;

import utility.Validador;

/**
 * Representacao do Sistema que controla as entidades e suas respectivas propriedades do sistema
 * QuemMeAJuda. Todo sistema deve possuir um controller de Aluno, um controller de Tutor, um con-
 * troller de Ajuda e o caixa no qual sera depositado uma porcentagem de cada valor doado a um Tutor.
 * 
 * Laboratorio de Programacao 2 - Projeto de Laboratorio - Quem Me Ajuda
 * 
 * @author Mateus de Lima Oliveira  - 117110219
 * @author Matheus Alves dos Santos - 117110503
 * @author Misael Augusto Silva da Costa - 117110525
 *
 */
public class Sistema {
	
	private AlunoController controladorAluno;
	private TutorController controladorTutor;
	private AjudaController controladorAjuda;
	
	private int caixa;
	
	/**
	 * Constroi um Sistema. Instancia os controllers de Aluno, Tutor e Ajuda respectivamente e atribui
	 * ao caixa o valor inicial padrao (zero).
	 * 
	 */
	public Sistema() {
		this.controladorAluno = new AlunoController();
		this.controladorTutor = new TutorController();
		this.controladorAjuda = new AjudaController();
		
		this.caixa = 0;
	}
	
	/**
	 * Cadastra um Aluno no controller de Aluno a partir de seu nome, de seu telefone, de sua matricu-
	 * la, do codigo de seu curso e do seu email passados como parametro. Alem disso, verifica e relan-
	 * ca as excecoes para os casos de invalidez de algum parametro.
	 * 
	 * @param nome O nome do Aluno.
	 * @param matricula A matricula do Aluno.
	 * @param codigoCurso O codigo do curso do Aluno.
	 * @param telefone O numero do telefone do Aluno.
	 * @param email O email do Aluno.
	 * 
	 * @returns null.
	 */
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		try {
			this.controladorAluno.cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
		}
		
		catch (IllegalArgumentException e1) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: " + e1.getMessage());
		}
		
		catch (NullPointerException e2) {
			throw new NullPointerException("Erro no cadastro de aluno: " + e2.getMessage());
		}
	}
	
	/**
	 * Resgata, a partir da matricula, um aluno do controller de Aluno e, caso este exista, retorna
	 * a sua representacao textual, do contrario lanca uma excecao para o caso.
	 * 
	 * "matricula - nome - codigoCurso - telefone - email"
	 * "matricula - nome - codigoCurso - email"
	 * 
	 * @param matricula A matricula do Aluno.
	 * 
	 * @returns A representacao textual de algum aluno do sistema.
	 */
	public String recuperaAluno(String matricula) {
		try {
			return this.controladorAluno.recuperaAluno(matricula);	
		}
		
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro na busca por aluno: " + e.getMessage());
		}
	}

	/**
	 * Resgata e retorna uma mensagem montada pela representacao textual de todos os alunos cadastra-
	 * dos no Sistema.
	 * 
	 * @returns A representacao textual de todos os alunos do sistema.
	 */
	public String listarAlunos() {
		return this.controladorAluno.listarAlunos();
	}
	
	/**
	 * Resgata e retorna um atributo de determinado Aluno do Sistema a partir da matricula do aluno
	 * e de uma String que represente um determinado atributo do Aluno. Caso o atributo passado como
	 * parametro nao exista ou seja invalido (nulo ou vazio) uma excecao e lancada para o caso.
	 * 
	 * "atributoAluno"
	 * 
	 * @param matricula A matricula do Aluno
	 * @param atributo O atributo do Aluno
	 * 
	 * @returns O valor de determinado atributo do Aluno.
	 */
	public String getInfoAluno(String matricula, String atributo) {
		try {
			return this.controladorAluno.getInfoAluno(matricula, atributo);
		}
		
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro na obtencao de informacao de aluno: " + e.getMessage());
		}
	}
	
	private void criarNovoTutor(String matricula) {
		this.controladorAluno.impedirAlunoNaoCadastrado(matricula, "Tutor nao encontrado");
		
		this.controladorTutor.criarNovoTutor(this.controladorAluno.getInfoAluno(matricula, "Matricula"), 
											 this.controladorAluno.getInfoAluno(matricula, "Nome"),
											 this.controladorAluno.getInfoAluno(matricula, "Curso"),
											 this.controladorAluno.getInfoAluno(matricula, "Telefone"),
											 this.controladorAluno.getInfoAluno(matricula, "Email"));
	}
	
	/**
	 * Nao retorna nada, apenas resgata um aluno do sistema a partir da sua matricula e torna-o tu-
	 * tor com a disciplina e a proficiencia passadas como parametro.
	 * 
	 * @param matricula A matricula do Aluno
	 * @param disciplina A disciplina do Tutor
	 * @param proficiencia O nivel de conhecimento do Tutor na disciplina
	 * 
	 * @returns null.
	 */
	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		try {
			this.criarNovoTutor(matricula);
			this.controladorTutor.tornarTutor(matricula, disciplina, proficiencia);
		}
		
		catch (IllegalArgumentException e1) {
			throw new IllegalArgumentException("Erro na definicao de papel: " + e1.getMessage());
		}
		
		catch (NullPointerException e2) {
			throw new NullPointerException("Erro na definicao de papel: " + e2.getMessage());
		}
		
	}
	
	/**
	 * Resgata, a partir da matricula, um tutor do controller de Tutor e, caso este exista, retorna
	 * a sua representacao textual, do contrario lanca uma excecao para o caso.
	 * 
	 * "matricula - nome - codigoCurso - telefone - email"
	 * "matricula - nome - codigoCurso - email"
	 * 
	 * @param matricula A matricula do Tutor.
	 * 
	 * @returns A representacao textual de algum tutor do sistema.
	 */
	public String recuperaTutor(String matricula) {
		try {
			return this.controladorTutor.recuperaTutor(matricula);
		}
		
		catch (IllegalArgumentException e1) {
			throw new IllegalArgumentException("Erro na busca por tutor: " + e1.getMessage());
		}
		
		catch (NullPointerException e2) {
			throw new NullPointerException("Erro na busca por tutor: " + e2.getMessage());
		}
	}
	
	/**
	 * Resgata e retorna uma mensagem montada pela representacao textual de todos os tutores cadas-
	 * trados no Sistema.
	 * 
	 * @returns A representacao textual de todos os tutores do sistema.
	 */
	public String listarTutores() {
		return this.controladorTutor.listarTutores();
	}
	
	/**
	 * Não retorna nada, apenas cadastra um horario do Tutor a partir do controller de Tutor utili-
	 * zando-se do email do Tutor, da hora e do dia que formarao o horario passados como parametro.
	 * 
	 * @param email O email do Tutor
	 * @param hora A hora de atendimento
	 * @param dia O dia de atendimento
	 * 
	 * @returns null.
	 */
	public void cadastrarHorario(String email, String hora, String dia) {
		try {
			this.controladorTutor.cadastrarHorario(email, hora, dia);
		}
		
		catch (IllegalArgumentException e1) {
			throw new IllegalArgumentException("Erro no cadastrar horario: " + e1.getMessage());
		}
		
		catch (NullPointerException e2) {
			throw new NullPointerException("Erro no cadastrar horario: " + e2.getMessage());
		}
	}
	
	/**
	 * Não retorna nada, apenas cadastra um local do Tutor a partir do controller de Tutor utili-
	 * zando-se do email do Tutor e do local de atendimento passados como parametro.
	 * 
	 * @param email O email do Tutor
	 * @param local O local de atendimento
	 * 
	 * @returns null.
	 */
	public void cadastrarLocalDeAtendimento(String email, String local) {
		try {
			this.controladorTutor.cadastrarLocalDeAtendimento(email, local);
		}
		
		catch (IllegalArgumentException e1) {
			throw new IllegalArgumentException("Erro no cadastrar local de atendimento: " + e1.getMessage());
		}
		
		catch (NullPointerException e2) {
			throw new NullPointerException("Erro no cadastrar local de atendimento: " + e2.getMessage());
		}
	}
	
	/**
	 * Consulta os horarios de um Tutor a partir do controller de Tutor utilizando-se do email do
	 * Tutor, da hora e do dia que formarao o horario passados como parametro. Caso o horario consul-
	 * tado esteja no conjunto de horarios do Tutor, o valor booleano true e retornado, do contrario
	 * o valor false e retornado.
	 * 
	 * @param email O email do Tutor
	 * @param hora A hora de atendimento consultada
	 * @param dia O dia de atendimento consultado
	 * 
	 * @returns Um valor booleano indicando se o horario consultado esta ou nao cadastrado.
	 */
	public boolean consultaHorario(String email, String hora, String dia) {
		return this.controladorTutor.consultaHorario(email, hora, dia);
	}
	
	/**
	 * Consulta os locais de um Tutor a partir do controller de Tutor utilizando-se do email do Tutor
	 * e do local de atendimento consultado passados como parametro. Caso o local de atendimento con-
	 * sultado esteja no conjunto de locais do Tutor, o valor booleano true e retornado, do contrario
	 * o valor false e retornado.
	 * 
	 * @param email O email do Tutor
	 * @param local O local de atendimento consultado
	 * 
	 * @returns Um valor booleano indicando se o local consultado esta ou nao cadastrado.
	 */
	public boolean consultaLocal(String email, String local) {
		return this.controladorTutor.consultaLocal(email, local);
	}
	
	
	private String selecionarTutor(String disciplina) {
		Validador.validarStringNaoVaziaNaoNula("disciplina nao pode ser vazio ou em branco", disciplina);
		return this.controladorTutor.selecionarTutor(disciplina);
	}
	
	/**
	 * Solicita umaAjudaOnline a partir da matricula do Aluno que deseja ser ajudado e da disciplina
	 * na qual quer ajuda passadas como parametro. Além disso, seleciona o tutor ideal para ajudar o
	 * Aluno naquela disciplina e tambem verifica e trata a invalidez dos parametros.
	 * 
	 * @param matriculaAluno A matricula do Aluno
	 * @param disciplina A disciplina na qual o Aluno quer ser ajudado
	 * 
	 * @returns O id da Ajuda.
	 */
	public int pedirAjudaOnline (String matriculaAluno, String disciplina) {
		try {
			return this.controladorAjuda.pedirAjudaOnline(matriculaAluno, disciplina,
				   this.selecionarTutor(disciplina));
		}
		
		catch (IllegalArgumentException e1) {
			throw new IllegalArgumentException("Erro no pedido de ajuda online: " + e1.getMessage());
		}
		
		catch (NullPointerException e2) {
			throw new NullPointerException("Erro no pedido de ajuda online: " + e2.getMessage());
		}
	}
	
	private String selecionarTutor(String disciplina, String horario, String dia, String localInteresse) {
		Validador.validarStringNaoVaziaNaoNula("disciplina nao pode ser vazio ou em branco", disciplina);
		return this.controladorTutor.selecionarTutor(disciplina, horario, dia, localInteresse);
	}
	
	/**
	 * Solicita uma ajudaPresencial a partir da matricula do Aluno que deseja ser ajudado, da disci-
	 * plina na qual quer ajuda, do horario, do dia e do local de interesse que sera programado para
	 * a ajuda passados como parametro. Além disso, seleciona o tutor ideal para ajudar o
	 * Aluno naquela disciplina e tambem verifica e trata a invalidez dos parametros.
	 * 
	 * @param matriculaAluno A matricula do Aluno
	 * @param disciplina A disciplina na qual o Aluno quer ser ajudado
	 * @param horario O horario de atendimento
	 * @param dia O dia de atendimento
	 * @param localInteresse O local de atendimento
	 * 
	 * @returns O id da Ajuda.
	 */
	public int pedirAjudaPresencial (String matriculaAluno, String disciplina, String horario, String dia, String localInteresse) {
		try {
			return this.controladorAjuda.pedirAjudaPresencial(matriculaAluno, disciplina, horario, dia,
				   localInteresse, this.selecionarTutor(disciplina, horario, dia, localInteresse));
		}
		
		catch (IllegalArgumentException e1) {
			throw new IllegalArgumentException("Erro no pedido de ajuda presencial: " + e1.getMessage());
		}
		
		catch (NullPointerException e2) {
			throw new NullPointerException("Erro no pedido de ajuda presencial: " + e2.getMessage());
		}
	}
	
	/**
	 * Resgata e retorna, a partir do id passado como parametro, a representacao textual de uma Ajuda
	 * do controller de Ajuda. Alem disso, caso a ajuda nao esteja cadastrada no sistema
	 * uma excecao e lancada para o caso.
	 * 
	 * @param idAjuda O id de identificacao da Ajuda
	 * 
	 * @returns A representacao textual da Ajuda.
	 */
	public String pegarTutor(int idAjuda) {
		try {
			return this.controladorAjuda.pegarTutor(idAjuda);
		}
		
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro ao tentar recuperar tutor : " + e.getMessage());
		}
	}
	
	/**
	 * Resgata e retorna, a partir do id e do atributo da Ajuda passado como parametro, um atributo
	 * de uma ajuda do controller de Ajuda. Alem disso, caso a ajuda nao esteja cadastrada no sistema
	 * uma excecao e lancada para o caso.
	 * 
	 * @param idAjuda O id de identificacao da Ajuda
	 * @param atributo Um atributo de Ajuda
	 * 
	 * @returns O valor de algum atributo de Ajuda
	 */
	public String getInfo(int idAjuda, String atributo) {
		try {
			return this.controladorAjuda.getInfoAjuda(idAjuda, atributo);
		}
		
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro ao tentar recuperar info da ajuda : " + e.getMessage());
		}
	}
	
	/**
	 * Avalia um tutor a partir do id da Ajuda da qual o mesmo faz parte e a partir de um valor double
	 * correspondente a nota a ser atribuida a ajuda deste tutor. Alem disso, verifica e lanca uma ex-
	 * cecao caso a nota passada como parametro seja invalida (menor que 0 ou maior que 5).
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
		 
		 catch (IllegalArgumentException e) {
				throw new IllegalArgumentException("Erro na avaliacao de tutor: " + e.getMessage());
		} 
	}
	
	/**
	 * Resgata e retorna, a partir da matricula do Tutor, a sua nota atual. Alem disso, verifica e
	 * lanca uma excecao caso o tutor nao esteja cadastrado no sistema.
	 * 
	 * 
	 * @param matriculaTutor A matricula do Tutor
	 * 
	 * @returns Uma representacao em String da nota do Tutor
	 */ 
	public String pegarNota(String matriculaTutor) {
		try {
			return this.controladorTutor.pegarNotaString(matriculaTutor);
		}
		
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro ao tentar pegar nota de tutor : " + e.getMessage());
		}
	}
	
	/**
	 * Resgata e retorna, a partir da matricula do Tutor, o seu nivel atual. Alem disso, verifica e
	 * lanca uma excecao caso o tutor nao esteja cadastrado no sistema.
	 * 
	 * @param matriculaTutor A matricula do Tutor
	 * 
	 * @returns Uma representacao em String do nivel do Tutor
	 */ 
	public String pegarNivel(String matriculaTutor) {
		try {
			return this.controladorTutor.pegarNivel(matriculaTutor);
		}
		
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro ao tentar pegar nivel de tutor : " + e.getMessage());
		}
	}
	
	public int totalDinheiroSistema() {
		return this.caixa;
	}
	
	/**
	 * Nao doa nada, apenas calcula o valor a ser destinado ao caixa do sistema e o valor a ser des-
	 * tinado ao Tutor a partir do seu nivel.
	 * 
	 * @param matriculaTutor A matricula do Tutor
	 * @param totalCentavos A quantia a ser doada
	 * 
	 * @returns null.
	 */
	public void doar(String matriculaTutor, int totalCentavos) {
		try {
			
			this.caixa += this.controladorTutor.doar(matriculaTutor, totalCentavos, this.caixa);
			
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro na doacao para tutor: " + e.getMessage());
		}
	}
	
	/**
	 * Resgata e retorna, a partir do email do tutor, a quantidade total de dinheiro que ja foi doado
	 * ao tutor.
	 * 
	 * @param emailTutor O email do Tutor
	 * 
	 * @returns A quantidade total que ja foi doada a um tutor do sistema
	 */
	public int totalDinheiroTutor(String emailTutor) {
		try {
			Validador.validarStringNaoVaziaNaoNula("emailTutor nao pode ser vazio ou nulo", emailTutor);
			
			return this.controladorTutor.getTotalDinheiro(emailTutor);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro na consulta de total de dinheiro do tutor: " + e.getMessage());
		}
	}

}
