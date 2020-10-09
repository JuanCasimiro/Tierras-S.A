package empresa;

public class Cliente {

	private int presupuesto;
	private Trabajo trabajo;

	public Cliente(Trabajo trabajo, int presupuesto) {
		this.presupuesto = presupuesto;
		this.trabajo = trabajo;
	} 
	
	public int getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}
	public Trabajo getTrabajo() {
		return trabajo;
	}
	public void setTrabajo(Trabajo trabajo) {
		this.trabajo = trabajo;
	}

	//pagar
	private void pagar(Empresa empresa, Trabajo trabajo) {
		this.presupuesto -= trabajo.getCosto();
		System.out.println("el cliente realiza el pago");
		empresa.recibirPago(trabajo);
	}
	
	//pedir presupuesto
	public void pedirPresupuesto(Empresa empresa) {
		empresa.hacerPresupuesto(trabajo);
	}
	//verificar que posee suficiente dinero
	private boolean puedePagarlo(Empresa empresa) {
		this.pedirPresupuesto(empresa);
		return (this.presupuesto >= (this.trabajo).getCosto());
	}
	//contratar empresa
	public void contratarEmpresa(Empresa empresa) {
		Trabajo t = trabajo;
		if(!(t.equals(null))) {
			if(this.puedePagarlo(empresa)) {
				empresa.realizarTrabajo(t);
				if (t.estaBienRealizado()) {
					this.pagar(empresa, t);
					this.trabajo = null;
				}
			}else throw new RuntimeException("no posee suficiente dinero para pagar el proyecto");
		}else throw new RuntimeException("no posee un trabajo para realizar");
	}	
}
