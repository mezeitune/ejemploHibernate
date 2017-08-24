package jacklow.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import org.uqbarproject.jpa.java8.extras.convert.LocalDateTimeConverter;

@Entity
public class Robo {

	@Id @GeneratedValue
	private Long id;
	
	@Convert(converter = LocalDateTimeConverter.class) //hibernate no sabe como pasar de LocalDateTime a tipo date en la BD , por eso hay que hacer esta anotation
	private LocalDateTime fecha;

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST) //En el der un vehiculo puede tener muchos robos
	@OrderColumn//agrega un campo que es el orden en el que estaba en la lista , para que cuando lo mapee los traiga en el mismo orden en el cual los persistio
	private Vehiculo vehiculo; // con LAZY no va a hacer el join en la consulta a menos que necesite el vehiculo. 
		//es cascadetype persiste objetos que le pasen que todavia no esten en la bd
	
	//@OneToMany
	//@JoinColumn(name="robo_id")
	//private List<Movil> moviles;

	@ManyToMany //Crea una tabla intermedia automaticamente
	private List<Movil> moviles;//pero si esa tabla intermedia quiero agregarle algunos campos para darle entidad , entonces quiza ahi si me conviene hacere una clase para poder mapearla
	
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
