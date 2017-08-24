package jacklow.model.eventos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PistaEncontrada extends Evento {


	private String descripcion;

	public PistaEncontrada(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	
}
