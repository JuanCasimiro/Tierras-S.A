package empresa;

public class Cliente {

	private int presupuesto;
	private Trabajo trabajo;
	//falta hacer constructor
	
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
		e.recibirPago(t);
	}
	//ofrecer trabajo el presupuesto menor gana (paja implementarlo)
	
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
			}
		}
	}
}
