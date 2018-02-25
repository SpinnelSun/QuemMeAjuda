package models;

public class Tutor extends Aluno {
	
	private String disciplina;
	private int proficiencia;
	private int dinheiroRecebido;
	private Alocacao alocacao;
	
	public Tutor(String matricula, String nome, String codigoCurso, String email, String disciplina,
				 int proficiencia) {
		
		super(nome, matricula, codigoCurso, email);
			
		this.disciplina = disciplina.trim();
		this.proficiencia = proficiencia;
		this.dinheiroRecebido = 0;
		
		this.setNota(4.0);
	}
	
	public Tutor(String matricula, String nome, String codigoCurso, String telefone, String email,
				 String disciplina, int proficiencia) {
	
		this(matricula, nome, codigoCurso, email, disciplina, proficiencia);
		this.setTelefone(telefone);
	}
	
	public String getDisciplina() {
		return this.disciplina;
	}
	
	public int getProficiencia() {
		return this.proficiencia;
	}
	
	public int getDinheiroRecebido() {
		return this.dinheiroRecebido;
	}
	
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public void cadastrarHorario(String horario, String dia) {
		alocacao.setHorarioDeAtendimento(horario);
		alocacao.setDiasDeAtendimento(dia);
	}
	
	public void cadastrarLocalDeAtendimento(String local) {
		alocacao.setLocaisDeAtendimento(local);
	}
	public boolean consultaHorario(String horario, String dia) {
		if(!alocacao.getDiasDeAtendimento().contains(dia))
			return false;
		if(!alocacao.getHorarioDeAtendimento().contains(horario))
			return false;
		return true;
	}
	public boolean consultaLocal(String local) {
		if(!alocacao.getLocaisDeAtendimento().contains(local))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return super.toString() + " - " + this.getDisciplina() + " - " + this.proficiencia;
	}
	
}
