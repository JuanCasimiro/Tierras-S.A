package empresa;

public abstract class Empleado {
	private String nombre;
	private float dinero;
	private Empresa empresa;
	private int horasTrabajadas;
	
	//horas trabajadas a las 100 la mpresa le paga
	public Empleado(String nom) {
		this.nombre = nom;
		this.dinero = 0;
		this.empresa = null;
		this.horasTrabajadas = 0;
	}
	//geters
	public Empresa getEmpresa() {
		return empresa;
	}
	public float getDinero() {
		return this.dinero;
	}
	public String getNombre() {
		return this.nombre;
	}
	public int getHorastrabajadas() {
		return horasTrabajadas;
	}
	//setters
	public void setHorastrabajadas(int cantidad) {
		this.horasTrabajadas = cantidad;
	}	
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public void recibirDinero(float dinero) {
		this.dinero += dinero;
	}
	public void sumarHoras(int horastrabajadas) {
		this.horasTrabajadas += horastrabajadas;
	}
	//methods
	public abstract void trabajar(Trabajo t);
	public abstract void cobrar();
}