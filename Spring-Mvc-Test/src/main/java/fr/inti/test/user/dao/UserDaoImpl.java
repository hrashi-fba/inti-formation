package fr.inti.test.user.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.inti.test.entities.User;

public class UserDaoImpl implements IUserDao {
    
	private final Logger LOGGER  = Logger.getLogger("UserDaoImpl"); 
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public User addUser(User u) {
		em.persist(u);
		LOGGER.info("The user "+u+"Has been created...!");
		return u;
	}

	@Override
	public User updateUser(User u) {
		em.merge(u);
		return u;
	}

	@Override
	public User getOne(Long id) {
		User user = em.find(User.class,id);
		return user;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		Query query = em.createQuery("From User u");
		return query.getResultList();
	}

	@Override
	public User remove(Long id) {
		User u2 = getOne(id);
		em.remove(u2);
		return u2;
	}

	@Override
	public long getUserByName(String nom) {
		final String SQL = "select count(u.id)from User u where u.nom =:x";
		Query query = em.createQuery(SQL).setParameter("x",nom);	
		long count = (Long)query.getSingleResult();
		return count;
	}

}
