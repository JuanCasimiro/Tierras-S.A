package empresa;

public class Main {
	public static void main(String[]args) {
		
		Camionero pepe       = new Camionero("pepe");
		Trabajo trabajo      = new Trabajo(10, 20);
		Cliente juan         = new Cliente(trabajo, 100000);
		Duenio valen         = new Duenio("valen");
		Empresa volpiSA      = new Empresa("volpi",valen, 200, 100);
		
		//la empresa contrata a sus empleados 
		volpiSA.contratar(new Maquinista("guillermo"));
		volpiSA.contratar(pepe);
		
		
		try{
			juan.contratarEmpresa(volpiSA);
		}catch (RuntimeException e) {
			System.out.print(e.getMessage());
		}
		
	
	}
	

}