/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shared;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 *
 * @author usrlab09
 */
public class ReadXMLFile {

    private String caminho;

    public ReadXMLFile() {

    }

    public ReadXMLFile(String caminho) {
        this.caminho = caminho;
    }

    public Object Read() {
        try {
            File fXmlFile = new File(caminho);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            return dBuilder.parse(fXmlFile);
        } catch (Exception e) {

        }
        return null;
    }

}
