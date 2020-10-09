package empresa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Empresa {
//posible lista in de pesos para tratarlo como objeto al dinero
	private String nombre;
	private int valorHoraMaquina;
	private int valorHoraCamion;
	private List<Camionero> camionerosDisponibles;
	private List<Maquinista> maquinistasDisponibles;
	private int dinero;
	private Duenio duenio;
	
	//constructor
	public Empresa(String nom, Duenio duenio, int hsMaquina, int hsCamion) {
		this.valorHoraMaquina = hsMaquina;
		this.valorHoraCamion = hsCamion;
		this.nombre = nom;
		this.dinero = 0;
		this.duenio = duenio;
		camionerosDisponibles = new ArrayList<Camionero>();
		maquinistasDisponibles = new ArrayList<Maquinista>();
		duenio.setEmpresa(this);
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
	public void despedir(Empleado empleado) {
		if (empleado instanceof Maquinista) {
			maquinistasDisponibles.removeIf(x -> x.getNombre().equalsIgnoreCase(empleado.getNombre()));
			}
		
		if (empleado instanceof Camionero) {
			camionerosDisponibles.removeIf(x -> x.getNombre().equalsIgnoreCase(empleado.getNombre()));
		}
	}
	public void recibirPago(Trabajo trabajo) {
		this.dinero += trabajo.getCosto();
		this.pagarA(trabajo.getTrabajadores());
		this.duenio.cobrar();
	}
	//getters
	public List<Camionero> getCamionerosDisponibles() {
		return camionerosDisponibles;
	}
	public List<Maquinista> getMaquinistasDisponibles() {
		return maquinistasDisponibles;
	}
	public int valorHoraMaquina() {
		return valorHoraMaquina;
	}
	public int getDinero() {
		return dinero;
	}
	public int valorHoraCamion() {
		return valorHoraCamion;
	}
	//methods
	//pagar a los empleados se le pagar 100$ menos de lo que se cobra la hora, la cantidad d horas se revisa luego de cada trabajo
	//asignar los empleados ya los ingresa a la lista de quienes los trabajaron 
	
	private void asignarEmpleados(Trabajo trabajo) {
		if(trabajo.getCantidadHorasCamion() > 0) {
			if (camionerosDisponibles.isEmpty() ) {throw new RuntimeException("no hay camioneros disponibles");}
			else {
			Empleado empleado = camionerosDisponibles.get(0);
			trabajo.setTrabajadores(empleado);
			}
		}
		if(trabajo.getCantidadHorasMaquina() > 0) {
			if (maquinistasDisponibles.isEmpty()) {throw new RuntimeException("no hay maquinistas disponibles");}
			else {
			Empleado empleado = maquinistasDisponibles.get(0);
			trabajo.setTrabajadores(empleado);
			}
		}
	}
	
	/*private Empleado asignarEmpleado(String clase) {
		Empleado empleado = null;
		if(clase.equals("Maquinista")) { 
			if (maquinistasDisponibles.isEmpty()) {throw new RuntimeException("no hay maquinistas disponibles");}
			empleado = maquinistasDisponibles.get(0);
		}
		if (clase.equals("Camionero")) {
			if (camionerosDisponibles.isEmpty()) {throw new RuntimeException("no hay camioneros disponibles");}
			empleado = camionerosDisponibles.get(0);
			
		}else throw new RuntimeException("tipo de empleado no valido");
		
		return empleado;
	}*/
	public void hacerPresupuesto(Trabajo trabajo) {
		int costo = trabajo.getCantidadHorasCamion() * this.valorHoraCamion() + trabajo.getCantidadHorasMaquina() * this.valorHoraMaquina();
		trabajo.setCosto(costo);
	}
	public void realizarTrabajo (Trabajo trabajo) {
			asignarEmpleados(trabajo);
			hacerQueLosEmpleadosTrabajen(trabajo);
			//empleados.forEach(empleado -> empleado.trabajar(trabajo));
			(this.duenio).revisarTrabajo(trabajo); 
			System.out.println("el trabajo esta realizado satisfactoriamente");
			
	}
	private void hacerQueLosEmpleadosTrabajen(Trabajo trabajo) {

		trabajo.getTrabajadores().forEach(x -> x.trabajar(trabajo));

	}
	
	private void pagarA(List<Empleado> empleados) {
		empleados.forEach(empleado -> empleado.cobrar());
		
	}
	public void transferirA(Empleado persona,float total) {
		this.dinero -= total;
		persona.recibirDinero(total);
	}
	public int calculoTotalACobrar(Empleado empleado) {
		if (empleado instanceof Maquinista || empleado instanceof Duenio) {
			int total = (empleado.getHorastrabajadas() * (this.valorHoraMaquina() / 5));
			return total;
		}
		if (empleado instanceof Camionero) {
			
			int total= (empleado.getHorastrabajadas() * (this.valorHoraCamion() / 5));
			return total;
		}
		return 0;
	}
}
