import java.util.List;

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
		//Instanciacion del repo que contiene todas las consultas a BD , el JPA que maneja el factory del entity
		JPAUtility jpa=JPAUtility.getInstance();
		EntityManager entityManager = jpa.getEntityManager();
		RepoDB<Vehiculo> repo=new RepoDB<>(Vehiculo.class,entityManager);
		
		
		//Consulta por un id de cualquier tabla sea
		Vehiculo vehiculo=repo.findeById(1);
		System.out.println(vehiculo.toString());
		
		//hace un insert de cualquier tabla sea
		entityManager.getTransaction().begin();
		
		repo.agregar(new Vehiculo("otrooo","otrooo"));
		
		entityManager.getTransaction().commit();
		
		
		//para modificar
		entityManager.getTransaction().begin();
		vehiculo.setPatente("Krishna");
		vehiculo.setVtu("Allahabad");
		entityManager.getTransaction().commit();
		
		List<Vehiculo> vehiculos=repo.all(1);
		System.out.println(vehiculos.toString());
	
	}

}

