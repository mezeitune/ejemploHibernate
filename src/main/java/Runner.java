import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import jacklow.model.Robo;
import jacklow.model.Vehiculo;
import jacklow.model.eventos.Evento;

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
		
		
		entityManager.getTransaction().begin();
		
		Vehiculo vehiculo2 = new Vehiculo("asda","asdad");//si le doy esto a robo va a tirar error , por q no esta guardado en BD
		//esto se soluciona o persistiendo aca o con el coso ese cascade en el robo
		
		Robo robo = new Robo();
		robo.setVehiculo(vehiculo2);
		
		repo.agregarRobo(robo);
		
		entityManager.getTransaction().commit();
		
		
		//para modificar
		entityManager.getTransaction().begin();
		vehiculo.setPatente("Krishna");
		vehiculo.setVtu("Allahabad");
		entityManager.getTransaction().commit();
		
		Evento evento=entityManager.find(Evento.class, new Long(1));
		System.out.println(evento != null);
		
	
	}

}

