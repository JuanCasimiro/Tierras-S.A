package empresa;

public class Camionero extends Empleado{

	public Camionero(String nom) {
		super(nom);
	}
	@Override
	public void trabajar(Trabajo trabajo) {
		
		this.sumarHoras(trabajo.getCantidadHorasCamion());
		trabajo.setCantidadHorasCamion(0);
		System.out.print(this.getNombre() + " usa el camion");
	}
	@Override
	public void cobrar() {
		int horastrabajadas = this.getHorastrabajadas();
		if(horastrabajadas >= 100) {
			Empresa empresa = this.getEmpresa();
			int totalACobrar = horastrabajadas * (empresa.valorHoraCamion() / 5); 
			empresa.transferirA(this, totalACobrar);
			this.setHorastrabajadas(0);
		}else throw new RuntimeException("no posee suficientes horas para cobrar");
	}
}
