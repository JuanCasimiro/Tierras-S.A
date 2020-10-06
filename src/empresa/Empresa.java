package empresa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Empresa {
//posible lista in de pesos para tratarlo como objeto al dinero
	private String nombre;
	private int valorHoraMaquina;
	private int valorHoraCamion;
	List<Camionero> camionerosDisponibles = new ArrayList<Camionero>();
	List<Maquinista> maquinistasDisponibles = new ArrayList<Maquinista>();
	private int dinero;
	private Duenio duenio;
	//constructor
	public Empresa(String nom, Duenio duenio, int hsMaquina, int hsCamion) {
		this.valorHoraMaquina = hsMaquina;
		this.valorHoraCamion = hsCamion;
		this.nombre = nom;
		this.dinero = 0;
		this.duenio = duenio;
	}
	//setters
	public void contratar(Empleado empleado) {
		if (empleado instanceof Maquinista) {
			maquinistasDisponibles.add((Maquinista) empleado);
			empleado.setEmpresa(this);
		}
		if (empleado instanceof Camionero) {
			camionerosDisponibles.add((Camionero) empleado);
			empleado.setEmpresa(this);
		}
	}
	public void recibirPago(Trabajo trabajo) {
		this.dinero += trabajo.getCosto();
		this.pagarA(trabajo.getTrabajadores());
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
			empleado = maquinistasDisponibles.get(0);
		}else{if (clase.equals("Camionero")) {
			empleado = camionerosDisponibles.get(0);
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
			System.out.println("el trabajo esta realizado satisfactoriamente");
			
	}
	
	private void pagarA(List<Empleado> empleados) {
		empleados.forEach(empleado -> empleado.cobrar());
		
	}
	public void transferirA(Empleado persona,float total) {
		this.dinero -= total;
		persona.recibirDinero(total);
	}
	public int calculoTotalACobrar(Empleado empleado) {
		if (empleado instanceof Maquinista) {
			int total = (empleado.getHorastrabajadas() * (this.valorHoraMaquina() / 5));
			return total;
		}
		if (empleado instanceof Camionero) {
			
			int total= (empleado.getHorastrabajadas() * (this.valorHoraMaquina() / 5));
			return total;
		}
		return 0;
	}
}
