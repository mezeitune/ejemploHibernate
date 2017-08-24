package jacklow.model.eventos;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Evento {

	@Id @GeneratedValue
	private Long id;
	private LocalDateTime fecha;
	

	/*
	 * Muchos muchos métodos que van a reutilizar las subclases
	 * 
	 * Inserte aquí'
	 * 
	 * |
	 * |
	 * v
	 * 
	 * */

}
