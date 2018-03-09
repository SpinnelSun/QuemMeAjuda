package controllers;

import java.util.List;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.HashMap;

import models.Academico;
import models.Aluno;
import models.Candidato;
import models.Ordenacao;
import models.Tutor;
import utility.Validador;

public class TutorController {
	
	private Map<String, Tutor> tutores;
	private Comparator<Academico> ordenadorTutores;
	
	public TutorController() {
		this.tutores = new HashMap<String, Tutor>();
		this.ordenadorTutores = new AcademicoPorNome();
	}
		
	public void criarNovoTutor(String matricula, String nome, String codigoCurso, String telefone, String email) {
		if (!this.tutores.containsKey(matricula)) {
			
			this.tutores.put(matricula, new Tutor(nome, matricula, Integer.parseInt(codigoCurso), telefone,
							 email, this.tutores.size() + 1));
		}
	}
	
	public int quantTudores() {
		return this.tutores.size();
	}
	
	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
			this.tutores.get(matricula).adicionarHabilidade(disciplina, proficiencia);
	}
	
	public void impedirTutorNaoCadastrado(String matricula, String msg) {
		if (!this.tutores.containsKey(matricula)) {
			throw new IllegalArgumentException(msg);
		}
	}
	
	public String recuperaTutor(String matricula) {
		this.impedirTutorNaoCadastrado(matricula, "Tutor nao encontrado");
		return this.tutores.get(matricula).toString();
	}
	
	private List<Tutor> ordenarTutores() {
		
		List<Tutor> listaDeTutores = new ArrayList<Tutor>();
		listaDeTutores.addAll(this.tutores.values());
		listaDeTutores.sort(this.ordenadorTutores);
			
		return listaDeTutores;
	}
	
	public String listarTutores() {
		String listagemTutores = "";
		
		for (int i = 0; i < this.ordenarTutores().size() - 1; i++) {
			listagemTutores += ordenarTutores().get(i).toString() + ", ";
		}
		
		listagemTutores += ordenarTutores().get(ordenarTutores().size() - 1).toString();		
		return listagemTutores;
	}
	
	private String getMatriculaPorEmail(String email) {
		for(Tutor tutor : this.ordenarTutores()) {
			if(tutor.getEmail().equals(email)) {
				return tutor.getMatricula();
			}
		}
		
		return "";
	}
	
	public void cadastrarHorario(String email, String horario, String dia) {
		Validador.validarStringNaoVaziaNaoNula("email nao pode ser vazio ou em branco", email);
		Validador.validarStringNaoVazia("tutor nao cadastrado", this.getMatriculaPorEmail(email));
			
		this.tutores.get(this.getMatriculaPorEmail(email)).cadastrarHorario(horario, dia);
	}
	
	public void cadastrarLocalDeAtendimento(String email, String local) {
		Validador.validarStringNaoVaziaNaoNula("email nao pode ser vazio ou em branco", email);
		Validador.validarStringNaoVazia("tutor nao cadastrado", this.getMatriculaPorEmail(email));
		
		this.tutores.get(this.getMatriculaPorEmail(email)).cadastrarLocalDeAtendimento(local);
	}
	
	public boolean consultaHorario(String email, String horario, String dia) {
		try {
			Validador.validarStringNaoVaziaNaoNula("email nao pode ser vazio ou em branco", email);
			Validador.validarStringNaoVazia("tutor nao cadastrado", this.getMatriculaPorEmail(email));
			
			return this.tutores.get(this.getMatriculaPorEmail(email)).consultaHorario(horario, dia);
		}
		
		catch (IllegalArgumentException e) {
			return false;
		}
	}
	
	public boolean consultaLocal(String email, String local) {
		try {
			Validador.validarStringNaoVaziaNaoNula("email nao pode ser vazio ou em branco", email);
			Validador.validarStringNaoVazia("tutor nao cadastrado", this.getMatriculaPorEmail(email));
			
			return this.tutores.get(this.getMatriculaPorEmail(email)).consultaLocal(local);
		}
		
		catch (IllegalArgumentException e) {
			return false;
		}
	}
	
	
	

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
	
	public String selecionarTutor(String disciplina) {
		List<Candidato> candidatos = this.listarCandidatos(disciplina);
		candidatos.sort(new CandidatoPorProficiencia());
		
		return candidatos.isEmpty() ? "" : candidatos.get(0).getMatricula();
	}
	
	public String selecionarTutor(String disciplina, String hora, String dia, String local) {
		List<Candidato> candidatos = this.listarCandidatos(disciplina, hora, dia, local);
		candidatos.sort(new CandidatoPorProficiencia());
		
		return candidatos.isEmpty() ? "" : candidatos.get(0).getMatricula();
	}
	
	public double pegarNotaDouble(String matricula) {
		return tutores.get(matricula).getNota();
	}
	
	public String pegarNotaString(String matricula) {
		this.impedirTutorNaoCadastrado(matricula, "Tutor nao encontrado");
		
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(tutores.get(matricula).getNota());
	}

	public String pegarNivel(String matricula) {
		this.impedirTutorNaoCadastrado(matricula, "Tutor nao encontrado");
		return tutores.get(matricula).getNivel();
	}
	
	public void adicionarAvaliacao(String matricula, int nota) {
		this.tutores.get(matricula).adicionarAvaliacao(nota);
	}
	
	private double calcularTaxaTutor(int totalCentavos, double notaTutor) {
		if (notaTutor > 4.5) {	return (0.9 + ((notaTutor - 4.5) * 0.1)); }
		
		if (notaTutor > 3.0) { return (0.8); }
		
		return (0.4 - ((3.0 - notaTutor) * 0.1));
	}
	
	public int calcularComissao(String matriculaTutor, int totalCentavos) {
		this.impedirTutorNaoCadastrado(matriculaTutor, "Tutor nao encontrado");
		Validador.validarIntNaoNegativo("totalCentavos nao pode ser menor que zero", totalCentavos);
		
		double notaTutor = this.tutores.get(matriculaTutor).getNota();
		
		return (int) Math.ceil((1 - this.calcularTaxaTutor(totalCentavos, notaTutor)) * totalCentavos);
	}
	
	private int calcularTotalTutor(String matriculaTutor, int totalCentavos) {
		return totalCentavos - this.calcularComissao(matriculaTutor, totalCentavos);
	}
	
	public void adicionarDoacao(String matriculaTutor, int totalCentavos) {
		this.impedirTutorNaoCadastrado(matriculaTutor, "Tutor nao encontrado");
		Validador.validarIntNaoNegativo("totalCentavos nao pode ser menor que zero", totalCentavos);
		
		int totalTutor = this.calcularTotalTutor(matriculaTutor, totalCentavos);
		
		this.tutores.get(matriculaTutor).adicionarDoacao(totalTutor);
	}
	
	public int getTotalDinheiroTutor(String emailTutor) {
		this.impedirTutorNaoCadastrado(this.getMatriculaPorEmail(emailTutor), "Tutor nao encontrado");
		return this.tutores.get(getMatriculaPorEmail(emailTutor)).getDinheiroRecebido();
	}
	
	public void configurarOrdem(String atributo) {
		this.ordenadorTutores = Ordenacao.valueOf(atributo.toUpperCase()).definirOrdenacao();
	}
	
}
