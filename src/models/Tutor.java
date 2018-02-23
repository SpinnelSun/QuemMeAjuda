package models;

public class Tutor extends Aluno {
	
	private String disciplina;
	private int proficiencia;
	private int dinheiroRecebido;
	
	public Tutor(String matricula, String nome, int codigoCurso, String email, String disciplina,
				 int proficiencia) {
		
		super(nome, matricula, codigoCurso, email);
			
		this.disciplina = disciplina.trim();
		this.proficiencia = proficiencia;
		this.dinheiroRecebido = 0;
		
		this.setNota(4.0);
	}
	
	public Tutor(String matricula, String nome, int codigoCurso, String telefone, String email,
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
	
	@Override
	public String toString() {
		return super.toString() + " - " + this.getDisciplina() + " - " + this.proficiencia;
	}
	
}
