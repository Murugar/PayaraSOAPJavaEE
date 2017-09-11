package com.iqmsoft.payara.soap;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(                                                  
  name = "survey",
  namespace="http://localhost:8080/PayaraSOAPJavaEE/survey"
)

public class Survey {
    
    private int id;
    private String intitule;
    private ArrayList<Option> options;

    public Survey(int id, String intitule) {
        this.id = id;
        this.intitule = intitule;
        this.options = new ArrayList<Option>();
    }

    public Survey() {
        this.options = new ArrayList<Option>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public ArrayList<Option> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<Option> options) {
        this.options = options;
    }
    
   
    public void addOption (int id, String rep){
        Option option = new Option(id,rep,0);
        options.add(option);
    }
    
}
