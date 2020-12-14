package DOMGenerator;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class CrearEmpleadoXML {

	/**
	 * Lee el fichero de datos e inserta los datos leidos en el fichero XML
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		// Abrimos el fichero de datos
		File fichero = new File("./Resources/empleados.dat");
		RandomAccessFile file = new RandomAccessFile(fichero, "r");
		
		// Creamos las variables del fichero de datos
		int id, dep, posicion = 0;
		Double salario;
		char apellido[] = new char[10], aux;
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
			
			// Creamos el constructor para generar el fichero XML
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();
			Document document = implementation.createDocument(null, "Empleados", null);
			document.setXmlVersion("1.0");
			
			// Leemos el fichero empleados.dat
			for(;;) {
				
				// Buscamos la posicion que queramos leer
				file.seek(posicion);
				
				// Obtenemos el id del registro
				id = file.readInt();
				
				// Obtenemos el apellido del registro
				for (int i = 0; i < apellido.length; i++) {
					aux = file.readChar();
					apellido[i] = aux;
				}
				String apellidos = new String(apellido);
				
				// Obtenemos el departamento del registro
				dep = file.readInt();
				
				// Obtenemos el salario del departamento
				salario = file.readDouble();
				
				// Si el id es mayor a 0 insertamos los datos en el fichero XML
				if (id > 0) {
					
					// Creamos el nodo del documento
					Element raiz = document.createElement("empleado");
					document.getDocumentElement().appendChild(raiz);
					
					// Añadimos el id al documento
					CrearElemento("id", Integer.toString(id), raiz, document);
					
					// Añadimos el apellido al documento
					CrearElemento("apellido", apellidos.trim(), raiz, document);
					
					// Añadimos el departamento al documento
					CrearElemento("departamento", Integer.toString(dep), raiz, document);
					
					// Añadimos el salario al documento
					CrearElemento("salario", Double.toString(salario), raiz, document);
				}
				
				// Avanzamos la posicion al siguiente registro
				posicion = posicion + 36;
				
				// Comprobamos si hemos llegado al ultimo registro
				if (file.getFilePointer() == file.length()) break;
			}
			
			// Creamos el contenido del fichero en source y el destino en result
			Source source = new DOMSource(document);
			Result result = new StreamResult(new File("./Resources/empleados.xml"));
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(source,  result);
		} catch (Exception e) { System.err.println("Error: " + e); }
		
		// Cerramos el fichero de datos
		file.close();
	}
	
	
	/**
	 * Inserta los datos leidos del fichero de datos en el fichero XML
	 * @param datoEmple
	 * @param valor
	 * @param raiz
	 * @param document
	 */
	static void CrearElemento(String datoEmple, String valor, Element raiz, Document document) {
		
		Element elem = document.createElement(datoEmple);
		Text text = document.createTextNode(valor);
		raiz.appendChild(elem);
		elem.appendChild(text);
	}
}