package jacklow.model;

import java.time.LocalDateTime;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.uqbarproject.jpa.java8.extras.convert.LocalDateTimeConverter;

@Entity
public class Robo {

	@Id @GeneratedValue
	private Long id;
	
	@Convert(converter = LocalDateTimeConverter.class) //hibernate no sabe como pasar de LocalDateTime a tipo date en la BD , por eso hay que hacer esta anotation
	private LocalDateTime fecha;

	@ManyToOne //En el der un vehiculo puede tener muchos robos
	private Vehiculo vehiculo;
	

	private String denunciante;
	private String operador;
	private String zona;
	private String codigoDenuncia;
	
	public LocalDateTime getFecha() {
		return fecha;
	}

	public String getDenunciante() {
		return denunciante;
	}
	
	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}


	public String getOperador() {
		return operador;
	}

	public String getZona() {
		return zona;
	}

	public String getCodigoDenuncia() {
		return codigoDenuncia;
	}

}
