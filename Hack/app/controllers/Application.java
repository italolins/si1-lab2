package controllers;

import java.util.ArrayList;

import models.Hackfest;
import play.*;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {
	
	private static Hackfest hack = new Hackfest("hack");

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
    public static Result adm(){
    	return ok(admView.render("Your new application is ready.",hack));
    }
    
    public static Result user(){
    	return ok(userView.render("Your new application is ready.",hack,""));
    }
    
    public static Result adicionaEvento(){
    	DynamicForm requestData = Form.form().bindFromRequest();
    	
    	String nome = requestData.get("nome");
    	String descricao = requestData.get("descricao");
    	int dia = Integer.parseInt(requestData.get("dia"));
    	int mes = Integer.parseInt(requestData.get("mes"));
    	String tema1 = requestData.get("tema1");
    	String tema2 = requestData.get("tema2");
    	String tema3 = requestData.get("tema3");
    	String tema4 = requestData.get("tema4");
    	String tema5 = requestData.get("tema5");
    	
    	ArrayList<String> tema = new ArrayList<String>();
    	
    	if(tema1 != null){
    		tema.add(tema1);
    	}
    	if(tema2 != null){
    		tema.add(tema2);
    	}
    	if(tema3 != null){
    		tema.add(tema3);
    	}
    	if(tema4 != null){
    		tema.add(tema4);
    	}
    	if(tema5 != null){
    		tema.add(tema5);
    	}
    	
    	hack.addNovoEvento(nome,descricao,dia,mes,tema);
    	
    	return ok(admView.render("ok!",hack));
    }
    
    public static Result cadastro(){
    	DynamicForm requestData = Form.form().bindFromRequest();
    	
    	String evento = requestData.get("evento");
    	
    	return ok(cadastroView.render("ok!",evento,""));
    }
    
    public static Result adicionaParticipante(){
    	DynamicForm requestData = Form.form().bindFromRequest();
    	
    	String nome = requestData.get("nome");
    	String email = requestData.get("email");
    	String evento = requestData.get("evento");
    	
    	hack.addPresencaParaEvento(evento, nome, email);
    	
    	return ok(cadastroView.render("ok",evento,"Cadastro realizado com sucesso!"));
    }
    
    public static Result filtrarUser(){
    	DynamicForm requestData = Form.form().bindFromRequest();
    	
    	String tema = requestData.get("tema");
    	
    	if(tema.equals("naoFiltrar")){
    		return ok(userView.render("Your new application is ready.",hack,""));
    	}else{
    		return ok(userView.render("Your new application is ready.",hack,tema));
    	}
    }

}
