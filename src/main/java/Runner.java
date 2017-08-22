import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import jacklow.model.Vehiculo;

public class Runner {

	public static void main(String[] args) {
		RepoVehiculo repo=new RepoVehiculo();
		
		//EntityManager entityManager = (EntityManager) PerThreadEntityManagers.getEntityManager().getTransaction();
		EntityManager entityManager = JPAUtility.getEntityManager();	
		Vehiculo vehiculo=entityManager.find(Vehiculo.class,new Long(1));//el repo o el que implemente la interfaz de ORM deberia ser el encargado de hacer esto
		
		//((EntityTransaction) entityManager).begin();
		
		//repo.agregar(new Vehiculo("otra","bla"));//hacer la clase repo con un findById y el agregar
		//PerThreadEntityManagers.getEntityManager().persist(vehiculo)
		
		//((EntityTransaction) entityManager).commit();
		
		
		//para modificar algo tengo que usar el setter de la clase y hacer el begin y commit 
		//lo del begin y commit es hacer una transaccion atomica
		
		//entityManager.clear();//para que se olvide de todos los objetos a persistir por que sino se llena mucho la memoria
		//normalmente se hace cuando termine de usar una pantalla
		
		//Session session = (Session) entityManager.getDelegate();
        //Vehiculo vehiculo =  (Vehiculo) session.get(Vehiculo.class, new Long(1));
		
		System.out.println(vehiculo.toString());
	}

}

