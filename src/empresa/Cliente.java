package empresa;

public class Cliente {

	private int presupuesto;
	private Trabajo trabajo;

	public Cliente(Trabajo trabajo, int presupuesto){
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
	private void pagar(Empresa e, Trabajo t) {
		this.presupuesto -= t.getCosto();
		e.recibirPago(t);
	}
	
	//pedir presupuesto
	public void pedirPresupuesto(Empresa e) {
		e.hacerPresupuesto(trabajo);
	}
	//verificar que posee suficiente dinero
	private boolean puedePagarlo(Empresa e) {
		this.pedirPresupuesto(e);
		return (this.presupuesto >= (this.trabajo).getCosto());
	}
	//contratar empresa
	public void contratarEmpresa(Empresa e) {
		Trabajo t = trabajo;
		if(this.puedePagarlo(e)) {
			e.realizarTrabajo(t);
			if (t.estaBienRealizado()) {
				this.pagar(e, t);
			}//else Exception  "no posee suficiente dinero"
		}
	}
}
