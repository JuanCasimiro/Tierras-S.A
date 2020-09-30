package empresa;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
//posible lista in de pesos para tratarlo como objeto al dinero
	private String nombre;
	private int valorHoraMaquina;
	private int valorHoraCamion;
	//private Maquinista[] maquinistasdisponibles;
	List<Camionero> camionerosdisponibles;
	List<Maquinista> maquinistasdisponibles;
	private int dinero;
	private Duenio duenio;
	//constructor
	public Empresa(String nom, Duenio duenio, int hsmaquina, int hscamion) {
		this.valorHoraMaquina = hsmaquina;
		this.valorHoraCamion = hscamion;
		this.nombre = nom;
		this.dinero = 0;
		this.duenio = duenio;
		this.camionerosdisponibles = null;
		this.maquinistasdisponibles = null;
	}
	//setters
	public void contratar(Empleado e) {
		if (e instanceof Maquinista) {
			maquinistasdisponibles.add((Maquinista) e);
		}
		if (e instanceof Camionero) {
			camionerosdisponibles.add((Camionero) e);
		}
	}
	public void recibirPago(Trabajo t) {
		this.dinero += t.getCosto();
		this.pagarA(t.getTrabajadores());
		this.duenio.cobrar();
	}
	//getters
	public int valorHoraMaquina() {
		return valorHoraMaquina;
	}
	public int valorHoraCamion() {
		return valorHoraCamion;
	}
	//methods
	//pagar a los empleados se le pagar 100$ menos de lo que se cobra la hora, la cantidad d horas se revisa luego de cada trabajo
	private Empleado asignarEmpleado(String t) {
		Empleado empleado = null;
		if(t == "Maquinista") { 
			empleado = maquinistasdisponibles.get(0);
		}if (t == "Camionero") {
			empleado = camionerosdisponibles.get(0);
		}
		return empleado;
	}
	public void hacerPresupuesto(Trabajo t) {
		int costo = t.getCantidadHorasCamion() * this.valorHoraCamion() + t.getCantidadHorasMaquina() * this.valorHoraMaquina();
		t.setCosto(costo);
	}
	public void realizarTrabajo (Trabajo t) {
			
			Empleado camionero = asignarEmpleado("Camionero");
			Empleado maquinista = asignarEmpleado("Maquinista");
			camionero.trabajar(t);
			maquinista.trabajar(t);
			(this.duenio).revisarTrabajo(t);
			
	}
	// tranferir sea priv y empleado con metodo que diga sueldo pendiente



	private void pagarA(Empleado[] empleados) {
		for(int i = 0; i < empleados.length; i++){
			empleados[i].cobrar();
		}

		
	}
	public void transferirA(Empleado persona,int total) {
		this.dinero -= total;
		persona.recibirDinero(total);
	}
}
