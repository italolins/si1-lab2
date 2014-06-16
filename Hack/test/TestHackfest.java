import org.junit.Before;
import org.junit.Test;

import models.Hackfest;


public class TestHackfest {
	
	private Hackfest hackfest;
	
	@Before
	public void setup(){
		hackfest = new Hackfest("Nome");
	}
	
	@Test
	public void testaCadastrarNovoEvento(){
		hackfest.addNovoEvento("nomeDoEvento","Descricao",1,1,"temas");
	}
	
	@Test
	public void testaAdicionarPresenca(){
		hackfest.addPresencaParaEvento("nomeDoEvento","nomeParticipante","email");
	}

}
