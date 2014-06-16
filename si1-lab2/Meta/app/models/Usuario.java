package models;

import java.util.ArrayList;
import java.util.Iterator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "senha")
	private String senha;
	private ArrayList<Meta> metas;
	private ArrayList<Meta> metasAlcancadas;
	
	public Usuario(){
		metas = new ArrayList<Meta>();
		metasAlcancadas = new ArrayList<Meta>();
	}
	
	public Usuario(String nome, String senha){
		this.nome = nome;
		this.setSenha(senha);
		metas = new ArrayList<Meta>();
		metasAlcancadas = new ArrayList<Meta>();
	}

	public void addMeta(String nomeMeta, String Descricao, int dia, int mes, int prioridade) {
		metas.add(new Meta(nomeMeta,Descricao,dia,mes,prioridade));
		
	}

	public boolean removeMeta(String nomeMeta) {
		Iterator<Meta> it = metas.iterator();
		while(it.hasNext()){
			Meta proximaMeta = it.next();
			if(proximaMeta.getNomeMeta().equals(nomeMeta)){
				it.remove();
				return true;
			}
		}
		/*for (Meta meta : metas) {
			if(nomeMeta.equalsIgnoreCase(meta.getNomeMeta())){
				return metas.remove(meta);
			}
		}*/
		return false;
	}

	public void metaAlcancada(String nomeMeta) {
		Iterator<Meta> it = metas.iterator();
		while(it.hasNext()){
			Meta proximaMeta = it.next();
			if(proximaMeta.getNomeMeta().equals(nomeMeta)){
				metasAlcancadas.add((Meta)it);
				//it.remove();
			}
		}
		/*for (Meta meta : metas) {
			if(nomeMeta.equals(meta.getNomeMeta())){
				metas.remove(meta);
				metasAlcancadas.add(meta);
			}
		}*/
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ArrayList<Meta> getMetas() {
		return metas;
	}

	public ArrayList<Meta> getMetasAlcancadas() {
		return metasAlcancadas;
	}

}
