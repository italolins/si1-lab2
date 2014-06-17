package models;


public class Meta {
	private String nomeMeta;
	private String descricao;
	private int semana,prioridade;

	

	public Meta(String nomeMeta, String descricao, int semana, int prioridade) {
		this.nomeMeta = nomeMeta;
		this.setDescricao(descricao);
		this.setSemana(semana);
		this.setPrioridade(prioridade);
		// TODO Auto-generated constructor stub
	}

	public String getNomeMeta() {
		return nomeMeta;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
	
	public int getSemana() {
		return semana;
	}

	public void setSemana(int semana) {
		this.semana = semana;
	}
	
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof Meta)){
			return false;
		}else{
			Meta met = (Meta)obj;
			return met.getNomeMeta().equals(this.nomeMeta);
		}
	} 

	
}
