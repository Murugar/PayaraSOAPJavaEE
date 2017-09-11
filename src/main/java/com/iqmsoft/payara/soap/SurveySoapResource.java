
package com.iqmsoft.payara.soap;

import java.util.ArrayList;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;


@WebService(                                                           
   name="SurveySoapResource",
   targetNamespace = "http://localhost:8080/PayaraSOAPJavaEE/Survey",
   serviceName = "survey")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)  


public class SurveySoapResource {
    
   
    @WebMethod
    public void createQuestionnaire(int i) {
       
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
        
    }
    
   
    @WebMethod
    public Question getQuestionnaire(int i) {
        Question q = Question.getInstance();
        return q;
    }
    
  
    @WebMethod
    public Survey getSondageId(@PathParam("id") int id) {
        Survey sondageTrouve = null;
        ArrayList<Survey> listeSondage = Question.getInstance().getSurveys();
        for (Survey sondage : listeSondage){
            if(id == sondage.getId()){
                return sondage;
            }
        }
        throw new WebApplicationException("Wrong Answer");

    }
    
 
    @WebMethod
    public Survey createSondage(Survey sondage) { 
        Question.getInstance().addSurvey(sondage);
        return sondage; 
    }
    
  
    @WebMethod
    public void deleteSondage(@PathParam("id") int id) { 
        Survey sondageTrouve = null;
        ArrayList<Survey> listeSondage = Question.getInstance().getSurveys();
        for (Survey sondage : listeSondage){
            if(id == sondage.getId()){
                listeSondage.remove(sondage);
                return;
               
            }
        }
        throw new WebApplicationException("Wrong Answer");
    }
    
   
    @WebMethod
    public Survey updateSondage(Survey sondageParam) {
        
        ArrayList<Survey> listeSondage = Question.getInstance().getSurveys();
        for (Survey sondage : listeSondage){
            if(sondageParam.getId() == sondage.getId()){
                listeSondage.remove(sondage);
                listeSondage.add(sondageParam);
                return sondageParam;
                
            }
        }
            throw new WebApplicationException("Wrong Answer");
        
    }
}
