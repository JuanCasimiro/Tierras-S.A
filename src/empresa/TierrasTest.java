package empresa;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TierrasTest {
	
	Maquinista maquinista;
	Camionero camionero;
	Trabajo trabajo;
	Cliente cliente;
	Duenio duenio;
	Empresa empresa;
    @Before
	public void before() {
    	maquinista  = new Maquinista("guillermo");
    	camionero   = new Camionero("pepe");
    	trabajo     = new Trabajo(10, 10);
    	cliente     = new Cliente(trabajo, 10000000);
    	duenio      = new Duenio("valen");
    	empresa     = new Empresa("volpi",duenio, 200, 100);
  
    	empresa.contratar(camionero);
    	empresa.contratar(maquinista);
    	System.out.println("aa");
    }
 
	@Test
	public void testClienteHaceTrabajoSinSuficienteDinero() {	
		cliente.setPresupuesto(10);
		try {
			cliente.contratarEmpresa(empresa);
			fail();
			}catch(RuntimeException e){
			if (!(e.getMessage().matches("no posee suficiente dinero para pagar el proyecto") )) {
				fail();
			}	
		};
		
	}
	
	//empresa no tiene maquinistas
	@Test
	public void contratanEmpresaSinMaquinista() {
	try {
		empresa.despedir(maquinista);
		cliente.contratarEmpresa(empresa);
		fail();
	} catch (RuntimeException e) {
		if(!(e.getMessage().matches("no hay maquinistas disponibles"))) {
			fail();
		}
	}	
	}

	//empresa no tiene camioneros
	@Test
	public void contratanEmpresaSinCamionero() {
	try {
		empresa.despedir(camionero);
		cliente.contratarEmpresa(empresa);
		fail();
	} catch (RuntimeException e) {
		if(!(e.getMessage().matches("no hay camioneros disponibles"))) {
			fail();
		}
	}	
	}

	//cliente contrata empresa con el presupuesto necesario
	@Test
	public void clienteContrataEmpresaConElPresupuesto() {
		cliente.contratarEmpresa(empresa);
		assertTrue(trabajo.estaBienRealizado());
	}

	//trabajo de 30 o mas hora mal echo por el maquinista
	@Test
	public void trabajoMalHechoPorMasDe30Horas () {
	trabajo.setCantidadHorasMaquina(35);
	maquinista.trabajar(trabajo);
	assertFalse(trabajo.estaBienRealizado());
	}

	//empleados reciben pagos
	@Test
	public void maquinistaCobra() {
		trabajo.setCantidadHorasMaquina(106);
		empresa.recibirPago(trabajo);
	maquinista.trabajar(trabajo);
	int esperado = empresa.calculoTotalACobrar(maquinista);
	maquinista.cobrar();
	int dinero =  (int) maquinista.getDinero();
	assertEquals(esperado, dinero);
	}
	//empleados cobran y las horas de trabajo quedan en 0
	@Test
	public void despuesDeCobrarSeteaHorasA0() {
	trabajo.setCantidadHorasCamion(100);
	camionero.trabajar(trabajo);
	camionero.cobrar();
	assertEquals(0,camionero.getHorastrabajadas());
	}
	
	//contratar empleados
	@Test
	public void empresaContrataEmpleado() {
		assertTrue(empresa.getCamionerosDisponibles().contains(camionero) && empresa.getMaquinistasDisponibles().contains(maquinista));
	}
	
	//empresa recibe le pago
	@Test
	public void empresaRecibePagoPorTabajoDondeAmbosEmpleadosCobran() {
	trabajo.setCantidadHorasCamion(100);
	trabajo.setCantidadHorasMaquina(105);
	cliente.pedirPresupuesto(empresa);
	int dineroEsperado = cliente.getTrabajo().getCosto(); 
	int dineroPrev = empresa.getDinero();
	System.out.println(cliente.getTrabajo().getCosto() + " " + cliente.getTrabajo().getCantidadHorasCamion());
	cliente.contratarEmpresa(empresa);
	trabajo.setCantidadHorasCamion(100);
	trabajo.setCantidadHorasMaquina(105);
	camionero.trabajar(trabajo);
	maquinista.trabajar(trabajo);
	int dineroParaPagos = ((100*(100/5)) + (200/5)*100);
	System.out.println(empresa.calculoTotalACobrar(camionero) + "||" +empresa.calculoTotalACobrar(maquinista));
	dineroEsperado = dineroEsperado - dineroParaPagos;
	int dineroPost = empresa.getDinero();
	int dineroGanado = dineroPost - dineroPrev;
	System.out.println(dineroParaPagos);
	assertEquals(dineroEsperado, dineroGanado);
	
	}
	/*
	//asignar empleados
	@Test
	public void () {
	
	}*/
	//presupuestar trabajos
	@Test
	public void presupuestarTrabajo() {
	cliente.pedirPresupuesto(empresa);
	int esperado = trabajo.getCantidadHorasCamion()*100 + trabajo.getCantidadHorasMaquina()*200;
	assertEquals(esperado,trabajo.getCosto());
	
	}/*
	//empresa tranfiere a empleados
	@Test
	public void () {
	
	}
	*/
	//duenio revisa y termina el trabajo
	@Test
	public void duenioRevisaYEstaMal() {
	trabajo.setCantidadHorasMaquina(35);
	trabajo.setCantidadHorasCamion(0);
	duenio.revisarTrabajo(trabajo);
	int horas = duenio.getHorastrabajadas();
	assertEquals(5, horas);
	}
	//dueño revisa el trabajo y esta todo bien

	@Test
	public void duenioRevisaYEstaBien() {
	trabajo.setCantidadHorasMaquina(10);
	trabajo.setCantidadHorasCamion(0);
	maquinista.trabajar(trabajo);
	duenio.revisarTrabajo(trabajo);
	int horas = duenio.getHorastrabajadas();
	assertEquals(0, horas);
	}
	
}
