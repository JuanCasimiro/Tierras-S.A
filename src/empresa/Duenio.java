package empresa;

public class Duenio extends Empleado{
	private int dineroARetirar; 
	public Duenio(String nom) {
		super(nom);
		this.dineroARetirar = 0;
	}
	public void cobrar() {
		int horasTrabajadas = this.getHorastrabajadas();
		if(horasTrabajadas >= 100) {
			Empresa empresa = this.getEmpresa();
			int totalACobrar = horasTrabajadas * (empresa.valorHoraMaquina() / 5); 
			totalACobrar = this.dineroARetirar;
			empresa.transferirA(this, totalACobrar);
			this.dineroARetirar = 0;
		}
	}
	public void trabajar(Trabajo trabajo) {
		trabajo.setCantidadHorasMaquina(0);
		trabajo.setEstaBienRealizado(true);
	}
	public void revisarTrabajo(Trabajo trabajo) {
		this.dineroARetirar += (trabajo.getCosto()/3);
		if(!(trabajo.estaBienRealizado())) {
			this.trabajar(trabajo);
			this.sumarHoras(5);
		}
	}
	
}