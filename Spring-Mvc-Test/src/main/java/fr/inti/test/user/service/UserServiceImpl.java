package fr.inti.test.user.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.transaction.annotation.Transactional;

import fr.inti.test.entities.User;
import fr.inti.test.exception.UserFound;
import fr.inti.test.user.dao.IUserDao;

@Transactional(readOnly=true)
public class UserServiceImpl implements IUserService {
    
	
	private final Logger LOGGER  = Logger.getLogger("UserServiceImpl"); 
	
	
	private IUserDao dao = null;
	
	
	
	public void setDao(IUserDao dao) {
		this.dao = dao;
		LOGGER.info("<---------"+dao+" injected --------->");
	}

	@Override
	@Transactional(readOnly=false)
	public User addUser(User u) throws UserFound {
		long count = getUserByName(u.getNom());
		if(count != 0){
			throw new UserFound(u.getNom() + "the user already exists");
		}
		return dao.addUser(u);
	}

	@Override
	@Transactional(readOnly=false)
	public User updateUser(User u) {
		// TODO Auto-generated method stub
		return dao.updateUser(u);
	}

	@Override
	public User getOne(Long id) {
		// TODO Auto-generated method stub
		return dao.getOne(id);
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return dao.getUsers();
	}

	@Override
	@Transactional(readOnly=false)
	public User remove(Long id) {
		// TODO Auto-generated method stub
		return dao.remove(id);
	}

	@Override
	public long getUserByName(String nom) {
		// TODO Auto-generated method stub
		return dao.getUserByName(nom);
	}

}
