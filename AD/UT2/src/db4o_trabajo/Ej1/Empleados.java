package db4o_trabajo.Ej1;

public class Empleados {

	private String apellido, oficio, fecha_alt;
	private int emp_no, dir, salario, comision, dept_no;
	
	/**
	 * Constructor sin paramtros
	 */
	public Empleados() {
		this.apellido = null;
		this.oficio = null;
		this.fecha_alt = null;
		this.emp_no = 0;
		this.dir = 0;
		this.salario = 0;
		this.comision = 0;
		this.dept_no = 0;
	}
	

	/**
	 * Clase constructor con parametros
	 * @param apellido
	 * @param oficio
	 * @param fecha_alt
	 * @param emp_no
	 * @param dir
	 * @param salario
	 * @param comision
	 * @param dept_no
	 */
	public Empleados(String apellido, String oficio, String fecha_alt, int emp_no, int dir, int salario, int comision, int dept_no) {
		this.apellido = apellido;
		this.oficio = oficio;
		this.fecha_alt = fecha_alt;
		this.emp_no = emp_no;
		this.dir = dir;
		this.salario = salario;
		this.comision = comision;
		this.dept_no = dept_no;
	}
	
	/**
	 * Getter/Setter apellido
	 * @return
	 */
	public String getApellido() { return apellido; }
	public void setApellido(String apellido) { this.apellido = apellido; }
	
	/**
	 * Getter/Setter oficio
	 * @return
	 */
	public String getOficio() { return oficio; }
	public void setOficio(String oficio) { this.oficio = oficio; }
	
	/**
	 * Getter/Setter Fecha alta
	 * @return
	 */
	public String getFecha_alt() { return fecha_alt; }
	public void setFecha_alt(String fecha_alt) { this.fecha_alt = fecha_alt; }
	
	/**
	 * Getter/Setter numero empleado
	 * @return
	 */
	public int getEmp_no() { return emp_no; }
	public void setEmp_no(int emp_no) { this.emp_no = emp_no; }
	
	/**
	 * Getter/Setter direccion
	 * @return
	 */
	public int getDir() { return dir; }
	public void setDir(int dir) { this.dir = dir; }
	
	/**
	 * Getter/Setter salario
	 * @return
	 */
	public int getSalario() { return salario; }
	public void setSalario(int salario) { this.salario = salario; }
	
	/**
	 * Getter/Setter Comision
	 * @return
	 */
	public int getComision() { return comision; }
	public void setComision(int comision) { this.comision = comision; }
	
	/**
	 * Getter/Setter numero departamento
	 * @return
	 */
	public int getDept_no() { return dept_no; }
	public void setDept_no(int dept_no) { this.dept_no = dept_no; }
}
