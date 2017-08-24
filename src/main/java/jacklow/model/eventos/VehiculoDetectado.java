package jacklow.model.eventos;

import javax.persistence.Entity;

@Entity
public class VehiculoDetectado extends Evento {
	private int numeroDeAntena;
	private int intensidad;

	public VehiculoDetectado(int numeroDeAntena, int intensidad) {
		super();
		this.numeroDeAntena = numeroDeAntena;
		this.intensidad = intensidad;
	}

	public int getNumeroDeAntena() {
		return numeroDeAntena;
	}

	public int getIntensidad() {
		return intensidad;
	}

}
