package jacklow.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Movil {

	@Id @GeneratedValue
	private Long id;
	
	public Movil(){
		
	}
	
}
