package SAXFiles;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

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
		XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
		GestionContenido gestor = new GestionContenido();
		procesadorXML.setContentHandler(gestor);
		InputSource fileXML = new InputSource("./Resources/alumnos.xml");
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
		System.out.println(" ==================== Comienzo del documento XML ==================== \n");
	}
	
	/**
	 * Metodo que se ejecuta al terminar el fichero XML
	 */
	public void endDocument() {
		System.out.println("\n ==================== Fin del documento XML ==================== ");
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
		for (int i = 0; i < atts.getLength(); i++) {
            System.out.printf("\t\tAtributo %s: %s %n", atts.getQName(i), atts.getValue(i));
        }
	}
	
	/**
	 * Metodo que se ejecuta cada vez que se termina un elemento
	 * @param url
	 * @param nombre
	 * @param nombreC
	 * @param atts
	 */
	public void endElement(String url, String nombre, String nombreC) {
		System.out.printf("\tFin del Elemento: %s %n", nombre);
	}
	
	/**
	 * Metodo que lee el contenido de los elementos
	 * @param ch
	 * @param inicio
	 * @param longitud
	 */
	public void characters(char[] ch, int inicio, int longitud) throws SAXException {
		String car = new String(ch, inicio, longitud);
		car = car.replaceAll("[\t\n]", "");
		if (!car.trim().isEmpty()) { System.out.printf("\t\tCaracteres: %s %n", car); }
	}
}