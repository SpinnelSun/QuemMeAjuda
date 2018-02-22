package controllers;

import java.util.Comparator;

import models.Aluno;

public class AlunoPorNome implements Comparator<Aluno> {

	@Override
	public int compare(Aluno aluno1, Aluno aluno2) {
		return !aluno1.getNome().equals(aluno2.getNome())
				? aluno1.getNome().compareTo(aluno2.getNome())
				: aluno1.getMatricula().compareTo(aluno2.getMatricula());
	}

}
