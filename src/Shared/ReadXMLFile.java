/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shared;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author usrlab09
 */
public class ReadXMLFile {

    private String caminho = null;
    private Map<String, String> tmpAtrb = null;
    private Map<String, String> xmlVal = new LinkedHashMap<String, String>();

    public ReadXMLFile() {

    }

    public ReadXMLFile(String caminho) {
        this.caminho = caminho;
    }

    public Map<String, String> Read() throws ParserConfigurationException, org.xml.sax.SAXException, IOException, VerifyError {
        SAXParserFactory saxDoc = SAXParserFactory.newInstance();
        SAXParser saxParser = saxDoc.newSAXParser();

        DefaultHandler handler = new DefaultHandler() {
            String tmpElementName = null;
            String tmpElementValue = null;

            @Override
            public void startElement(String uri, String localName, String qName,
                    Attributes attributes) throws org.xml.sax.SAXException {
                tmpElementValue = "";
                tmpElementName = qName;
                tmpAtrb = new HashMap();
                //System.out.println("Start Element :" + qName);
                /**
                 * Store attributes in HashMap
                 */
                for (int i = 0; i < attributes.getLength(); i++) {
                    String aname = attributes.getLocalName(i);
                    String value = attributes.getValue(i);
                    tmpAtrb.put(aname.trim(), value.trim());
                }

            }

            @Override
            public void endElement(String uri, String localName, String qName)
                    throws org.xml.sax.SAXException {

                if (tmpElementName.equals(qName)) {                    
                    xmlVal.put(tmpElementName.trim(), tmpElementValue.trim());                    
                    //Fetching The Values From The Map
                    String getKeyValues = xmlVal.get(tmpElementName);
                    
                }
            }

            @Override
            public void characters(char ch[], int start, int length) throws org.xml.sax.SAXException {
                tmpElementValue = new String(ch, start, length).trim();
            }
        };
        /**
         * Below two line used if we use SAX 2.0 Then last line not needed.
         */

        //saxParser.setContentHandler(handler);
        //saxParser.parse(new InputSource("c:/file.xml"));
        saxParser.parse(new File(caminho), handler);
        return xmlVal;
    }

    private String getTextValue(String def, Element doc, String tag) {
        String value = def;
        NodeList nl;
        nl = doc.getElementsByTagName(tag);
        if (nl.getLength() > 0 && nl.item(0).hasChildNodes()) {
            value = nl.item(0).getFirstChild().getNodeValue();
        }
        return value;
    }
}
