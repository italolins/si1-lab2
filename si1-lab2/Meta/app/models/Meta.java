package models;


public class Meta {
	private String nomeMeta;
	private String descricao;
	private int dia,mes,prioridade;

	public Meta(String nomeMeta, String descricao, int dia, int mes,
			int prioridade) {
		this.nomeMeta = nomeMeta;
		this.setDescricao(descricao);
		this.setDia(dia);
		this.setMes(mes);
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

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
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
