package empresa;

public abstract class Empleado {
	private String nombre;
	private int dinero;
	private Empresa empresa;
	private int horastrabajadas;
	
	//horas trabajadas a las 100 la mpresa le paga
	public Empleado(String nom) {
		this.nombre = nom;
		this.dinero = 0;
		this.empresa = null;
		this.horastrabajadas = 0;
	}
	//geters
	public Empresa getEmpresa() {
		return empresa;
	}
	public int getDinero() {
		return this.dinero;
	}
	public String getNombre() {
		return this.nombre;
	}
	public int getHorastrabajadas() {
		return horastrabajadas;
	}
	//setters
	public void setHorastrabajadas(int cantidad) {
		this.horastrabajadas = cantidad;
	}	
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public void recibirDinero(int din) {
		this.dinero += din;
	}
	public void sumarHoras(int horastrabajadas) {
		this.horastrabajadas += horastrabajadas;
	}
	//methods
	public abstract void trabajar(Trabajo t);
	public abstract void cobrar();
}