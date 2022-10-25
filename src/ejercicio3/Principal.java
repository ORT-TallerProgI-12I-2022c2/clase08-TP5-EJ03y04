package ejercicio3;

public class Principal {

	public static void main(String[] args) {
		Impresora imp = new Impresora(10);
		imp.encenderOApagar();
		imp.agregar( new Documento("--/--/----", 4, true)); // 2
		imp.agregar( new Documento("--/--/----", 3, false)); // 3
		imp.agregar( new Documento("--/--/----", 2, true)); // 1
		imp.agregar( new Documento("--/--/----", 1, false)); // 1
		try {
			System.out.println(imp.imprimir());
		} catch(RuntimeException e) {
			e.printStackTrace(System.out);
		}
		

	}

}
