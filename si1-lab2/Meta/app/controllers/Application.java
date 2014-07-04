package controllers;

import play.data.DynamicForm;
import play.data.Form;
import models.Usuario;
import play.*;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {
	
	private static Usuario usuario = new Usuario("Italo","faslfa");
	private static int Semana = 1;

    public static Result index() {
    	usuario.addMeta("tema1", "descricao", 1, 2);
    	usuario.addMeta("tema2", "descricao", 1, 3);
    	usuario.addMeta("tema3", "descricao", 1, 1);
    	usuario.addMeta("tema4", "descricao", 2, 1);
    	usuario.addMeta("tema5", "descricao", 2, 2);
    	usuario.addMeta("tema6", "descricao", 2, 2);
    	usuario.addMeta("tema7", "descricao", 3, 1);
    	usuario.addMeta("tema8", "descricao", 3, 3);
    	usuario.addMeta("tema9", "descricao", 3, 2);
    	usuario.addMeta("tema10", "descricao", 3, 3);
        return ok(index.render("Your new application is ready.",null,usuario,Semana));
    }
    
    public static Result adicionaMeta(){
    	DynamicForm requestData = Form.form().bindFromRequest();

		String nome = requestData.get("nomeMeta");
		String descricao = requestData.get("descricao");
		int semana = Integer.parseInt(requestData.get("semana"));
		int prioridade = Integer.parseInt(requestData.get("prioridade"));
		
		usuario.addMeta(nome, descricao, semana, prioridade);

    	return ok(index.render("Ta começando a frunfar",nome,usuario,Semana));
    }

    public static Result removeMeta(){
    	DynamicForm requestData = Form.form().bindFromRequest();
    	
    	String nome = requestData.get("meta");
    	usuario.removeMeta(nome);
    	
    	return ok(index.render("Ta começando a frunfar",nome,usuario,Semana));
    }
    
    public static Result metaAlcancada(){
    	DynamicForm requestData = Form.form().bindFromRequest();
    	
    	String nome = requestData.get("meta");
    	usuario.metaAlcancada(nome);;
    	
    	return ok(index.render("Ta começando a frunfar",nome,usuario,Semana));
    }
    
    public static Result mostraSemana(){
    	DynamicForm requestData = Form.form().bindFromRequest();
    	
    	Semana = Integer.parseInt(requestData.get("semana"));
    	
    	return ok(index.render("Ta começando a funfar", null, usuario,Semana));
    }
}
