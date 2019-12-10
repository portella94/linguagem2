/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Shared.ReadXMLFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

@XmlRootElement
public class Parametros {

    public Parametros() throws Exception {
        setParametros();
    }

    public Parametros(String server, String port, String database) {
        this.Server = server;
        this.Port = port;
        this.Database = database;
    }
    private String Port;
    private String Database;
    private String Server;

    @XmlElement
    public void setServer(String server) {
        this.Server = server;
    }

    @XmlElement
    public void setPort(String port) {
        this.Port = port;
    }

    @XmlElement
    public void setDatabase(String database) {
        this.Database = database;
    }

    public String getServer() {
        return Server;
    }

    public String getPort() {
        return Port;
    }

    public String getDatabase() {
        return Database;
    }

    private void setParametros() throws Exception {
        try {
            String caminho = new File(".").getCanonicalPath()
                    + "\\appConfig.xml";
            ReadXMLFile xml = new ReadXMLFile(caminho);

            Map<String, String> parametros = xml.Read();
            Field[] atributos = Parametros.class.getDeclaredFields();
            Method[] metodos = Parametros.class.getMethods();

            parametros.entrySet().forEach((parametro) -> {
                for (Field atributo : atributos) {
                    if (parametro.getKey().toLowerCase().equals(atributo.getName().toLowerCase())) {
                        for (Method metodo : metodos) {
                            if (metodo.getName().equals("set" + atributo.getName())) {
                                try {
                                    metodo.invoke(this, "" + parametro.getValue());
                                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                                    Logger.getLogger(Parametros.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                    }
                }
            });
        } catch (Exception ex) {
            Logger.getLogger(Parametros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
