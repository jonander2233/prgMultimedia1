package com.jonander2233.recyclerviewcountries;

import android.content.Context;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class CountryParser {

    public static ArrayList<Country> parseToArrayList(Context context) throws ParserConfigurationException, IOException, SAXException {
        ArrayList<Country> countries = new ArrayList<>();
        InputStream inputStream = context.getResources().openRawResource(R.raw.countries);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(inputStream);
        document.getDocumentElement().normalize();
        NodeList countryNodes = document.getElementsByTagName("country");
        for (int i = 0; i < countryNodes.getLength(); i++) {
            Node countryNode = countryNodes.item(i);
            if (countryNode.getNodeType() == Node.ELEMENT_NODE) {
                Element countryElement = (Element) countryNode;
                // Obtenemos los atributos del país
                String countryCode = countryElement.getAttribute("countryCode");
                String countryName = countryElement.getAttribute("countryName");
                int population = Integer.parseInt(countryElement.getAttribute("population"));
                String capital = countryElement.getAttribute("capital");
                // Creamos un objeto Country
                Country country = new Country(countryCode, countryName, population, capital);
                // Añadimos el país a la lista
                countries.add(country);
            }
        }
        return countries;
    }
    public static Country[] parseToArray(Context context) throws ParserConfigurationException, IOException, SAXException {
        Country[] countries = new Country[0];
        // Crea una lista para almacenar los objetos Country
        List<Country> countryList = new ArrayList<>();

        InputStream inputStream = context.getResources().openRawResource(R.raw.countries);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(inputStream);
        document.getDocumentElement().normalize();
        NodeList countryNodes = document.getElementsByTagName("country");
        for (int i = 0; i < countryNodes.getLength(); i++) {
            Node countryNode = countryNodes.item(i);
            if (countryNode.getNodeType() == Node.ELEMENT_NODE) {
                Element countryElement = (Element) countryNode;
                // Obtenemos los atributos del país
                String countryCode = countryElement.getAttribute("countryCode");
                String countryName = countryElement.getAttribute("countryName");
                int population = Integer.parseInt(countryElement.getAttribute("population"));
                String capital = countryElement.getAttribute("capital");
                // Creamos un objeto Country
                Country country = new Country(countryCode, countryName, population, capital);
                // Añadimos el país a la lista
                countryList.add(country);
                // Convertimos la lista a un array de Country
                countries = countryList.toArray(new Country[0]);
            }
        }
        return countries;
    }
}
