package empresa;

public class Duenio extends Empleado{
	private int dineroaretirar; 
	public Duenio(String nom) {
		super(nom);
		
	}
	public void cobrar() {
		int horastrabajadas = this.getHorastrabajadas();
		if(horastrabajadas >= 100) {
			Empresa empresa = this.getEmpresa();
			int totalACobrar = horastrabajadas * (empresa.valorHoraMaquina() / 5); 
			totalACobrar += dineroaretirar;
			empresa.transferirA(this, totalACobrar);	
		}
	}
	public void trabajar(Trabajo trabajo) {
		trabajo.setCantidadHorasMaquina(0);
		trabajo.setEstaBienRealizado(true);
	}
	public void revisarTrabajo(Trabajo trabajo) {
		this.dineroaretirar = (trabajo.getCosto()/3);
		if(!(trabajo.estaBienRealizado())) {
			this.trabajar(trabajo);
			this.sumarHoras(5);
		}
	}
	
}