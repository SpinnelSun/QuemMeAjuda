package models;

import java.util.Comparator;

import controllers.AcademicoPorEmail;
import controllers.AcademicoPorMatricula;
import controllers.AcademicoPorNome;

import views.SeletorOrdenacao;

public enum Ordenacao implements SeletorOrdenacao {
	
	NOME("NOME") {
		@Override
		public Comparator<Academico> definirOrdenacao() {
			return new AcademicoPorNome();
		}		
	},
	
	MATRICULA("MATRICULA") {
		@Override
		public Comparator<Academico> definirOrdenacao() {
			return new AcademicoPorMatricula();
		}		
	},
	
	EMAIL("EMAIL") {
		@Override
		public Comparator<Academico> definirOrdenacao() {
			return new AcademicoPorEmail();
		}		
	};
	
	private String tipoOrdenacao;
	
	Ordenacao(String tipoOrdenacao) {
		this.tipoOrdenacao = tipoOrdenacao;
	}
	
	@Override
	public String toString() {
		return this.tipoOrdenacao;
	}

}
