package controllers;

import java.util.List;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.HashMap;

import models.Academico;
import models.Candidato;
import models.Ordenacao;
import models.Tutor;
import utility.Validador;
/**
 * Representacao do Controlador dos Tutores cadastrados no Sistema do Quem Me Ajuda. Como atributos,
 * o TutorController possui um Map contendo os Tutores cadastrados (mapeados a partir de suas respec-
 * tivas matriculas) e um Comparator que define a atual ordenacao desses Tutores.
 * 
 * Laboratorio de Programacao 2 - Projeto de Laboratorio - Quem Me Ajuda
 * 
 * @author Mateus de Lima Oliveira  - 117110219
 * @author Matheus Alves dos Santos - 117110503
 * @author Misael Augusto Silva da Costa - 117110525
 *
 */
public class TutorController {
	
	private Map<String, Tutor> tutores;
	private Comparator<Academico> ordenadorTutores;
	
	/**
	 * Constroi o TutorController. O Map de Tutores sera inicialmente vazio, enquanto a ordenacao
	 * dos Tutores sera inicialmente feita a partir de seus respectivos nomes.
	 * 
	 */
	public TutorController() {
		this.tutores = new HashMap<String, Tutor>();
		this.ordenadorTutores = new AcademicoPorNome();
	}
	
	/**
	 * Retorna a quantidade de Tutores atualmente mapeados pelo TutorController. 
	 * 
	 * @returns A quantidade atual de Tutores cadastrados..
	 * 
	 */
	public int getTotalTutores() {
		return this.tutores.size();
	}
		
	/**
	 * Caso ainda nao haja cadastro de um Tutor com a matricula informada, esse metodo criara um novo
	 * Tutor com os atributos passados como parametros e o mapeara a partir de sua matricula.
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
	public void criarNovoTutor(String matricula, String nome, String codigoCurso, String telefone, String email) {
		if (!this.tutores.containsKey(matricula)) {
			this.tutores.put(matricula, new Tutor(nome, matricula, Integer.parseInt(codigoCurso), telefone,
							 email, this.tutores.size() + 1));
		}
	}
	
	/**
	 * Verifica se existe cadastro de um Tutor cuja matricula e a informada atraves do primeiro pa-
	 * rametro desse metodo. Caso nao haja cadastro desse Tutor, uma excecao adequada sera lancada
	 * com a mensagem tambem informada como parametro.
	 * 
	 * @param matricula A matricula do Tutor a ser verificado.
	 * @param msg A mensagem a ser associada a excecao possivelmente lancada.
	 * 
	 * @returns null.
	 * 
	 */
	public void impedirTutorNaoCadastrado(String matricula, String msg) {
		if (!this.tutores.containsKey(matricula)) {
			throw new IllegalArgumentException(msg);
		}
	}
	
	/**
	 * Adiciona uma Habilidade a um dos Tutores cadastrados. Caso se tente adicionar uma Habilidade
	 * a um Tutor nao cadastrado, uma excecao adequada sera lancada.
	 * 
	 * @param matricula A matricula do Tutor a ser modificado.
	 * @param disciplina O nome da disciplina em que o Tutor possui Habilidade.
	 * @param proficiencia O nivel de proficiencia do Tutor na disciplina.
	 * 
	 * @returns null.
	 * 
	 */
	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		this.impedirTutorNaoCadastrado(matricula, "Tutor nao encontrado");
		this.tutores.get(matricula).adicionarHabilidade(disciplina, proficiencia);
	}
	
	/**
	 * Retorna a representacao textual de um dos Tutores cadastrados. O Tutor a ser recuperado sera
	 * aquele cuja matricula for informada como parametro do metodo. Caso a matricula informada nao
	 * pertenca a nenhum dos Tutores cadastrados, a excecao adequada sera lancada.
	 * 
	 * @param matricula A matricula do Tutor a ser acessado.
	 * 
	 * @returns A representacao textual do Tutor de interesse.
	 * 
	 */
	public String recuperaTutor(String matricula) {
		this.impedirTutorNaoCadastrado(matricula, "Tutor nao encontrado");
		return this.tutores.get(matricula).toString();
	}
	
	/**
	 * A partir do atributo ordenadorTutores de TutorController, esse metodo retornara a lista dos
	 * Tutores cadastrados organizando-os de acordo com a ordem atualmente configurada.
	 * 
	 * @returns A List ordenada dos Tutores cadastrados.
	 * 
	 */
	private List<Tutor> ordenarTutores() {
		List<Tutor> listaDeTutores = new ArrayList<Tutor>();
		listaDeTutores.addAll(this.tutores.values());
		listaDeTutores.sort(this.ordenadorTutores);
			
		return listaDeTutores;
	}
	
	/**
	 * Retorna a listagem dos Tutores atualmente cadastrados. Cada Tutor sera representado por seu
	 * respectivo toString(). A listagem sera feita em linha unica (separando os Tutores por virgu-
	 * la).
	 * 
	 * @returns A listagem dos Tutores cadastrados.
	 * 
	 */
	public String listarTutores() {
		String listagemTutores = "";
		
		for (int i = 0; i < this.ordenarTutores().size() - 1; i++) {
			listagemTutores += ordenarTutores().get(i).toString() + ", ";
		}
		
		listagemTutores += ordenarTutores().get(ordenarTutores().size() - 1).toString();		
		return listagemTutores;
	}
	
	/**
	 * Verifica se o e-mail informado como parametro do metodo pertence a algum dos Tutores cadas-
	 * trados. Em caso de correspondencia, retorna-se a matricula do Tutor que possui esse e-mail,
	 * caso contrario, retorna-se uma String vazia.
	 * 
	 * @param email O e-mail de interesse na consulta.
	 * 
	 * @returns A matricula do Tutor que possui o e-mail informado.
	 * 
	 */
	private String getMatriculaPorEmail(String email) {
		for(Tutor tutor : this.ordenarTutores()) {
			if(tutor.getEmail().equals(email)) {
				return tutor.getMatricula();
			}
		}
		
		return "";
	}
	
	/**
	 * Adiciona um Horario para atendimento na Disponibilidade de um dos Tutores cadastrados. Caso
	 * se tente adicionar o Horario na Disponibilidade de um Tutor nao cadastrado, uma excecao ade-
	 * quada sera lancada. O mesmo ocorre caso o e-mail informado seja vazio ou nulo.
	 * 
	 * @param email O e-mail do Tutor a ser modificado.
	 * @param hora A hora a ser associada no Horario para atendimento.
	 * @param dia O dia da semana a ser associado no Horario para atendimento.
	 * 
	 * @returns null.
	 * 
	 */
	public void cadastrarHorario(String email, String hora, String dia) {
		Validador.validarStringNaoVaziaNaoNula("email nao pode ser vazio ou em branco", email);
		impedirTutorNaoCadastrado(this.getMatriculaPorEmail(email), "tutor nao cadastrado");	
			
		this.tutores.get(this.getMatriculaPorEmail(email)).cadastrarHorario(hora, dia);
	}
	
	/**
	 * Adiciona um Local para atendimento na Disponibilidade de um dos Tutores cadastrados. Caso se
	 * tente adicionar o Local na Disponibilidade de um Tutor nao cadastrado, uma excecao adequada
	 * sera lancada. O mesmo ocorre caso o e-mail informado seja vazio ou nulo.
	 * 
	 * @param email O e-mail do Tutor a ser modificado.
	 * @param local O nome do Local para atendimento a ser cadastrado.
	 * 
	 * @returns null.
	 * 
	 */
	public void cadastrarLocalDeAtendimento(String email, String local) {
		Validador.validarStringNaoVaziaNaoNula("email nao pode ser vazio ou em branco", email);
		impedirTutorNaoCadastrado(this.getMatriculaPorEmail(email), "tutor nao cadastrado");
		
		this.tutores.get(this.getMatriculaPorEmail(email)).cadastrarLocalDeAtendimento(local);
	}
	
	/**
	 * Verifica se um Tutor possui um Horario especifico cadastrado em sua Disponibilidade. Caso o 
	 * e-mail informado nao pertenca a nenhum dos Tutores castrados, ocorre tratamento de excecao e
	 * se retornara false.
	 * 
	 * @param email O e-mail do Tutor a ser analisado.
	 * @param hora A hora de interesse para a verificacao.
	 * @param dia O dia de interesse para a verificacao.
	 * 
	 * @returns O boolean referente a disponibilidade do Horario de interesse.
	 * 
	 */
	public boolean consultaHorario(String email, String hora, String dia) {
		try {
			Validador.validarStringNaoVaziaNaoNula("email nao pode ser vazio ou em branco", email);
			impedirTutorNaoCadastrado(this.getMatriculaPorEmail(email), "tutor nao cadastrado");
			
			return this.tutores.get(this.getMatriculaPorEmail(email)).consultaHorario(hora, dia);
		}
		
		catch (IllegalArgumentException e) {
			return false;
		}
	}
	
	/**
	 * Verifica se um Tutor possui um Local especifico cadastrado em sua Disponibilidade. Caso o 
	 * e-mail informado nao pertenca a nenhum dos Tutores castrados, ocorre tratamento de excecao
	 * e se retornara false.
	 * 
	 * @param email O e-mail do Tutor a ser analisado.
	 * @param local O nome do Localde interesse para a verificacao.
	 * 
	 * @returns O boolean referente a disponibilidade do Local de interesse.
	 * 
	 */
	public boolean consultaLocal(String email, String local) {
		try {
			Validador.validarStringNaoVaziaNaoNula("email nao pode ser vazio ou em branco", email);
			impedirTutorNaoCadastrado(this.getMatriculaPorEmail(email), "tutor nao cadastrado");
			
			return this.tutores.get(this.getMatriculaPorEmail(email)).consultaLocal(local);
		}
		
		catch (IllegalArgumentException e) {
			return false;
		}
	}
	
	/**
	 * A partir de uma disciplina de interesse, verifica os Tutores que sao capazes de prestar aten-
	 * dimento nela e os "torna" Candidatos a atender uma determinada solicitacao de Ajuda Online. Os
	 * Candidatos serao colocados numa List a ser retornada.
	 * 
	 * @param disciplina O nome da disciplina de interesse na listagem.
	 * 
	 * @returns A List dos Candidatos capazes de atender a AjudaOnline.
	 * 
	 */
	private List<Candidato> listarCandidatos(String disciplina) {
		List<Candidato> candidatos = new ArrayList<Candidato>();
		for (Tutor tutor : this.ordenarTutores()) {
			if (tutor.consultaHabilidade(disciplina)) {
				candidatos.add(new Candidato(tutor.getMatricula(), tutor.getProficiencia(disciplina),
							   tutor.getNumeroCadastro()));
			}
		}
		
		return candidatos;
	}
	
	/**
	 * A partir da List de Candidatos capazes de atender online em uma determinada disciplina, retor-
	 * na matricula do mais apto a prestar tal atendimento. Caso nao existam candidatos, esse metodo
	 * devera retornar uma String vazia.
	 * 
	 * @param disciplina O nome da disciplina de interesse na selecao.
	 * 
	 * @returns A matricula do Candidato selecionado para prestar o atendimento.
	 * 
	 */
	public String selecionarCandidato(String disciplina) {
		List<Candidato> candidatos = this.listarCandidatos(disciplina);
		candidatos.sort(new CandidatoPorProficiencia());
		
		return candidatos.isEmpty() ? "" : candidatos.get(0).getMatricula();
	}
	
	/**
	 * A partir de uma disciplina de interesse, bem como de um Horario e de um Local para atendimen-
	 * to, verifica os Tutores que sao capazes de prestar atendimento nela e os "torna" Candidatos a
	 * atender uma determinada solicitacao de Ajuda Presencial. Os Candidatos serao colocados numa
	 * List a ser retornada.
	 * 
	 * @param disciplina O nome da disciplina de interesse na listagem.
	 * @param hora A hora de interesse para atendimento.
	 * @param dia O dia de interesse na listagem para atendimento.
	 * @param local O nome do local de interesse para atendimento.
	 * 
	 * @returns A List dos Candidatos capazes de atender a AjudaPresencial.
	 * 
	 */
	private List<Candidato> listarCandidatos(String disciplina, String hora, String dia, String local) {
		List<Candidato> candidatos = this.listarCandidatos(disciplina);
		for (Tutor tutor : this.ordenarTutores()) {
			if (tutor.consultaHabilidade(disciplina) && tutor.consultaDisponibilidade(hora, dia, local)) {
				candidatos.add(new Candidato(tutor.getMatricula(), tutor.getProficiencia(disciplina),
							   tutor.getNumeroCadastro()));
			}
		}
		
		return candidatos;
	}
	
	/**
	 * A partir da List de Candidatos capazes de atender presencialmente em uma determinada disci-
	 * plina, retorna matricula do mais apto a prestar tal atendimento. Caso nao existam candida-
	 * tos, esse metodo devera retornar uma String vazia.
	 * 
	 * @param disciplina O nome da disciplina de interesse na selecao.
	 * @param hora A hora de interesse para atendimento.
	 * @param dia O dia de interesse na listagem para atendimento.
	 * @param local O nome do local de interesse para atendimento.
	 * 
	 * @returns A matricula do Candidato selecionado para prestar o atendimento.
	 * 
	 */
	public String selecionarCandidato(String disciplina, String hora, String dia, String local) {
		List<Candidato> candidatos = this.listarCandidatos(disciplina, hora, dia, local);
		candidatos.sort(new CandidatoPorProficiencia());
		
		return candidatos.isEmpty() ? "" : candidatos.get(0).getMatricula();
	}

	/**
	 * Retorna a nota de avaliacao de um dos Tutores cadastrados. O Tutor a ter sua nota recuperada
	 * sera aquele cuja matricula for informada como parametro do metodo. Caso a matricula informa-
	 * da nao pertenca a nenhum dos Tutores cadastrados, a excecao adequada sera lancada.
	 * 
	 * @param matricula A matricula do Tutor a ser acessado.
	 * 
	 * @returns A nota de avaliacao do Tutor de interesse.
	 * 
	 */
	public String pegarNota(String matricula) {
		this.impedirTutorNaoCadastrado(matricula, "Tutor nao encontrado");
		
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(tutores.get(matricula).getNota());
	}

	/**
	 * Retorna o nivel de avaliacao de um dos Tutores cadastrados. O Tutor a ter seu nivel recupe-
	 * rado sera aquele cuja matricula for informada como parametro do metodo. Caso a matricula in-
	 * formada nao pertenca a nenhum dos Tutores cadastrados, a excecao adequada sera lancada.
	 * 
	 * @param matricula A matricula do Tutor a ser acessado.
	 * 
	 * @returns O nivel de avaliacao do Tutor de interesse.
	 * 
	 */
	public String pegarNivel(String matricula) {
		this.impedirTutorNaoCadastrado(matricula, "Tutor nao encontrado");
		return tutores.get(matricula).getNivel();
	}
	
	/**
	 * Adiciona uma nova avaliacao a um dos Tutores cadastrados. O Tutor a ser avaliado sera aquele
	 * cuja matricula for informada como parametro do metodo. Caso a matricula informada nao perten-
	 * ca a nenhum dos Tutores cadastrados, a excecao adequada sera lancada.
	 * 
	 * @param matricula A matricula do Tutor a ser avaliado.
	 * @param nota A nota atribuida ao Tutor avaliado.
	 * 
	 * @returns null.
	 * 
	 */
	public void adicionarAvaliacao(String matricula, int nota) {
		this.tutores.get(matricula).adicionarAvaliacao(nota);
	}
	
	/**
	 * A partir de uma certa quantia doada (em centavos) e da nota de avaliacao de um Tutor, calcula
	 * a percentagem do total a que o Tutor tem direito.
	 * 
	 * @param totalCentavos A quantia doada (em centavos).
	 * @param notaTutor A nota de avaliacao do Tutor.
	 * 
	 * @returns A percentagem da doacao a que o Tutor tera direito.
	 * 
	 */
	private double calcularTaxaTutor(int totalCentavos, double notaTutor) {
		if (notaTutor > 4.5) {	return (0.9 + ((notaTutor - 4.5) * 0.1)); }
		
		if (notaTutor > 3.0) { return (0.8); }
		
		return (0.4 - ((3.0 - notaTutor) * 0.1));
	}
	
	/**
	 * A partir de uma certa quantia doada (em centavos) e da nota de avaliacao de um Tutor, calcula
	 * a quantia a que o Quem Me Ajuda tera direito como comissao.
	 * 
	 * @param totalCentavos A quantia doada (em centavos).
	 * @param notaTutor A nota de avaliacao do Tutor.
	 * 
	 * @returns A quantia que o Quem Me Ajuda ira reter como comissao.
	 * 
	 */
	public int calcularComissao(String matriculaTutor, int totalCentavos) {
		this.impedirTutorNaoCadastrado(matriculaTutor, "Tutor nao encontrado");
		Validador.validarIntNaoNegativo("totalCentavos nao pode ser menor que zero", totalCentavos);
		
		double notaTutor = this.tutores.get(matriculaTutor).getNota();
		
		return (int) Math.ceil((1 - this.calcularTaxaTutor(totalCentavos, notaTutor)) * totalCentavos);
	}
	
	/**
	 * Calcula a quantia (em centavos) de uma doacao a que o Tutor que a recebeu tera direito. Natu-
	 * ralmente, esse calculo envolve retirar a comissao do Quem Me Ajuda do total doado.
	 * 
	 * @param matriculaTutor A matricula do Tutor que recebeu a doacao.
	 * @param totalCentavos A quantia total doada (em centavos).
	 * 
	 * @returns A quantia recebida pelo Tutor.
	 * 
	 */
	private int calcularTotalTutor(String matriculaTutor, int totalCentavos) {
		return totalCentavos - this.calcularComissao(matriculaTutor, totalCentavos);
	}
	
	/**
	 * Realiza a doacao de uma certa quantia (em centavos) para um  dos Tutores cadastrados. Caso se
	 * tente realizar a doacao a um Tutor nao cadastrado ou se tente doar uma quantia invalidade, as
	 * excecoes adequadas serao lancadas.
	 * 
	 * @param matriculaTutor A matricula do Tutor que recebera a doacao.
	 * @param totalCentavos A quantia total a ser doada (em centavos).
	 * 
	 * @returns null.
	 * 
	 */
	public void adicionarDoacao(String matriculaTutor, int totalCentavos) {
		this.impedirTutorNaoCadastrado(matriculaTutor, "Tutor nao encontrado");
		Validador.validarIntNaoNegativo("totalCentavos nao pode ser menor que zero", totalCentavos);
		
		int totalTutor = this.calcularTotalTutor(matriculaTutor, totalCentavos);
		
		this.tutores.get(matriculaTutor).adicionarDoacao(totalTutor);
	}
	
	/**
	 * Retorna o total de dinheiro (em centavos) recebido por um Tutor cadastrado. O Tutor a ter sua
	 * quantia ganha recuperada sera aquele cujo e-mail for informado como parametro do metodo. Caso
	 * o e-mail informado nao pertenca a nenhum dos Tutores cadastrados, a excecao adequada sera lan-
	 * cada.
	 * 
	 * @param matricula A matricula do Tutor a ser acessado.
	 * 
	 * @returns A quantia ja recebida pelo Tutor de interesse.
	 * 
	 */
	public int getTotalDinheiroTutor(String emailTutor) {
		this.impedirTutorNaoCadastrado(this.getMatriculaPorEmail(emailTutor), "Tutor nao encontrado");
		return this.tutores.get(getMatriculaPorEmail(emailTutor)).getDinheiroRecebido();
	}
	
	/**
	 * Modifica a ordenacao utilizada em listarTutores() para gerar uma listagem dos Tutores cadas-
	 * trados.
	 * 
	 * @param atributo O nome do atributo a ser utilizado para a ordenacao.
	 * 
	 * @returns null.
	 * 
	 */
	public void configurarOrdem(String atributo) {
		this.ordenadorTutores = Ordenacao.valueOf(atributo.toUpperCase()).definirOrdenacao();
	}
	
}
