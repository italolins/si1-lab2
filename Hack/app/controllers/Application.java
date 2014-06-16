package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
    public static Result adm(){
    	return ok(admView.render("Your new application is ready."));
    }
    
    public static Result user(){
    	return ok(userView.render("Your new application is ready."));
    }

}
