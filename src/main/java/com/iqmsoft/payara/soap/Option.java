
package com.iqmsoft.payara.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(                                                  
  name = "option",
  namespace="http://localhost:8080/PayaraSOAPJavaEE/survey"
)


public class Option {
    
    private int id;
    private String texte;
    private int nbVotes;

    public Option(int id, String texte, int nbVotes) {
        this.id = id;
        this.texte = texte;
        this.nbVotes = nbVotes;
    }

    public Option() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public int getNbVotes() {
        return nbVotes;
    }

    public void setNbVotes(int nbVotes) {
        this.nbVotes = nbVotes;
    }
    
    
}
