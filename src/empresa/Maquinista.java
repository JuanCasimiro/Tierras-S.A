package empresa;

public class Maquinista extends Empleado{

	public Maquinista(String nom) {
		super(nom);
	}
	@Override
	public void trabajar(Trabajo trabajo) {
		
		int cantidadHorasMaquina = trabajo.getCantidadHorasMaquina();
		if(cantidadHorasMaquina >= 30) {
			//el empleado se cansa y hace algo mal, por ende entre el trabajo aun le faltan 5 horas por lo que rompio
			//esta horas se le descuentan de las pendientes a cobrar
			System.out.print("el maquinista se confundio y rompio algo aun quedan 5 horas de trabajo");
			trabajo.setCantidadHorasMaquina(5);
			this.sumarHoras(cantidadHorasMaquina - 5);
			trabajo.setEstaBienRealizado(false);
		}else {
			trabajo.setCantidadHorasMaquina(0);
			this.sumarHoras(cantidadHorasMaquina);
			trabajo.setEstaBienRealizado(true);
		}
		
		
		System.out.print(this.getNombre() + " usa la maquina");
		
	}	
	@Override
	public void cobrar() {
		
		int horastrabajadas = this.getHorastrabajadas();
		if(horastrabajadas >= 100) {
			Empresa empresa = this.getEmpresa();
			//calculo a empresa
			int totalACobrar = empresa.calculoTotalACobrar(this); 
			empresa.transferirA(this, totalACobrar);
			this.setHorastrabajadas(0);
		}else throw new RuntimeException("no posee suficientes horas para cobrar");
	}

	
}
