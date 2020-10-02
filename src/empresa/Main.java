package empresa;

public class Main {
	public static void main(String[]args) {
		
		Maquinista guillermo = new Maquinista("guillermo");
		Camionero pepe = new Camionero("pepe");
		Trabajo trabajo = new Trabajo(10, 20, 100000);
		Cliente juan = new Cliente(trabajo, 200000);
		Duenio valen = new Duenio("valen");
		Empresa volpiSA = new Empresa("volpi",valen, 200, 100);
		
		//la empresa contrata a sus empleados 
		volpiSA.contratar(guillermo);
		volpiSA.contratar(pepe);
		
		juan.contratarEmpresa(volpiSA);
		
	
	}
	//crear nuevo maquinista
	public Maquinista crearMaquinista(String nom){
		return new Maquinista(nom);
		
	}
	
	//crear nuevo camionero
	public Camionero crearCamionero(String nom){
		return new Camionero(nom);
	
	}		
	//crear duenio		
	
	//crear cliente
	
	//crear trabajo 
	
	//asignar trabajo al cliente
	
	//crear empresa 
	
	//asignar dueño a empresa
	
	//asignar nuevos empleados a empresa
	
	

}