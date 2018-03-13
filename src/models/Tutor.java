package models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import general.Validador;

/**
 * Representacao de um Tutor no sistema do Quem Me Ajuda. Como atributos, cada Tutor possui o nome,
 * o telefone, o email e a matricula representados em Strings, a quantidade de dinheiro recebido e
 * o codigo de seu curso representados em int, sua nota de avaliacao em double, alem de sua Disponi-
 * bilidade e um conjunto de Habilidades.
 * 
 * Laboratorio de Programacao 2 - Projeto de Laboratorio - Quem Me Ajuda
 * 
 * @author Mateus de Lima Oliveira  - 117110219
 * @author Matheus Alves dos Santos - 117110503
 * @author Misael Augusto Silva da Costa - 117110525
 *
 */
public class Tutor extends Academico implements Serializable {
	
	private double nota;
	private int numeroCadastro;
	private int dinheiroRecebido;
	private Set<Habilidade> habilidades;
	private Disponibilidade disponibilidade;
	
	/**
	 * Constroi um Tutor a partir de seu nome, de seu telefone, de sua matricula, do codigo de seu
	 * curso e de seu email. Nao e permitida a criacao de Tutores com atributos vazios e/ou nulos.
	 * Excetua-se o telefone, que podera ser uma String vazia (telefone nao informado). O codigo do
	 * curso nao podera ser inferior a 1. O dinheiro recebido pelo Tutor sera, inicialmente, zero.
	 * A principio, nao existem Habilidades cadastradas. A nota do Tutor sera, inicialmente, 4.0.
	 * 
	 * @param nome O nome do Tutor.
	 * @param matricula A matricula do Tutor.
	 * @param codigoCurso O codigo do curso do Tutor.
	 * @param telefone O numero do telefone do Tutor.
	 * @param email O email do tutor.
	 * 
	 */
	public Tutor(String nome, String matricula, int codigoCurso, String telefone, String email,
				 int numeroCadastro) {
		super(nome, telefone, email, matricula, codigoCurso);
			
		this.dinheiroRecebido = 0;
		this.habilidades = new HashSet<Habilidade>();
		this.disponibilidade = new Disponibilidade();
		
		this.setNota(4.0);
	}
	
	public int getNumeroCadastro() {
		return this.numeroCadastro;
	}
	
	public int getDinheiroRecebido() {
		return this.dinheiroRecebido;
	}
	
	public double getNota() {
		return this.nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}
	
	/**
	 * Verifica se o Tutor ja possui a Habilidade definida pela disciplina pela proficiencia passa-
	 * das como parametro desse metodo. Caso a Habilidade ja tenha sido cadastrada no Set de Habi-
	 * lidades do Tutor, ocorrera o lancamento de uma excecao adequada.
	 * 
	 * @param disciplina O nome da disciplina da Habilidade.
	 * @param proficiencia O nivel de proficiencia nessa disciplina. 
	 * 
	 * @returns null.
	 * 
	 */
	private void impedirHabilidadeRepetida(String disciplina, int proficiencia) {
		if (this.habilidades.contains(new Habilidade(disciplina, proficiencia))) {
			throw new IllegalArgumentException("Ja eh tutor dessa disciplina");
		}
	}
	
	/**
	 * Adiciona uma nova Habilidade ao Set de Habilidades do Tutor executando esse metodo. A nova
	 * Habilidade cadastrada sera construida a partir da disciplina e do nivel de proficiencia pas-
	 * sados como parametro desse metodo.
	 * 
	 * @param disciplina A nome da disciplina a ser cadastrada.
	 * @param proficiencia O nivel de proficiencia na disciplina a ser cadastrada. 
	 *  
	 * @returns null.
	 * 
	 */
	public void adicionarHabilidade(String disciplina, int proficiencia) {
		this.impedirHabilidadeRepetida(disciplina, proficiencia);
		this.habilidades.add(new Habilidade(disciplina, proficiencia));
	}


	/**
	 * Cadastra um novo Horario na Dispoibilidade do Tutor. O Horario a ser cadastrado na Disponibi-
	 * lidade do Tutor executando esse metodo sera construido a partir da hora e do dia passados co-
	 * mo parametros.
	 * 
	 * @param hora A hora disponivel para atendimento.
	 * @param dia O dia disponivel para atendimento.
	 * 
	 * @returns null.
	 * 
	 */
	public void cadastrarHorario(String hora, String dia) {
		this.disponibilidade.adicionarHorario(hora, dia);
	}
	
	/**
	 * Cadastra um novo Local na Dispoibilidade do Tutor. O Local a ser cadastrado na Disponibilida-
	 * de do Tutor executando esse metodo sera construido a partir do nome do Local passado como pa-
	 * rametro.
	 * 
	 * @param local O nome do Local disponivel para atendimento.
	 * 
	 * @returns null.
	 * 
	 */
	public void cadastrarLocalDeAtendimento(String local) {
		this.disponibilidade.adicionarLocal(local);
	}
	
	/**
	 * Verifica se o Tutor esta disponivel em um determinado Horario da semana. O metodo retornara
	 * o boolean referente a existencia da disponibilidade no Horario verificado.
	 * 
	 * @param hora A hora cuja disponibilidade sera verificada.
	 * @param dia O dia da semana cuja disponibilidade sera verificada. 
	 * 
	 * @returns O boolean referente a disponibilidade do Horario.
	 * 
	 */
	public boolean consultaHorario(String horario, String dia) {
		return this.disponibilidade.verificarHorarioCadastrado(horario, dia);
	}
	
	/**
	 * Verifica se o Tutor esta disponivel para atender em um determinado Local. O metodo retornara
	 * o boolean referente a existencia da disponibilidade para o Local verificado.
	 * 
	 * @param local O nome do local cuja disponibilidade sera verificada. 
	 * 
	 * @returns O boolean referente a disponibilidade do Local.
	 * 
	 */
	public boolean consultaLocal(String local) {
		return this.disponibilidade.verificarLocalCadastrado(local);
	}
	
	/**
	 * Verifica se o Tutor esta disponivel para atender em um determinado Local durante um Horario
	 * especifico. O metodo retornara o boolean referente a existencia da disponibilidade para o Lo-
	 * cal e Horario verificados.
	 * 
	 * @param hora A hora cuja disponibilidade sera verificada.
	 * @param dia O dia da semana cuja disponibilidade sera verificada.
	 * @param local O nome do local cuja disponibilidade sera verificada. 
	 * 
	 * @returns O boolean referente a disponibilidade do Local e do Horario.
	 * 
	 */
	public boolean consultaDisponibilidade(String hora, String dia, String local){
		return this.consultaHorario(hora, dia) && this.consultaLocal(local);
	}
	
	/**
	 * Verifica se o Tutor possui Habilidade em uma certa disciplina de interesse. O metodo retorna-
	 * ra o boolean referente a existencia da Habilidade do Tutor nessa disciplina.
	 * 
	 * @param disciplina O nome da disciplina de interesse para a verificacao.
	 * 
	 * @returns O boolean referente a disponibilidade do Local e do Horario.
	 * 
	 */
	public boolean consultaHabilidade(String disciplina){
		return this.habilidades.contains(new Habilidade(disciplina, 1));
	}
	
	/**
	 * Retorna o nivel de proficiencia que o Tutor possui em uma determinada disciplina de interes-
	 * se. Se a Habilidade definida por essa disciplina nao constar no Set de Habilidades do Tutor,
	 * o metoro retornara 0.
	 * 
	 * @param disciplina O nome da disciplina de interesse para a verificacao.
	 * 
	 * @returns O nivel de proficiencia do Tutor na disciplina.
	 * 
	 */
	public int getProficiencia(String disciplina) {
		for (Habilidade habilidade : this.habilidades) {
			if (habilidade.getDisciplina().equals(disciplina)) {
				return habilidade.getProficiencia();
			}
		}
		
		return 0;
	}
	
	/**
	 * Calcula a nova media de avaliacao do Tutor executando esse metodo. O calculo ocorre a partir
	 * da nota informada em uma nova avaliacao de uma Ajuda tutorada pelo Tutor. A nota passada como
	 * parametro devera estar no intervalo [0, 5].
	 * 
	 * @param nota A nota informada na nova avaliacao da Ajuda tutorada.
	 * 
	 * @returns null.
	 * 
	 */
	public void adicionarAvaliacao(int nota) {
		Validador.validarIntNaoNegativo("nota nao pode ser menor que 0", nota);
		Validador.validarIntMenorQueCinco("nota nao pode ser maior que 5", nota);
		
		this.setNota(((this.getNota() * 5) + nota) / 6);
	}
	
	/**
	 * Retorna a representacao textual do nivel de avaliacao do Tutor. O nivel sera definido a partir
	 * da atual nota de avaliacao do Tutor que, por sua vez, varia de acordo com as avaliacoes recebi-
	 * das apos os atendimentos do Tutor. 
	 * 
	 * @returns A representacao textual do nivel do Tutor.
	 * 
	 */
	public String getNivel() {
		if (this.nota <= 3.0) { return NivelAvaliacao.BAIXO.toString(); }
		
		if (this.nota <= 4.5) { return NivelAvaliacao.MEDIO.toString(); }
		
		return NivelAvaliacao.ALTO.toString();
	}
	
	/**
	 * Registra o recebimento de uma nova doacao feita para o Tutor executando esse metodo. O para-
	 * metro desse metodo e a quantidade de centavos que o Tutor recebera.
	 * 
	 * @param dinheiro O valor (em centavos) que o Tutor recebera.
	 * 
	 * @returns null.
	 * 
	 */
	public void adicionarDoacao(int dinheiro) {
		this.dinheiroRecebido += dinheiro;
	}
	
}