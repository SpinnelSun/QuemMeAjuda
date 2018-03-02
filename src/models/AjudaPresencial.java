package models;

public class AjudaPresencial extends Ajuda{

	private String horario;
	private String dia;
	private String localInteresse;
	
	public AjudaPresencial(String matrAluno, String disciplina, String horario, String dia, String localInteresse) {
		
		super(matrAluno, localInteresse);
		this.horario = horario;
		this.dia = dia;
		this.localInteresse = localInteresse;
		
	}

	public String getHorario() {
		return horario;
	}

	public String getDia() {
		return dia;
	}

	public String getLocalInteresse() {
		return localInteresse;
	}

	@Override
	public String toString() {
		return super.toString() + ", horario -" +  this.getHorario() + ", dia - " +
				this.getDia() + ", local - " + this.getLocalInteresse() + ", disciplina - " +
				this.getDisciplina();
	}
	
}
