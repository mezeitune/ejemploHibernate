import javax.persistence.EntityManager;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import jacklow.model.Vehiculo;

public class RepoVehiculo {
	EntityManager entityManager;
	
	public RepoVehiculo(EntityManager em){
		this.entityManager=em;
	}
	
	public void agregar(Vehiculo vehiculo){
		entityManager.persist(vehiculo);
	
	}
	
	public Vehiculo findeById(long id){
		return entityManager.find(Vehiculo.class,new Long(id));//el repo o el que implemente la interfaz de ORM deberia ser el encargado de hacer esto
		
	}
	
	public void all(){
		entityManager .createQuery("from Vehiculo where patente=123").getResultList();
	}


}
