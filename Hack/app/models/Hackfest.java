package models;

import java.util.ArrayList;
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
			String temas) {
		eventos.add(new Evento(nomeEvento,descricao,dia,mes,temas));
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

}
