package controllers;

import java.util.Comparator;

import models.Academico;

public class AcademicoPorEmail implements Comparator<Academico> {

	@Override
	public int compare(Academico academico1, Academico academico2) {
		return !academico1.getEmail().equals(academico2.getEmail())
				? academico1.getEmail().compareTo(academico2.getEmail())
				: academico1.getMatricula().compareTo(academico2.getMatricula());
	}

}
