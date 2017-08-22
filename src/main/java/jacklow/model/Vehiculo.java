package jacklow.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Vehiculo {
	
	@Id @GeneratedValue
	private Long id;
	private String vtu;
	private String patente;

	public Vehiculo(){
		
	}
	
	public Vehiculo(String vtu, String patente) {
		super();
		this.vtu = vtu;
		this.patente = patente;
	}

	public String getVtu() {
		return vtu;
	}

	public void setVtu(String vtu) {
		this.vtu = vtu;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getPatente() {
		return patente;
	}

	
	public String toString (){
        String mensaje="Vehiculo  "+id+" "+vtu+" con "+patente;
        return mensaje;
    }
}
