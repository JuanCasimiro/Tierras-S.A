package empresa;

public class Camionero extends Empleado{

	public Camionero(String nom) {
		super(nom);
	}
	@Override
	public void trabajar(Trabajo trabajo) {
		
		this.sumarHoras(trabajo.getCantidadHorasCamion());
		trabajo.setCantidadHorasCamion(0);
		trabajo.setEstaBienRealizado(true);
		System.out.println(this.getNombre() + " usa el camion");
		
	}
	@Override
	public void cobrar() {
		int horasTrabajadas = this.getHorastrabajadas();
		if(horasTrabajadas >= 100) {
			Empresa empresa = this.getEmpresa();
			int totalACobrar = empresa.calculoTotalACobrar(this); 
			empresa.transferirA(this, totalACobrar);
			System.out.println(this.getNombre() + " cobro");
			this.setHorastrabajadas(0);
		}else System.out.println(this.getNombre() + " no posee suficientes horas para cobrar");
	}
}
