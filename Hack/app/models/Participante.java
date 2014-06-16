package models;

public class Participante {
	private String nome;
	private String email;

	public Participante(String participante, String email) {
		// TODO Auto-generated constructor stub
		this.nome = participante;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}
	
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof Participante)){
			return false;
		}else{
			Participante part = (Participante)obj;
			return (part.getNome().equals(this.nome) && part.getEmail().equals(this.email));
		}
	}

}
