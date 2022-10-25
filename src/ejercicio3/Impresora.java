package ejercicio3;

import ar.edu.ort.tp1.tdas.implementaciones.ColaNodos;
import ar.edu.ort.tp1.tdas.interfaces.Cola;

public class Impresora {
	private boolean encendida;
	private int cantHojas;
	private Cola<Documento> docs;
	
	public Impresora(int cantHojas) {
		setCantHojas(cantHojas);
		this.docs = new ColaNodos<>();
	}
	
	public void	encenderOApagar() {
		encendida = !encendida;
	}
	
	public void setCantHojas(int cantHojas) {
		this.cantHojas = cantHojas;
	}

	public void agregar(Documento doc) {
		this.docs.add(doc);
	}
	
	private void checkEstaEncendida() {
		if (!encendida) {
			throw new RuntimeException("La impresora está apagada"); // IllegalStateException
		}
	}
		
	public boolean imprimir() {
		checkEstaEncendida();
		boolean alcanzanHojas = suficientesHojasEnBandeja();
		if (alcanzanHojas) {
			efectuarImpresion();
		}
		
		return alcanzanHojas;
	}

	private boolean suficientesHojasEnBandeja() {
		return cantHojas >= hojasRequeridas();
	}

	private int hojasRequeridas() {
		int acu = 0;
		Documento docCentinela = new Documento("Fake",0,false);
		this.docs.add(docCentinela);
		Documento docActual = this.docs.remove();		
		while(docCentinela != docActual) {
			acu += docActual.cantHojasRequeridas();			
			this.docs.add(docActual);
			docActual = this.docs.remove();
		}
		return acu;
	}

	private void efectuarImpresion() {
		while(!docs.isEmpty()) {
			System.out.println(docs.remove());
		}
	}
}
