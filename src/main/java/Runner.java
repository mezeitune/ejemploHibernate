import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import jacklow.model.Vehiculo;

//Inspiracion:
//http://www.concretepage.com/java/jpa/jpa-entitymanager-and-entitymanagerfactory-example-using-hibernate-with-persist-find-contains-detach-merge-and-remove

public class Runner {

	public static void main(String[] args) {
		EntityManager entityManager = JPAUtility.getEntityManager();
		RepoVehiculo repo=new RepoVehiculo(entityManager);
		
		Vehiculo vehiculo=repo.findeById(1);
		System.out.println(vehiculo.toString());
		
		
		entityManager.getTransaction().begin();
		
		repo.agregar(new Vehiculo("otra","bla"));
		
		entityManager.getTransaction().commit();
		
		
		//para modificar algo tengo que usar el setter de la clase y hacer el begin y commit 
		//lo del begin y commit es hacer una transaccion atomica
		
		//entityManager.clear();//para que se olvide de todos los objetos a persistir por que sino se llena mucho la memoria
		//normalmente se hace cuando termine de usar una pantalla
		
		//Session session = (Session) entityManager.getDelegate();
        //Vehiculo vehiculo =  (Vehiculo) session.get(Vehiculo.class, new Long(1));
		
	
	}

}

