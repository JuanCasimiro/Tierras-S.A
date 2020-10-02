package empresa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Empresa {
//posible lista in de pesos para tratarlo como objeto al dinero
	private String nombre;
	private int valorHoraMaquina;
	private int valorHoraCamion;
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
	private Empleado asignarEmpleado(String clase) {
		Empleado empleado = null;
		if(clase.equals("Maquinista")) { 
			empleado = maquinistasdisponibles.get(0);
		}else{if (clase.equals("Camionero")) {
			empleado = camionerosdisponibles.get(0);
		}else throw new RuntimeException("tipo de empleado no valido");
		}
		return empleado;
	}
	public void hacerPresupuesto(Trabajo trabajo) {
		int costo = trabajo.getCantidadHorasCamion() * this.valorHoraCamion() + trabajo.getCantidadHorasMaquina() * this.valorHoraMaquina();
		trabajo.setCosto(costo);
	}
	public void realizarTrabajo (Trabajo trabajo) {
			
			Empleado camionero = asignarEmpleado("Camionero");
			Empleado maquinista = asignarEmpleado("Maquinista");
			camionero.trabajar(trabajo);
			maquinista.trabajar(trabajo);
			(this.duenio).revisarTrabajo(trabajo);
			
	}
	
	private void pagarA(Empleado[] empleados) {
		List<Empleado> empleaos = Arrays.asList(empleados);
		empleaos.forEach(empleado -> empleado.cobrar());
		
	}
	public void transferirA(Empleado persona,int total) {
		this.dinero -= total;
		persona.recibirDinero(total);
	}
	public int calculoTotalACobrar(Empleado empleado) {
		if (empleado instanceof Maquinista) {
			return empleado.getHorastrabajadas() * (this.valorHoraMaquina() / 5);
		}
		if (empleado instanceof Camionero) {
			return empleado.getHorastrabajadas() * (this.valorHoraCamion() / 5);
		}
		return 0;
	}
}
