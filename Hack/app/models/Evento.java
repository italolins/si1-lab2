package models;

import java.util.ArrayList;
import java.util.Iterator;

public class Evento implements Comparable<Evento> {
	private String nomeEvento;
	private String descricao;
	private int dia;
	private int mes;
	private ArrayList<String> temas;
	private ArrayList<Participante> participantes;



	public Evento(String nomeEvento, String descricao, int dia, int mes,
			ArrayList<String> temas) {
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

	public ArrayList<String> getTemas() {
		return temas;
	}

	public void setTemas(ArrayList<String> temas) {
		this.temas = temas;
	}

	public String getNomeEvento() {
		return nomeEvento;
	}

	public void addPresenca(String participante, String email) {
		Participante part = new Participante(participante,email);
		if(!this.searchParticipante(part)){
			participantes.add(new Participante(participante,email));
		}
		
	}

	public ArrayList<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(ArrayList<Participante> participantes) {
		this.participantes = participantes;
	}
	
	public boolean searchParticipante(Participante part){
		Iterator<Participante> it = participantes.iterator();
		while(it.hasNext()){
			Participante proximoParticipante = it.next();
			if(proximoParticipante.getEmail().equalsIgnoreCase(part.getEmail())){
				return true;
			}
		}
		return false;
	}

	@Override
	public int compareTo(Evento outroEvento) {
		return outroEvento.getParticipantes().size() - participantes.size();
	}

}
