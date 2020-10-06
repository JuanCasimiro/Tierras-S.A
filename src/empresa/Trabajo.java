package empresa;

import java.util.ArrayList;
import java.util.List;

public class Trabajo {
	
	private int cantidadHorasMaquina;
	private int cantidadHorasCamion;
	private int costo;
	private boolean estaBienRealizado;
	private List<Empleado> trabajadores = new ArrayList<Empleado>();
	//constructor
	public Trabajo(int horascam, int horasmaq) {
		cantidadHorasMaquina = horasmaq;
		cantidadHorasCamion = horascam;
		costo = 0;
		estaBienRealizado = false;
	}

	//Setters
	public void setTrabajadores(Empleado trabajador) {
		this.trabajadores.add(trabajador);
	}

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
	public List<Empleado> getTrabajadores() {
		return trabajadores;
	}
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
