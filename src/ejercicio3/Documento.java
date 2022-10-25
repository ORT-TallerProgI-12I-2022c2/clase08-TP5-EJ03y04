package ejercicio3;

public class Documento {
	private String fecha;
	private int cantCarillas;
	private boolean dobleFaz;
	
	public Documento(String fecha, int cantCarillas, boolean dobleFaz) {
		super();
		this.fecha = fecha;
		this.cantCarillas = cantCarillas;
		this.dobleFaz = dobleFaz;
	}

	public int cantHojasRequeridas() {
		
		return (dobleFaz ?
				Math.round(cantCarillas / 2) :
			    cantCarillas); 
	}

	@Override
	public String toString() {
		return "Documento [fecha=" + fecha + ", cantCarillas=" + cantCarillas + ", dobleFaz=" + dobleFaz + "]";
	}
	
	
}

