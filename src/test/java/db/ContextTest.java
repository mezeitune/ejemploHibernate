package db;

import static org.junit.Assert.*;

import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

public class ContextTest extends AbstractPersistenceTest implements WithGlobalEntityManager {//siempre para los tests heredar ese abstract persistence tes
/*
	@Before
	public void init(){
		entitiManager+instancia
		javax.persistence.EntityTransaction tx= entityManager.getTransaction()
		if(!tx.isActive()) tx.begin();
		
		//instanciar reposotiro ,  y empezar a hacer lo que quieras
	}
	*/
	
	@Test
	public void contextUp() {
		assertNotNull(entityManager());
	}

	@Test
	public void contextUpWithTransaction() throws Exception {
		withTransaction(() -> {});
	}
	
	
/*
 * Tests estilo inserto algo y traigo para ver si me trajo la cantidad correcta
 * 
 * 
	@After
	public void clean(){
		//entituManager.clear();//no rollbackea la transacion
		entityManager.getTrasaction().rollback() // no hay que hacer el commit , solo el begin
	}
	*/
	
}
