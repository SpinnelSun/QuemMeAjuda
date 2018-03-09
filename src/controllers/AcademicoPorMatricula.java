package controllers;

import java.util.Comparator;

import models.Academico;

public class AcademicoPorMatricula implements Comparator<Academico> {
	
	@Override
	public int compare(Academico academico1, Academico academico2) {
		return academico1.getMatricula().compareTo(academico2.getMatricula());

	}
	
}