package ejercicio4;

public class Pelota {
	private String codigo;
	private TipoPelota tipo;
	
	public Pelota(String codigo, TipoPelota tipo) {
		setCodigo(codigo);
		setTipo(tipo);
	}
	
	private void setCodigo(String codigo) {
		if (codigo == null || codigo.isEmpty()) {
			throw new RuntimeException("Código de pelota inválido");
		}
		this.codigo = codigo;
	}
	
	private void setTipo(TipoPelota tipo) {
		if (tipo == null) {
			throw new RuntimeException("El tipo de pelota no puede ser nulo");
		}	
		this.tipo = tipo;
	}
	
	

	public TipoPelota getTipo() {
		return tipo;
	}

	@Override
	public String toString() {
		return "P " + codigo + " - " + tipo;
	}

	public boolean tenesEsteCodigo(String codigo) {
		return this.codigo.equals(codigo);
	}	
	
}
