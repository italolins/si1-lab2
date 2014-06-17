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
