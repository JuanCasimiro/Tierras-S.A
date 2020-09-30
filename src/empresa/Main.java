package empresa;

public class Main {
	public static void main(String[]args) {
		
		Maquinista guillermo = new Maquinista("guillermo");
		Camionero pepe = new Camionero("pepe");
		Cliente juan = new Cliente();
		Trabajo trabajo = new Trabajo(10, 20, 100000);
		Duenio valen = new Duenio("valen");
		Empresa volpiSA = new Empresa("volpi",valen, 200, 100);
		
	}
}
