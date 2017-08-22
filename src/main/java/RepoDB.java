import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import jacklow.model.Vehiculo;

public class RepoDB<E>  {
	private EntityManager entityManager;

    final Class<E> typeParameterClass;

  
	public RepoDB(Class<E> typeParameterClass,EntityManager em){
		this.entityManager=em;
		this.typeParameterClass = typeParameterClass;
	}
	
	public <E> void agregar(E vehiculo){
		entityManager.persist(vehiculo);
	
	}
	
	public <E> E findeById(long id){
		return (E) entityManager.find(typeParameterClass,new Long(id));//el repo o el que implemente la interfaz de ORM deberia ser el encargado de hacer esto
		
	}
	
	public List<E> all(int criterioFiltro){
		Query query = entityManager.createQuery("from Vehiculo");
		//query.setParameter("code", criterioFiltro);
		List<E> listado = query.getResultList();
		return listado;
	}


}
