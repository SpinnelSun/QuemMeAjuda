package models;

import utility.Validador;

public class AjudaPresencial extends Ajuda {

	private Horario horario;
	private Local local;
	
	public AjudaPresencial(String matriculaAluno, String disciplina, String hora, String dia, String local,
						   String matriculaTutor) {
		
		super(matriculaAluno, disciplina, matriculaTutor);
		
		Validador.validarStringNaoVaziaNaoNula("horario nao pode ser vazio ou em branco", hora);
		Validador.validarStringNaoVaziaNaoNula("dia nao pode ser vazio ou em branco", dia);
		Validador.validarStringNaoVaziaNaoNula("local de interesse nao pode ser vazio ou em branco", local);
		
		this.horario = new Horario(hora, dia);
		this.local = new Local(local);	
	}

	public String getHora() {
		return this.horario.getHora();
	}

	public String getDia() {
		return this.horario.getDia();
	}

	public String getLocal() {
		return this.local.getNome();
	}
	
	@Override
	public String getInfo(String atributo) {
		Validador.validarStringNaoVaziaNaoNula("atributo nao pode ser vazio ou em branco", atributo);
		InfoAjudaPresencial.impedirAtributoInexistente(atributo.toUpperCase());
		
		return InfoAjudaPresencial.valueOf(atributo.toUpperCase()).getInfo(this);
	}

	@Override
	public String toString() {
		return "Tutor - " + this.getMatriculaTutor() + ", horario - " + this.getHora() + ", dia - " +
				this.getDia() + ", local - " + this.getLocal() + ", disciplina - " + this.getDisciplina();
	}
	
}