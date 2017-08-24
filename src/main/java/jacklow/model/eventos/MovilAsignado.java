package jacklow.model.eventos;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import jacklow.model.Movil;

@Entity
public class MovilAsignado extends Evento {
	
	@ManyToOne
	private Movil movil;

	public Movil getMovil() {
		return movil;
	}

	public MovilAsignado(Movil movil) {
		super();
		this.movil = movil;
	}

}
