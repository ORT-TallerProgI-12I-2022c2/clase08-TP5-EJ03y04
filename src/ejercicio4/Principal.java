package ejercicio4;

public class Principal {
	
	public static void main(String[] args) {
		DepartamentoDeDeportes depto = new DepartamentoDeDeportes();
		depto.agregarPelota(new Pelota("111", TipoPelota.BASQUET));
		depto.agregarPelota(new Pelota("222", TipoPelota.FUTBOL));
		depto.agregarPelota(new Pelota("333", TipoPelota.BASQUET));
		depto.agregarPelota(new Pelota("444", TipoPelota.FUTBOL));
		depto.agregarPelota(new Pelota("555", TipoPelota.VOLEY));
		depto.agregarPelota(new Pelota("666", TipoPelota.BASQUET));
		depto.agregarPelota(new Pelota("777", TipoPelota.BASQUET));
		depto.agregarPelota(new Pelota("888", TipoPelota.FUTBOL));
		depto.agregarPelota(new Pelota("999", TipoPelota.BASQUET));
		depto.agregarPelota(new Pelota("000", TipoPelota.FUTBOL));
		depto.agregarPelota(new Pelota("456", TipoPelota.VOLEY));
		depto.agregarPelota(new Pelota("987", TipoPelota.BASQUET));
		depto.agregarPelota(new Pelota("999", TipoPelota.BASQUET));
		depto.agregarPelota(new Pelota("878", TipoPelota.FUTBOL));
		
		System.out.println(depto.buscarPelota("111"));
		System.out.println(depto.buscarPelota("xxx"));
		
		mostrarMatriz(depto.pelotasPorTipo());
		
		depto.verEstadoActual();		
	}

	private static void mostrarMatriz(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.print(mat[i][j] + "   ");
			}
			System.out.println();
		}
		
	}
	
	
}
