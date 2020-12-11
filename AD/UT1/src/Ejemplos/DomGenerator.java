package Ejemplos;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DomGenerator {

	private Document documentoXML;

	/**
	 * Constructor que genera la instancia del DOM
	 * 
	 * @throws Exception
	 */
	public DomGenerator() throws Exception {
		DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factoria.newDocumentBuilder();
		documentoXML = builder.newDocument();
	}

	/**
	 * Genera los datos del fichero
	 */
	private void generarDocumento() {
		
		// Element alumnos = null, alumno = null, nombre = null, apellido = null;

		/* ============================== ALUMNO 1 ============================== */
		
		// Genera la etiqueta alumnos
		Element alumnos = documentoXML.createElement("alumnos");
		documentoXML.appendChild(alumnos);

		// Crea una etiqueta alumno para el primer alumno
		Element alumno = documentoXML.createElement("alumno");
		alumnos.appendChild(alumno);
		alumno.setAttribute("codigo", "AL001");

		// Genera la etiqueta nombre del primer alumno
		Element nombre = documentoXML.createElement("nombre");
		alumno.appendChild(nombre);
		nombre.appendChild(documentoXML.createTextNode("Marcelino"));

		// Genera la etiqueta apellido del primer alumno
		Element apellido = documentoXML.createElement("apellido");
		alumno.appendChild(apellido);
		nombre.appendChild(documentoXML.createTextNode("Pan y Vino"));

		/* ============================== ALUMNO 2 ============================== */
		
		// Crea la etiqueta alumno para el segundo alumno
		alumno = documentoXML.createElement("alumno");
		alumnos.appendChild(alumno);
		alumno.setAttribute("codigo", "AL002");

		// Genera la etiqueta nombre del segundo alumno
		nombre = documentoXML.createElement("nombre");
		alumno.appendChild(nombre);
		nombre.appendChild(documentoXML.createTextNode("Magdalena"));

		// Genera la etiqueta apellido del segundo alumno
		apellido = documentoXML.createElement("apellido");
		alumno.appendChild(apellido);
		nombre.appendChild(documentoXML.createTextNode("Bonilla"));
		
		/* ============================== ALUMNO 3 ============================== */
		
		// Crea la etiqueta alumno para el tercer alumno
		alumno = documentoXML.createElement("alumno");
		alumnos.appendChild(alumno);
		alumno.setAttribute("codigo", "AL003");

		// Genera la etiqueta nombre del tercer alumno
		nombre = documentoXML.createElement("nombre");
		alumno.appendChild(nombre);
		nombre.appendChild(documentoXML.createTextNode("Elena"));

		// Genera la etiqueta apellido del tercer alumno
		apellido = documentoXML.createElement("apellido");
		alumno.appendChild(apellido);
		nombre.appendChild(documentoXML.createTextNode("Nito"));
	}
	
	/**
	 * Genera el documento XML con los datos que hemos creado en la funcion generarDocumento()
	 * @throws Exception
	 */
	public void generarXML() throws Exception {
		
		// Creamos el origen
		Source origen = new DOMSource(documentoXML);
		
		// Creamos el destino
		File ruta = new File("./src/Ejemplos/Res/alumnos.xml");
		FileWriter fw = new FileWriter(ruta);
		PrintWriter pw = new PrintWriter(fw);
		Result resultado = new StreamResult(pw);
	}
}
