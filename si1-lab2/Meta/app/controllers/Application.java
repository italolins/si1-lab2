package controllers;

import play.data.DynamicForm;
import play.data.Form;
import models.Usuario;
import play.*;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {
	
	private static Usuario usuario = new Usuario("Italo","faslfa");

    public static Result index() {
        return ok(index.render("Your new application is ready.",null,usuario));
    }
    
    public static Result adicionaMeta(){
    	DynamicForm requestData = Form.form().bindFromRequest();

		String nome = requestData.get("nomeMeta");
		String descricao = requestData.get("descricao");
		int dia = Integer.parseInt(requestData.get("dia"));
		int mes = Integer.parseInt(requestData.get("mes"));
		int prioridade = Integer.parseInt(requestData.get("prioridade"));
		
		usuario.addMeta(nome, descricao, dia, mes, prioridade);

    	return ok(index.render("Ta começando a frunfar",nome,usuario));
    }

    public static Result removeMeta(){
    	DynamicForm requestData = Form.form().bindFromRequest();
    	
    	String nome = requestData.get("name");
    	usuario.removeMeta(nome);
    	
    	return ok(index.render("Ta começando a frunfar",nome,null));
    }
}
