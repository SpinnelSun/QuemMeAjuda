package controllers;

import java.util.Comparator;

import models.Candidato;

public class CandidatoPorProficiencia implements Comparator<Candidato> {
	
	@Override
	public int compare(Candidato candidato1, Candidato candidato2) {
		return candidato1.getProficiencia() != candidato2.getProficiencia()
			 ? candidato1.getProficiencia() - candidato2.getProficiencia()
			 : candidato1.getNumeroCadastro() - candidato2.getNumeroCadastro();
	}

}
