package ejercicio4;



public class DepartamentoDeDeportes {
	private static final int CANT_PILAS = 3;
	private static final int PELOTAS_X_PILA = 5;
	private PilaDePelotas[] pilasDePelotas;

	public DepartamentoDeDeportes() {
		this.pilasDePelotas = new PilaDePelotas[CANT_PILAS];
		instanciarPilas(); // NO LO OLVIDES....
	}
	
	private void instanciarPilas() {
		for (int i = 0; i < pilasDePelotas.length; i++) {
			pilasDePelotas[i] = new PilaDePelotas(PELOTAS_X_PILA);
		}		
	}
	
	public void verPelotasEnTope() {
		/* muestre
			la información completa de las tres pelotas actualmente
			visibles.
		*/
		for (int i = 0; i < pilasDePelotas.length; i++) {
			PilaDePelotas laPila = pilasDePelotas[i];
			if (!laPila.isEmpty()) {
				System.out.println(laPila.peek());				
			}
		}
	}
	
	private void checkPelota(Pelota p) {
		if (p == null) {
			throw new RuntimeException("¿Que querés agregar? ¬¬");
		}
	}

	public boolean agregarPelota(Pelota p) {
		checkPelota(p);
		boolean agregada = false;
		int i = 0;
		while(i < pilasDePelotas.length && !agregada) {
			PilaDePelotas laPila = pilasDePelotas[i];
			if (!laPila.isFull()) {
				laPila.push(p);
				agregada = true;
			}
			else i++;
		}
		return agregada;
	}
	
	public void verEstadoActual() {
		for (int i = 0; i < pilasDePelotas.length; i++) {
			mostrarPilaEnConsolaYEnLinea(pilasDePelotas[i]);
		}
	}
	
	private void mostrarPilaEnConsolaYEnLinea(PilaDePelotas pila) {
		/*
		 * Damos vuelta la pila para mostrarla en la consola
		 * */
		PilaDePelotas pilaInvertida = new PilaDePelotas();
		pasarElementos(pila, pilaInvertida);
		imprimirPila(pilaInvertida);
		pasarElementos(pilaInvertida, pila);
	}

	private void imprimirPila(PilaDePelotas pila) {
		PilaDePelotas pilaAux = new PilaDePelotas();
		while(!pila.isEmpty()) {
			Pelota p = pila.pop();
			System.out.print(p + "\t");
			pilaAux.push(p);
		}
		System.out.println(); // Próxima pila
		pasarElementos(pilaAux, pila);
	}
		
	private void pasarElementos(PilaDePelotas source, PilaDePelotas target) {
		while(!source.isEmpty()) {
			target.push(source.pop());
		}		
	}

	public Pelota buscarPelota(String codigo) {
		Pelota encontrada = null;
		int i = 0;
		while(i < pilasDePelotas.length && encontrada == null) {
			encontrada = buscarPelotaEnPila(pilasDePelotas[i], codigo);
			i++;
		}
		return encontrada;
	}
	
	private Pelota buscarPelotaEnPila(PilaDePelotas pila, String codigo) {
		Pelota encontrada = null;
		PilaDePelotas pilaAux = new PilaDePelotas();
		while(!pila.isEmpty() && encontrada == null) {
			Pelota p = pila.pop();
			if (p.tenesEsteCodigo(codigo)) {
				encontrada = p;
			}
			pilaAux.push(p);
		}
		pasarElementos(pilaAux, pila);
		return encontrada;
	}

	public int[][] pelotasPorTipo() {
		int[][] cantidades = new int[TipoPelota.values().length][CANT_PILAS];
		for (int i = 0; i < pilasDePelotas.length; i++) {
			cantidadesEnPila(i, cantidades);
		}
		return cantidades;
	}

	private void cantidadesEnPila(int i, int[][] cantidades) {
		PilaDePelotas pilaAProcesar = pilasDePelotas[i];
		
		Pelota encontrada = null;
		PilaDePelotas pilaAux = new PilaDePelotas();
		while(!pilaAProcesar.isEmpty() && encontrada == null) {
			Pelota p = pilaAProcesar.pop();
			
			cantidades[p.getTipo().ordinal()][i]++;
			
			pilaAux.push(p);
		}
		pasarElementos(pilaAux, pilaAProcesar);
	}

	
	
	
	
}
