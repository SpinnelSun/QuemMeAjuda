package models;

public class Aluno {
	
	private int matricula;
	private String nome;
	private String cod_curso;
	private String telefone;
	private String email;
	

	public Aluno(int matricula, String nome, String cod_curso, String telefone, String email) {
		this.matricula = matricula;
		this.nome = nome;
		this.cod_curso = cod_curso;
		this.telefone = telefone;
		this.email = email;
	}
	
	public Aluno(int matricula, String nome, String cod_curso, String email) {
		this.matricula = matricula;
		this.nome = nome;
		this.cod_curso = cod_curso;
		this.telefone = null;
		this.email = email;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCod_curso() {
		return cod_curso;
	}
	public void setCod_curso(String cod_curso) {
		this.cod_curso = cod_curso;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		if(!(this.getTelefone() == null))
			return this.getMatricula() + " - " + this.getNome() + " - " + this.getCod_curso() + " - " +
					this.getEmail();
		return this.getMatricula() + " - " + this.getNome() + " - " + this.getCod_curso() + " - " +
				this.getTelefone() + " - " + this.getEmail();
	}
	
	

}
