package XPATH;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Index {

	public static void main(String[] args) throws Exception {

		// String xPathExpression = "/espacio/galaxia/estrella/planeta";
		// String xPathExpression = "//planeta";
		String xPathExpression = "/espacio/galaxia/estrella | /espacio/galaxia/sistema_estelar/estrella";

		// Carga del documento xml
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document documento = builder.parse(new File("./Resources/galaxia.xml"));

		// Preparación de xpath
		XPath xpath = XPathFactory.newInstance().newXPath();

		// Consultas
		NodeList nodos = (NodeList) xpath.evaluate(xPathExpression, documento, XPathConstants.NODESET);
		for (int i = 0; i < nodos.getLength(); i++) {
			System.out.println(nodos.item(i).getNodeName() + ": " + nodos.item(i).getAttributes().getNamedItem("nombre"));
		}
	}
}
