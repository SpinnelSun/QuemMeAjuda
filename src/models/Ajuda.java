package models;

import utility.Validador;

public abstract class Ajuda {
	
	private String disciplina;
	private String matriculaAluno;
	private String matriculaTutor;
	private boolean avaliacaoConcluida;
	
	public Ajuda(String matriculaAluno, String disciplina, String matriculaTutor) {
		Validador.validarStringNaoVaziaNaoNula("matricula de aluno nao pode ser vazio ou em branco", matriculaAluno);
		Validador.validarStringNaoVaziaNaoNula("disciplina nao pode ser vazio ou em branco", disciplina);
		Validador.validarStringNaoNula("matricula de tutor nao pode ser vazio", matriculaTutor);
		
		this.disciplina = disciplina;
		this.matriculaAluno = matriculaAluno;
		this.matriculaTutor = matriculaTutor;
		this.avaliacaoConcluida = false;
	}

	public String getDisciplina() {
		return this.disciplina;
	}

	public String getMatriculaAluno() {
		return this.matriculaAluno;
	}
	
	public String getMatriculaTutor() {
		return this.matriculaTutor;
	}
	
	public boolean getAvaliacaoConcluida() {
		return this.avaliacaoConcluida;
	}
	
	public boolean setAvaliacaoConcluida() {
		return this.avaliacaoConcluida = true;
	}
	
	public String getInfo(String atributo) {
		Validador.validarStringNaoVaziaNaoNula("atributo nao pode ser vazio ou em branco", atributo);
		InfoAjuda.impedirAtributoInexistente(atributo.toUpperCase());
		
		return InfoAjuda.valueOf(atributo.toUpperCase()).getInfo(this);
	}
	
	private void impedirReavaliacao() {
		if (this.avaliacaoConcluida) { throw new IllegalArgumentException("Ajuda ja avaliada"); }
	}
	
	public void registrarAvaliacao() {
		this.impedirReavaliacao();
		this.avaliacaoConcluida = true;
	}
	
}
