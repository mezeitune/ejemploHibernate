import javax.persistence.EntityManager;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import jacklow.model.Vehiculo;

public class RepoVehiculo {

	public void agregar(Vehiculo vehiculo){
		EntityManager entityManager = (EntityManager) PerThreadEntityManagers.getEntityManager().getTransaction();
		entityManager.persist(vehiculo);
	
	}
	
	public Vehiculo findeById(long id){
		EntityManager entityManager = (EntityManager) PerThreadEntityManagers.getEntityManager().getTransaction();
		
		return entityManager.find(Vehiculo.class,new Long(1));//el repo o el que implemente la interfaz de ORM deberia ser el encargado de hacer esto
		
	}
	
	public void all(){
		EntityManager entityManager = (EntityManager) PerThreadEntityManagers.getEntityManager().getTransaction();
		
		entityManager .createQuery("from Vehiculo where patente=123").getResultList();
	}


}
