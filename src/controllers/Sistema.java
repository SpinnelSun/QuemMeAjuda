package controllers;

import java.text.DecimalFormat;

import utility.Validador;

public class Sistema {
	
	private AlunoController controladorAluno;
	private TutorController controladorTutor;
	private AjudaController controladorAjuda;
	
	private int caixa;
		
	public Sistema() {
		this.controladorAluno = new AlunoController();
		this.controladorTutor = new TutorController();
		this.controladorAjuda = new AjudaController();
		
		this.caixa = 0;
	}
	
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
	
	public String recuperaAluno(String matricula) {
		try {
			return this.controladorAluno.recuperaAluno(matricula);	
		}
		
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro na busca por aluno: " + e.getMessage());
		}
	}

	public String listarAlunos() {
		return this.controladorAluno.listarAlunos();
	}
	
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
	
	public String listarTutores() {
		return this.controladorTutor.listarTutores();
	}
	
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
	
	public boolean consultaHorario(String email, String hora, String dia) {
		return this.controladorTutor.consultaHorario(email, hora, dia);
	}
	
	public boolean consultaLocal(String email, String local) {
		return this.controladorTutor.consultaLocal(email, local);
	}
	
	
	
	
	private String selecionarTutor(String disciplina) {
		Validador.validarStringNaoVaziaNaoNula("disciplina nao pode ser vazio ou em branco", disciplina);
		return this.controladorTutor.selecionarTutor(disciplina);
	}
	
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
	
	public String pegarTutor(int idAjuda) {
		try {
			return this.controladorAjuda.pegarTutor(idAjuda);
		}
		
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro ao tentar recuperar tutor : " + e.getMessage());
		}
	}
	
	public String getInfo(int idAjuda, String atributo) {
		try {
			return this.controladorAjuda.getInfoAjuda(idAjuda, atributo);
		}
		
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro ao tentar recuperar info da ajuda : " + e.getMessage());
		}
	}
	
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
	 
	public String pegarNota(String matriculaTutor) {
		try {
			return this.controladorTutor.pegarNota(matriculaTutor);
		}
		
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro ao tentar pegar nota de tutor : " + e.getMessage());
		}
	}
	
	public String pegarNivel(String matriculaTutor) {
		try {
			return this.controladorTutor.pegarNivel(matriculaTutor);
		}
		
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro ao tentar pegar nivel de tutor : " + e.getMessage());
		}
	}
	
	public int getCaixa() {
		return this.caixa;
	}

	public void doar(String matriculaTutor, int totalCentavos) {
		
		double valorTutor = 0;
		double totalSistema = 0;
		double notaTutor = this.controladorTutor.pegarNotaDouble(matriculaTutor);
		
		if(notaTutor> 4.5) {
			totalSistema += 0.1 * totalCentavos;
			valorTutor = (totalCentavos - totalSistema);
			
		}if(notaTutor <= 4.5 && notaTutor > 3) {
			totalSistema += 0.2 * totalCentavos;
			valorTutor = (totalCentavos - totalSistema);
			
		}if(notaTutor <= 3 && notaTutor > 0) {
			totalSistema += 0.6 * totalCentavos;
			valorTutor = (totalCentavos - totalSistema);
		}
		
		this.caixa += Math.ceil(totalSistema);
		this.controladorTutor.doar(matriculaTutor, (int)(valorTutor));
	}
	
	public int getTotalDinheiroTutor(String emailTutor) {
		return this.controladorTutor.getTotalDinheiro(emailTutor);
	}

}
