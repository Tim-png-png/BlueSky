package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import main.Client;
import util.JPAUtil;

public class ClientDAO {
	public void save(Client client ) {
		EntityManager session = JPAUtil.getEntityManeger();
		EntityTransaction transition = session.getTransaction();
		transition.begin();
		session.persist(client);
		transition.commit();
		
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Client> list() {
		String jpql = "select c from Client c order by id";
		EntityManager session = JPAUtil.getEntityManeger();
		Query consult = session.createQuery(jpql);
		List<Client> result = consult.getResultList();
		return result;
	}
	
	public Client find(Integer clientID) {
		EntityManager session = JPAUtil.getEntityManeger();
		Client client = session.find(Client.class, clientID);
		return client;
	}
	
	public void update(Client client) {
		EntityManager session = JPAUtil.getEntityManeger();
		EntityTransaction transaction = session.getTransaction();
		transaction.begin();
		
		session.merge(client);
		
		transaction.commit();
		session.close();
	}
	
	public void delete(Integer clientID) {
		EntityManager session = JPAUtil.getEntityManeger();
		EntityTransaction transaction = session.getTransaction();
		transaction.begin();
		Client client = session.find(Client.class, clientID);
		session.remove(client);
		
		transaction.commit();
		session.close();
		
	}
	
	
}
