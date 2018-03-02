package models;

import org.junit.Before;

public class AjudaPresencialTest {

	private AjudaPresencial ajudaUm;
	
	@Before
	public void inicializar() {
		ajudaUm = new AjudaPresencial("116209078", "Programacao 2", "15:00", "seg", "LCC3");
	}
	
}
