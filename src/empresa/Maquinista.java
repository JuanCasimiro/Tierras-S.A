package empresa;

public class Maquinista extends Empleado{

	public Maquinista(String nom) {
		super(nom);
	}
	@Override
	public void trabajar(Trabajo t) {
		
		int cantidadHorasMaquina = t.getCantidadHorasMaquina();
		if(cantidadHorasMaquina >= 30) {
			//el empleado se cansa y hace algo mal, por ende entre el trabajo aun le faltan 5 horas por lo que rompio
			//esta horas se le descuentan de las pendientes a cobrar
			t.setCantidadHorasMaquina(5);
			this.sumarHoras(cantidadHorasMaquina - 5);
			t.setEstaBienRealizado(false);
		}else {
			t.setCantidadHorasMaquina(0);
			this.sumarHoras(cantidadHorasMaquina);
			t.setEstaBienRealizado(true);
		}
		
		
		System.out.print(this.getNombre() + " usa la maquina");
		
	}	
	@Override
	public void cobrar() {
		
		int horastrabajadas = this.getHorastrabajadas();
		if(horastrabajadas >= 100) {
			Empresa empresa = this.getEmpresa();
			int totalACobrar = horastrabajadas * (empresa.valorHoraMaquina() / 5); 
			empresa.transferirA(this, totalACobrar);
		}
	}
	
}
