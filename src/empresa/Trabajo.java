package empresa;

public class Trabajo {
	
	private int cantidadHorasMaquina;
	private int cantidadHorasCamion;
	private int costo;
	private boolean estaBienRealizado;
	private Empleado[] trabajadores;
	//constructor
	public Trabajo(int horascam, int horasmaq, int presu) {
		cantidadHorasMaquina = horasmaq;
		cantidadHorasCamion = horascam;
		costo = 0;
		estaBienRealizado = false;
		trabajadores = null;
	}
	public Empleado[] getTrabajadores() {
		return trabajadores;
	}
	public void setTrabajadores(Empleado[] trabajadores) {
		this.trabajadores = trabajadores;
	}
	//Setters

	public void setCantidadHorasMaquina(int cantidadHorasMaquina) {
		this.cantidadHorasMaquina = cantidadHorasMaquina;
	}
	public void setCantidadHorasCamion(int cantidadHorasCamion) {
		this.cantidadHorasCamion = cantidadHorasCamion;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}
	//getters 
	public boolean estaBienRealizado() {
		return this.estaBienRealizado;
	}
	public int getCosto() {
		return this.costo;
	}
	public int getCantidadHorasMaquina() {
		return this.cantidadHorasMaquina;
	}
	public int getCantidadHorasCamion() {
		return this.cantidadHorasCamion;
	}
	public void setEstaBienRealizado(boolean estaBienRealizado) {
		this.estaBienRealizado = estaBienRealizado;
		
	}

}
