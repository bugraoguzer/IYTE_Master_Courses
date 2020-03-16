package XMLReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Application.Feature;

public class XMLReader {

	ArrayList<String> featurelist =new ArrayList<String>();
	public static String Filename;
	private static XMLReader JustaInstance;
	
  
	private XMLReader(){}


	public List<String> reader12(String filename) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException,NullPointerException {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(filename);
		XPathFactory xPathfactory = XPathFactory.newInstance();
		XPath xpath = xPathfactory.newXPath();
		XPathExpression expr = xpath.compile("//feature[starts-with(value,'1')]");
		NodeList kanser = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

				for (int i = 0; i < kanser.getLength(); i++) {
					if(!kanser.item(i).getChildNodes().item(1).getTextContent().matches("Devices|Smart_Home_System|Actuators|Sensors|Alarm"))
					{
						addlist(kanser.item(i).getChildNodes().item(1).getTextContent());
					}
				}
	         
		return featurelist;
		
}
	
	public void addlist(String name)
	{
		featurelist.add(name);
	}

	  public static XMLReader getInstance(){
	        if (JustaInstance == null){
	        	JustaInstance = new XMLReader();
	        }

	        return JustaInstance;
	    }

}
