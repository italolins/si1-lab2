

import static org.junit.Assert.*;
import models.Usuario;

import org.junit.Before;
import org.junit.Test;


public class TestUsuario{
	
	private Usuario usuario;
	
	@Before
	public void setup(){
		usuario = new Usuario("Italo","testeSenha");
		usuario.addMeta("AJAX","Descricao da meta",1,10,6); // nao entendi pq mas se tirar isso daqui o teste de remoçao quebra
	}
	
	@Test
	public void usuarioDevePoderAdicionarMetas(){
		usuario.addMeta("Aprender AJAX","Descricao da meta",1,10,6);
		usuario.addMeta("Java","Descricao da meta",1,10,6);
		usuario.addMeta("Python","Descricao da meta",1,10,6);
	}
	
	@Test
	public void usuarioDevePoderRemoverMetas(){
		assertTrue(usuario.removeMeta("AJAX"));
	}
	
	@Test
	public void usuarioPodeMarcarMetaComoAlcancada(){
		usuario.metaAlcancada("Aprender AJAX");
	}

}
