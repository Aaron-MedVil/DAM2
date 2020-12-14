package DOMGenerator;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LeerEmpleadoXML {

	/**
	 * Metodo para leer el fichero XML de empleados
	 * @param args
	 */
	public static void main(String[] args) {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
			
			// Crea e constructor para leer el fichero XML
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File("./Resources/empleados.xml"));
			document.getDocumentElement().normalize();
			
			System.out.printf("Elemento raiz: %s %n", document.getDocumentElement().getNodeName());
			
			// Crea una lista con todos los nodos empleado
			NodeList empleados = document.getElementsByTagName("empleado");
			System.out.printf("Nodos empleado a recorrer: %d %n", empleados.getLength());
			
			// Recorremos la lista de empleados
			for (int i = 0; i < empleados.getLength(); i++) {
				
				// Separador de empleados
				System.out.println("--------------------------------------------------------------------------");
				
				// Obtenemos el nodo actual
				Node emple = empleados.item(i);
				
				// Comprueba el tipo de nodo
				if (emple.getNodeType() == Node.ELEMENT_NODE) {
					
					// Obtiene los elementos del nodo
					Element elemento = (Element) emple;
					System.out.printf("ID: %s %n", elemento.getElementsByTagName("id").item(0).getTextContent());
					System.out.printf(" * Apellido => %s %n", elemento.getElementsByTagName("apellido").item(0).getTextContent());
					System.out.printf(" * Departamento => %s %n", elemento.getElementsByTagName("departamento").item(0).getTextContent());
					System.out.printf(" * Salario => %s %n", elemento.getElementsByTagName("salario").item(0).getTextContent());
				}
			}
		} catch (Exception e) { e.printStackTrace(); }
	}
}