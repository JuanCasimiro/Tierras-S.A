package empresa;

public class Due�o extends Empleado{
	private int dineroaretirar; 
	public Due�o(String nom) {
		super(nom);
		
	}
	@Override
	public void cobrar() {
		int horastrabajadas = this.getHorastrabajadas();
		if(horastrabajadas >= 100) {
			Empresa empresa = this.getEmpresa();
			int totalACobrar = horastrabajadas * (empresa.valorHoraMaquina() / 5); 
			totalACobrar += dineroaretirar;
			empresa.transferirA(this, totalACobrar);	
		}
	}
	@Override
	public void trabajar(Trabajo t) {
		t.setCantidadHorasMaquina(0);
		t.setEstaBienRealizado(true);
	}
	public void revisarTrabajo(Trabajo t) {
		this.dineroaretirar = (t.getCosto()/3);
		if(!(t.estaBienRealizado())) {
			this.trabajar(t);
			this.sumarHoras(5);
		}
	}
	
}