package DOMGenerator;

public class Index {

	/**
	 * Metodo principal que invoca los metodos para crear el fichero XML
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		
		DomGenerator dg = new DomGenerator();
		dg.generarDocumento();
		dg.generarXML();
	}
}