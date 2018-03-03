package models;

import java.util.HashSet;
import java.util.Set;

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
public class Tutor extends Academico {
	
	private double nota;
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
	public Tutor(String nome, String matricula, int codigoCurso, String telefone, String email) {
		super(nome, telefone, email, matricula, codigoCurso);
			
		this.dinheiroRecebido = 0;
		this.habilidades = new HashSet<Habilidade>();
		this.disponibilidade = new Disponibilidade();
		
		this.setNota(4.0);
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
	 * Impede o cadastro de uma Habilidade repetida no Tutor atraves do lancamento de excecao.
	 * 
	 * @param disciplina O nome da disciplina a ser cadastrada.
	 * @param proficiencia O nivel de proficiencia na disciplina a ser cadastrada. 
	 * 
	 * @returns null
	 * 
	 */
	private void impedirHabilidadeRepetida(String disciplina, int proficiencia) {
		if (this.habilidades.contains(new Habilidade(disciplina, proficiencia))) {
			throw new IllegalArgumentException("Ja eh tutor dessa disciplina");
		}
	}
	
	/**
	 * Adiciona uma nova Habilidade ao conjunto de Habilidades possuidas pelo Tutor.
	 * 
	 * @param disciplina A nome da disciplina a ser cadastrada.
	 * @param proficiencia O nivel de proficiencia na disciplina a ser cadastrada. 
	 *  
	 * @returns null
	 * 
	 */
	public void adicionarHabilidade(String disciplina, int proficiencia) {
		this.impedirHabilidadeRepetida(disciplina, proficiencia);
		this.habilidades.add(new Habilidade(disciplina, proficiencia));
	}


	/**
	 * Adiciona um novo Horario na Disponibilidade do Tutor.
	 * 
	 * @param hora A hora disponivel para atendimento do Tutor.
	 * @param dia O dia da semana em que a hora esta disponivel. 
	 * 
	 * @returns null
	 * 
	 */
	public void cadastrarHorario(String hora, String dia) {
		this.disponibilidade.adicionarHorario(hora, dia);
	}
	
	/**
	 * Adiciona um novo Local na Disponibilidade do Tutor.
	 * 
	 * @param local O nome do local disponivel para atendimento do Tutor. 
	 * 
	 * @returns null
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
	
	public boolean tutorContainsHabilidades(String disciplina){
		for(Habilidade tutoria : this.habilidades) {
			if(tutoria.getDisciplina().equals(disciplina)) {
				return true;
			}
		}
		return false;
	}

	public Disponibilidade getDisponibilidade() {
		return disponibilidade;
	}

	public Set<Habilidade> getHabilidades() {
		return habilidades;
	}
	
}
