package Ejemplos;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DomGenerator {
	
	private Document documentoXML;
	
	/**
	 * Constructor que genera la instancia del DOM
	 * @throws Exception
	 */
	public DomGenerator() throws Exception {
		DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factoria.newDocumentBuilder();
        documentoXML = builder.newDocument();
	}
	
	private void generarDocumento() {
		
		// Genera la etiqueta alumnos
		Element alumnos = documentoXML.createElement("alumnos");
		documentoXML.appendChild(alumnos);
		
		// Crea una etiqueta dentro de alumnos
		Element alumno = documentoXML.createElement("alumno");
		alumnos.appendChild(alumno);
		alumno.setAttribute("codigo", "AL001");
		
		// Genera el apellido nombre del alumno
		Element nombre = documentoXML.createElement("nombre");
		alumno.appendChild(nombre);
		nombre.appendChild(documentoXML.createTextNode("Marcelino"));
		
		// Genera el atributo apellido
		Element apellido = documentoXML.createElement("apellido");
		alumno.appendChild(apellido);
		nombre.appendChild(documentoXML.createTextNode("Pan y Vino"));
	}
}
