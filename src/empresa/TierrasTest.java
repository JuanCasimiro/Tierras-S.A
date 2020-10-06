package empresa;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TierrasTest {
	
	Maquinista maquinista = new Maquinista("guillermo");
	Camionero camionero   = new Camionero("pepe");
	Trabajo trabajo       = new Trabajo(120, 120);
	Cliente cliente       = new Cliente(trabajo, 10000000);
	Duenio duenio         = new Duenio("valen");
	Empresa empresa       = new Empresa("volpi",duenio, 200, 100);
    @Before
	public void before() {
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
	/*
	//empresa tiene maquinistas
	@Test
	public void () {
		
	}
	
	//empresa tiene camioneros
	@Test
	public void () {}*/
	//trabajo de 30 o mas hora mal echo por el maquinista
	@Test
	public void trabajoMalHechoPorMasDe30Horas () {
	trabajo.setCantidadHorasMaquina(35);
	maquinista.trabajar(trabajo);
	assertFalse(trabajo.estaBienRealizado());
	}
	/*
	//empleados reciben pagos
	@Test
	public void () {
	
	}*/
	//empleados cobran y las horas de trabajo quedan en 0
	@Test
	public void despuesDeCobrarSeteaHorasA0() {
	camionero.trabajar(trabajo);
	camionero.cobrar();
	assertEquals(0,camionero.getHorastrabajadas());
	}
	/*
	//contratar empleados
	@Test
	public void () {}
	//empresa recibe le pago
	@Test
	public void () {}
	//asignar empleados
	@Test
	public void () {}
	//presupuestar trabajos
	@Test
	public void () {}
	//se realiza bien el trabajo
	@Test
	public void () {}
	//calculo de presupuesto por trabajo
	@Test
	public void () {}
	//empresa tranfiere a empleados
	@Test
	public void () {}
	//cliente contrata empresa sin el presupuesto necesario
	@Test
	public void () {}
	//cliente contrata empresa con el presupuesto necesario
	@Test
	public void () {}
	//duenio revisa y termina el trabajo
	@Test
	public void () {}
	//dueño revisa el trabajo y esta todo bien
	@Test
	public void () {}
*/	
}
