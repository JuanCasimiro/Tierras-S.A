package empresa;

public class Empresa {
//posible lista in de pesos para tratarlo como objeto al dinero
	private String nombre;
	private int valorHoraMaquina;
	private int valorHoraCamion;
	private Maquinista[] maquinistasdisponibles;
	private Camionero[] camionerosdisponibles;
	private int dinero;
	private Due�o due�o;
	//constructor
	public Empresa(String nom, Due�o due�o, int hsmaquina, int hscamion) {
		this.valorHoraMaquina = hsmaquina;
		this.valorHoraCamion = hscamion;
		this.nombre = nom;
		this.dinero = 0;
		this.due�o = due�o;
	}
	//setters
	public void recibirPago(Trabajo t) {
		this.dinero += t.getCosto();
		this.pagarA(t.getTrabajadores());
		this.due�o.cobrar();
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
			empleado = maquinistasdisponibles[0];
		}if (t == "Camionero") {
			empleado = camionerosdisponibles[0];
		}
		return empleado;
	}
	public void hacerPresupuesto(Trabajo t) {
		int costo = t.getCantidadHorasCamion() * this.valorHoraCamion() + t.getCantidadHorasMaquina() * this.valorHoraMaquina();
		t.setCosto(costo);
	}
	public void realizarTrabajo (Trabajo t) {
			
			this.hacerPresupuesto(t);
			Empleado camionero = asignarEmpleado("Camionero");
			Empleado maquinista = asignarEmpleado("Maquinista");
			camionero.trabajar(t);
			maquinista.trabajar(t);
			(this.due�o).revisarTrabajo(t);
			
	}
	// tranferir sea priv y empleado con metodo que diga sueldo pendiente
	private void pagarA(Empleado[] trabajadores) {
		// empleado.cobrar
		
	}
	public void transferirA(Empleado e,int total) {
		this.dinero -= total;
		e.recibirDinero(total);
	}
}
