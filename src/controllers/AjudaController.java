package controllers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import models.Ajuda;
import models.AjudaOnline;
import models.AjudaPresencial;
import models.Aluno;
import models.Tutor;
import utility.Validador;

/**
 * Representacao do Controlador dos Ajudas cadastradas no Sistema do Quem Me Ajuda. Como atributos,
 * o AjudaController possui um Map contendo as Ajudas cadastradas (mapeadas a partir de seus respec-
 * tivos IDs).
 * 
 * Laboratorio de Programacao 2 - Projeto de Laboratorio - Quem Me Ajuda
 * 
 * @author Mateus de Lima Oliveira  - 117110219
 * @author Matheus Alves dos Santos - 117110503
 * @author Misael Augusto Silva da Costa - 117110525
 *
 */
public class AjudaController {
	
	private Map<Integer, Ajuda> ajudas;
	
	/**
	 * Constroi o AjudaController. O Map de Ajudas sera inicialmente vazio.
	 * 
	 */
	public AjudaController() {
		this.ajudas = new HashMap<Integer, Ajuda>();
	}
	
	/**
	 * A partir das informacoes passadas como parametros desse metodo, cria uma nova AjudaPresencial
	 * e a mapeia partir de seu ID (que sera o número de Ajudas cadastradas apos a execucao desse me-
	 * todo). Por fim, retorna o ID da AjudaPresencial cadastrada.
	 * 
	 * @param matricula A matricula do Aluno solicitante da Ajuda.
	 * @param disciplina A disciplina referente a Ajuda.
	 * @param hora A hora do atendimento.
	 * @param dia O dia do atendimento.
	 * @param local O local do atendimento.
	 * @param matriculaTutor A matricula do Tutor responsavel pelo atendimento.
	 * 
	 * @returns O ID da AjudaPresencial cadastrada.
	 * 
	 */
	public int pedirAjudaPresencial (String matriculaAluno, String disciplina, String hora, String dia,
									 String local, String matriculaTutor) {
		
		this.ajudas.put(this.ajudas.size() + 1, new AjudaPresencial(matriculaAluno, disciplina, hora, dia,
						local, matriculaTutor));
		
		return this.ajudas.size();
	}
	
	/**
	 * A partir das informacoes passadas como parametros desse metodo, cria uma nova AjudaOnline e a
	 * mapeia partir de seu ID (que sera o número de Ajudas cadastradas apos a execucao desse metodo).
	 * Por fim, retorna o ID da AjudaOnline cadastrada.
	 * 
	 * @param matricula A matricula do Aluno solicitante da Ajuda.
	 * @param disciplina A disciplina referente a Ajuda.
	 * @param matriculaTutor A matricula do Tutor responsavel pelo atendimento.
	 * 
	 * @returns O ID da AjudaOnline cadastrada.
	 * 
	 */
	public int pedirAjudaOnline (String matriculaAluno, String disciplina, String matriculaTutor) {
		this.ajudas.put(this.ajudas.size() + 1, new AjudaOnline(matriculaAluno, disciplina, matriculaTutor));
		return this.ajudas.size();
	}
	
	/**
	 * Verifica se existe cadastro de uma Ajuda cujo ID e o informado como primeiro parametro desse
	 * metodo. Caso a Ajuda nao tenha sido cadastrada, uma excecao adequada sera lancada com a men-
	 * sagem tambem informada como parametro.
	 * 
	 * @param idAjuda O ID da Ajuda a ser verificada.
	 * @param msg A mensagem a ser associada a excecao possivelmente lancada.
	 * 
	 * @returns null.
	 * 
	 */
	private void impedirAjudaNaoCadastrada(int idAjuda, String msg) {
		if (!this.ajudas.containsKey(idAjuda)) {
			throw new IllegalArgumentException(msg);
		}
	}

	/**
	 * Retorna a representacao textual do Tutor responsavel por atender a uma Ajuda castrada. A Aju-
	 * da a ser consultada sera aquela cujo ID for igual ao informado como parametro do metodo. Caso
	 * se tente recuperar o Tutor de uma Ajuda nao adastrada, a excecao adequada sera lancada.
	 * 
	 * @param idAjuda O ID da Ajuda de interesse na consulta.
	 * 
	 * @returns A representacao textual do Tutor responsavel pela Ajuda.
	 * 
	 */
	public String pegarTutor(int idAjuda) {
		Validador.validarInteiroPositivo("id nao pode menor que zero ", idAjuda);
		this.impedirAjudaNaoCadastrada(idAjuda, "id nao encontrado ");
		
		return this.ajudas.get(idAjuda).toString();
	}
	
	/**
	 * Retorna a representacao textual de um dos atributos de uma Ajuda ja cadastrada. A Ajuda que
	 * tera o atributo recuperado e aquela cujo ID for igual ao informado como parametro do metodo.
	 * Caso nenhuma das Ajudas cadastradas possua o ID informado, a excecao adequada sera lancada.
	 * 
	 * @param idAjuda O ID da Ajuda de interesse na consulta.
	 * @param atributo O nome do atributo de interesse na consulta.
	 * 
	 * @returns A informacao desejada sobre a Ajuda consultada.
	 * 
	 */
	public String getInfoAjuda(int idAjuda, String atributo) {
		Validador.validarInteiroPositivo("id nao pode menor que zero ", idAjuda);
		this.impedirAjudaNaoCadastrada(idAjuda, "id nao encontrado ");
		
		return this.ajudas.get(idAjuda).getInfo(atributo);
	}
	
	/**
	 * Registra que uma das Ajudas cadastradas foi avaliada. Caso se tente avaliar uma Ajuda cujo ID
	 * nao esteja cadastrado, a excecao adequada sera lancada.
	 * 
	 * @param idAjuda O ID da Ajuda a ser avaliada.
	 * 
	 * @returns null.
	 * 
	 */
	public void registrarAvaliacao(int idAjuda) {
		this.impedirAjudaNaoCadastrada(idAjuda, "id nao encontrado ");
		this.ajudas.get(idAjuda).registrarAvaliacao();
	}
	
	/**
	 * Registra em um arquivo txt as Ajudas registradas no Sistema ate o momento.
	 * 
	 * @returns null.
	 * 
	 */
	public void salvar() {
		try{
			FileOutputStream arquivoGrav = new FileOutputStream("arquivos-persistencia/Ajudas.txt");		
			ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrav);
			
			for(Ajuda ajuda: this.ajudas.values()) {
				objGravar.writeObject(ajuda);	
			}
			
			objGravar.close();
			arquivoGrav.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Limpa o arquivo txt que as Ajudas estavam registradas.
	 * 
	 * @returns null.
	 * 
	 */
	public void limpar() throws IOException {
		Writer out = new FileWriter("Ajudas.txt");
        out.write("");
        out.flush();
    }
	
	/**
	 * Carrega Ajudas registradas de um arquivo txt e retorna para o Sistema.
	 * 
	 * @returns null.
	 * 
	 */
	public void carregar() throws IOException {
		FileInputStream arquivoLeitura = new FileInputStream("arquivos-persistencia/Ajudas.txt");
		ObjectInputStream objLeitura = new ObjectInputStream(arquivoLeitura);
		   
		while(true){
			try{
				Ajuda ajuda = (Ajuda)objLeitura.readObject();
		    	//ajudas.put(ajuda.getId, ajuda);
		    }catch(Exception e){ break; }
		}
		
		objLeitura.close();
		arquivoLeitura.close();
	}

}
