package models;

import java.util.ArrayList;

public class Evento {
	private String nomeEvento;
	private String descricao;
	private int dia;
	private int mes;
	private String temas;
	private ArrayList<Participante> participantes;



	public Evento(String nomeEvento, String descricao, int dia, int mes,
			String temas) {
		// TODO Auto-generated constructor stub
		this.nomeEvento = nomeEvento;
		this.descricao = descricao;
		this.dia = dia;
		this.mes = mes;
		this.temas = temas;
		participantes = new ArrayList<Participante>();
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public String getTemas() {
		return temas;
	}

	public void setTemas(String temas) {
		this.temas = temas;
	}

	public String getNomeEvento() {
		return nomeEvento;
	}

	public void addPresenca(String participante, String email) {
		// TODO Auto-generated method stub
		participantes.add(new Participante(participante,email));
		
	}

	public ArrayList<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(ArrayList<Participante> participantes) {
		this.participantes = participantes;
	}

}
