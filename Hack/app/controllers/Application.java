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
    	ArrayList<String> tema1 = new ArrayList<String>();
    	ArrayList<String> tema2 = new ArrayList<String>();
    	ArrayList<String> tema3 = new ArrayList<String>();
    	ArrayList<String> tema4 = new ArrayList<String>();
    	ArrayList<String> tema5 = new ArrayList<String>();
    	tema1.add("tema1");
    	tema1.add("tema3");
    	tema1.add("tema5");
    	tema2.add("tema2");
    	tema2.add("tema3");
    	tema2.add("tema4");
    	tema3.add("tema1");
    	tema3.add("tema5");
    	tema4.add("tema2");
    	tema5.add("tema2");
    	tema5.add("tema3");
    	tema5.add("tema4");
    	hack.addNovoEvento("Evento1", "descricao", 1, 1, tema1);
    	hack.addNovoEvento("Evento2", "descricao", 1, 1, tema2);
    	hack.addNovoEvento("Evento3", "descricao", 1, 1, tema3);
    	hack.addNovoEvento("Evento4", "descricao", 1, 1, tema4);
    	hack.addNovoEvento("Evento5", "descricao", 1, 1, tema5);
    	hack.addNovoEvento("Evento6", "descricao", 1, 1, tema1);
    	hack.addNovoEvento("Evento7", "descricao", 1, 1, tema2);
    	hack.addNovoEvento("Evento8", "descricao", 1, 1, tema2);
    	hack.addNovoEvento("Evento9", "descricao", 1, 1, tema3);
    	hack.addNovoEvento("Evento10", "descricao", 1, 1, tema5);
    	hack.addPresencaParaEvento("Evento3", "Italo", "italo@exemple");
    	hack.addPresencaParaEvento("Evento3", "Joao", "joao@exemple");
    	hack.addPresencaParaEvento("Evento3", "Maria", "maria@exemple");
    	hack.addPresencaParaEvento("Evento3", "Antonio", "antonio@exemple");
    	hack.addPresencaParaEvento("Evento3", "Ana", "ana@exemple");
    	hack.addPresencaParaEvento("Evento6", "Raquel", "raquel@exemple");
    	hack.addPresencaParaEvento("Evento6", "Michele", "michele@exemple");
    	hack.addPresencaParaEvento("Evento6", "Amy", "amy@exemple");
    	hack.addPresencaParaEvento("Evento6", "Ieda", "ieda@exemple");
    	hack.addPresencaParaEvento("Evento6", "Tamires", "tamires@exemple");
    	hack.addPresencaParaEvento("Evento6", "Alison", "alison@exemple");
    	hack.addPresencaParaEvento("Evento6", "Renan", "renan@exemple");
    	hack.addPresencaParaEvento("Evento10", "Jonas", "jonas@exemple");
    	hack.addPresencaParaEvento("Evento10", "Emanuel", "emanuel@exemple");
    	hack.addPresencaParaEvento("Evento10", "Ilan", "ilan@exemple");
    	hack.addPresencaParaEvento("Evento10", "Selma", "selma@exemple");
    	hack.addPresencaParaEvento("Evento10", "Ivan", "ivan@exemple");
    	hack.addPresencaParaEvento("Evento10", "Lucas", "lucas@exemple");
    	hack.addPresencaParaEvento("Evento10", "Emanuela", "emanuela@exemple");
    	hack.addPresencaParaEvento("Evento10", "Carla", "carla@exemple");
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
