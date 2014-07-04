package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Hackfest {
	private String nome;
	private ArrayList<Evento> eventos;

	public Hackfest(String nome) {
		// TODO Auto-generated constructor stub
		this.nome = nome;
		eventos = new ArrayList<Evento>();
	}

	public void addNovoEvento(String nomeEvento, String descricao, int dia, int mes,
			ArrayList<String> temas) {
		Evento ev = new Evento(nomeEvento,descricao,dia,mes,temas);
		if(!searchEvento(ev)){
			eventos.add(ev);
		}
	}

	public void addPresencaParaEvento(String nomeEvento, String participante,
			String email) {
		Iterator<Evento> it = eventos.iterator();
		while(it.hasNext()){
			Evento proximoEvento = it.next();
			if(proximoEvento.getNomeEvento().equals(nomeEvento)){
				proximoEvento.addPresenca(participante,email);
			}
		}
		
	}
	
	public boolean searchEvento(Evento evento){
		Iterator<Evento> it = eventos.iterator();
		while(it.hasNext()){
			Evento proximoEvento = it.next();
			if(proximoEvento.getNomeEvento().equals(evento.getNomeEvento())){
				return true;
			}
		}
		return false;
	}
	
	public boolean confirmaPresencaParticipante(String nomeEvento,String nomeParticipante,String email){
		Iterator<Evento> it = eventos.iterator();
		while(it.hasNext()){
			Evento proximoEvento = it.next();
			if(proximoEvento.getNomeEvento().equals(nomeEvento)){
				Iterator<Participante> it2 = proximoEvento.getParticipantes().iterator();
				while(it2.hasNext()){
					Participante proximoParticipante = it2.next();
					if(proximoParticipante.getNome().equalsIgnoreCase("nomeParticipante")){
						return true;
					}
				}
			}
		}
		Collections.sort(eventos);
		return false;
	}

	public ArrayList<Evento> getEventos() {
		Collections.sort(eventos);
		return eventos;
	}
	
	public ArrayList<Evento> getEventos(String tema){
		if(tema.equals("")){
			return eventos;
		}else{
		ArrayList<Evento> eventosTemas = new ArrayList<Evento>();
		for(Evento evento : eventos){
			if(evento.getTemas().contains(tema)){
				eventosTemas.add(evento);
			}
		}
		Collections.sort(eventosTemas);
		return eventosTemas;
		}
	}

	public void setEventos(ArrayList<Evento> eventos) {
		this.eventos = eventos;
	}

}
