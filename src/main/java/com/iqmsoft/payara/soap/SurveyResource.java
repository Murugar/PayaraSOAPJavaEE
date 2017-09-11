
package com.iqmsoft.payara.soap;

import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("survey")
public class SurveyResource {

    @Context
    private UriInfo context;

   
    public SurveyResource() {
    }

  
    @Path("init")
    @GET
    @Produces("application/json")
    public Response createQuestionnaire() {
       
        Question q = Question.getInstance();
        
        Survey s = new Survey(1, "Capital Of France");
        s.addOption(1, "Clermont-Ferrand");
        s.addOption(2, "Lyon");
        s.addOption(3, "Paris");
        
        Survey s1 = new Survey(2, "Capital Of Australia");
        s1.addOption(9, "Sydney");
        s1.addOption(7, "Canberra");
        s1.addOption(8, "Adelaide");
        
        q.addSurvey(s);
        q.addSurvey(s1);
        
        return Response.status(Response.Status.OK).entity("Questionnaire Added").build();
        
    }
    
   
    @Path("consulterQuestionnaire")
    @GET
    @Produces("application/json")
    public Question getQuestionnaire() {
        Question q = Question.getInstance();
        return q;
    }
    
   
    @Path("consulterSurvey/{id}")
    @GET
    @Produces("application/json")
    public Response getSondageId(@PathParam("id") int id) {
        Survey sondageTrouve = null;
        ArrayList<Survey> listeSondage = Question.getInstance().getSurveys();
        for (Survey sondage : listeSondage){
            if(id == sondage.getId()){
                return Response.status(Response.Status.OK).entity(sondage).build();
            }
        }
        return Response.status(Response.Status.BAD_REQUEST).build();

    }
    
  
    @Path("creationSurvey")
    @POST
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createSondage(Survey sondage) { 
        Question.getInstance().addSurvey(sondage);
        return Response.status(Response.Status.CREATED).entity(sondage).build(); 
    }

  
    @Path("suppressionSurvey/{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteSondage(@PathParam("id") int id) { 
        Survey sondageTrouve = null;
        ArrayList<Survey> listeSondage = Question.getInstance().getSurveys();
        for (Survey sondage : listeSondage){
            if(id == sondage.getId()){
                listeSondage.remove(sondage);
                return Response.status(Response.Status.OK).build();
            }
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    
  
    @Path("modifierSurvey")
    @PUT
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateSondage(Survey sondageParam) {
        
        ArrayList<Survey> listeSondage = Question.getInstance().getSurveys();
        for (Survey sondage : listeSondage){
            if(sondageParam.getId() == sondage.getId()){
                listeSondage.remove(sondage);
                listeSondage.add(sondageParam);
                return Response.status(Response.Status.OK).entity(sondageParam).build();
                
            }
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
        
    }
    
    
}
