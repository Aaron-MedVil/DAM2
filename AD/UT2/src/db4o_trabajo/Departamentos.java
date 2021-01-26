package db4o_trabajo;

public class Departamentos {

	private String dnombre, loc;
	private int dept_no;
	
	/**
	 * Constructor con parametros
	 * @param dnombre
	 * @param loc
	 * @param dept_no
	 */
	public Departamentos(String dnombre, String loc, int dept_no) {
		this.dnombre = dnombre;
		this.loc = loc;
		this.dept_no = dept_no;
	}
	
	/**
	 * Constructor sin parametros
	 */
	public Departamentos() {
		this.dnombre = null;
		this.loc = null;
		this.dept_no = 0;
	}
	
	/**
	 * Getter/Setter nombre
	 * @return
	 */
	public String getDnombre() { return dnombre; }
	public void setDnombre(String dnombre) { this.dnombre = dnombre; }
	
	/**
	 * Getter/Setter localizacion
	 * @return
	 */
	public String getLoc() { return loc; }
	public void setLoc(String loc) { this.loc = loc; }
	
	/**
	 * Getter/Setter nombre departamento
	 * @return
	 */
	public int getDept_no() { return dept_no; }
	public void setDept_no(int dept_no) { this.dept_no = dept_no; }
}