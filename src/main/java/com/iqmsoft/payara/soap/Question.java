
package com.iqmsoft.payara.soap;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(                                                  
  name = "questionnaire",
  namespace="http://localhost:8080/PayaraSOAPJavaEE/survey"
)


public class Question {
    
    private ArrayList<Survey> surveys;
    private static Question questionnaire;

    private Question() {
        this.surveys = new ArrayList<Survey>();
    }
    
    public ArrayList<Survey> getSurveys() {
        return surveys;
    }

    public void setSondages(ArrayList<Survey> surveys) {
        this.surveys = surveys;
    }

 
    public static Question getInstance (){
        if(questionnaire == null){
            questionnaire = new Question();
        }
        return questionnaire;
    }
    
   
    public void addSurvey (Survey survey){
        this.getSurveys().add(survey);
    }
    
    
}
