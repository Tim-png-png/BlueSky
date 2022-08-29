package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("BlueSkyPU");

	public static EntityManager getEntityManeger() {
		EntityManager session = factory.createEntityManager();
		return session;
	}
}
