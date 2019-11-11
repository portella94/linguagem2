/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Parametros {

    public Parametros() {

    }
    private String porta;
    private String database;
    private String server;

    @XmlElement
    public void setServer(String server) {
        this.server = server;
    }

    @XmlElement
    public void setPorta(String porta) {
        this.porta = porta;
    }

    @XmlElement
    public void setDatabase(String database) {
        this.database = database;
    }

    public String getServer() {
        return server;
    }

    public String getPorta() {
        return porta;
    }

    public String getDatabase() {
        return database;
    }

    private void setParametros() {

    }

}
