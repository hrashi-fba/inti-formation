package fr.inti.test.user.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.inti.test.entities.User;
import fr.inti.test.exception.UserFound;
import fr.inti.test.model.UserModel;
import fr.inti.test.user.service.IUserService;



@Controller
public class UserController {
	
    @Inject
	private IUserService serviceUser;
    
    
    @RequestMapping(value="/")
    public String init(Model model){
    	/*UserModel userModel = new UserModel();
    	List<User> users = serviceUser.getUsers();
    	userModel.setUsers(users);*/
    	List<User> users = serviceUser.getUsers();
    	model.addAttribute("UM",users);
    	return "home";
    }
    @RequestMapping(value="/getOne")
    public String getOne(Model model,Long id){
    	/*UserModel userModel = new UserModel();
    	userModel.setId(id);
    	User u = serviceUser.getOne(userModel.getId());
    	userModel.setUser(u);*/
    	User u = serviceUser.getOne(id);
    	model.addAttribute("U",u);
    	return "home";
    }
    
    @RequestMapping(value="/delete")
    public String delete(Model model,Long id){
    	/*UserModel userModel = new UserModel();
    	userModel.setId(id);
    	serviceUser.remove(userModel.getId());
    	model.addAttribute("UM",userModel);*/
    	serviceUser.remove(id);
    	return "home";
    }
    
    @RequestMapping(value="/save")
    public String save(Model model,User u){
    	/*UserModel userModel = new UserModel();
    	userModel.setId(id);
    	serviceUser.remove(userModel.getId());
    	model.addAttribute("UM",userModel);*/
    	try {
			serviceUser.addUser(u);
		} catch (UserFound e) {
			model.addAttribute("error",e.getMessage());
		}
    	
    	return "home";
    }
    @RequestMapping(value="/Login")
    public String login(){
    	return "login";
    }
	
	
	
	
}
