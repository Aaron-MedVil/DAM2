package SAXFiles;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class index {

	/**
	 * Metodo principal
	 * @param args
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws SAXException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, SAXException {
		
		@SuppressWarnings("deprecation")
		XMLReader procesadorXML;
		GestionContenido gestor = new GestionContenido();
		procesadorXML.setContentHandler(gestor);
		InputSource fileXML = new InputSource("./Resources/alumnos-min.xml");
		procesadorXML.parse(fileXML);
	}
}

/**
 * Clase que controla los eventos del XMLReader de SAX
 */
class GestionContenido extends DefaultHandler {
	
	/**
	 * Constructor de la clase
	 */
	public GestionContenido() {
		super();
	}
	
	/**
	 * Metodo que se ejecuta al iniciar el documento
	 */
	public void startDocument() {
		System.out.println("Comienzo del documento XML");
	}
	
	/**
	 * Metodo que se ejecuta al terminar el fichero XML
	 */
	public void endDocument() {
		System.out.println("Fin del documento XML");
	}
	
	/**
	 * Metodo que se ejecuta cada vez que se inicia un elemento
	 * @param url
	 * @param nombre
	 * @param nombreC
	 * @param atts
	 */
	public void startElement(String url, String nombre, String nombreC, Attributes atts) {
		System.out.printf("\tInicio del Elemento: %s %n", nombre);
	}
	
	/**
	 * Metodo que se ejecuta cada vez que se termina un elemento
	 * @param url
	 * @param nombre
	 * @param nombreC
	 * @param atts
	 */
	public void endElement(String url, String nombre, String nombreC, Attributes atts) {
		System.out.printf("\tFin del Elemento: %s %n", nombre);
	}
	
	public void characters(char[] ch, int inicio, int longitud) throws SAXException {
		
	}
}