package studentManagement.example.StudentManagement.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentManagement.example.StudentManagement.Repository.UserRepository;

import studentManagement.example.StudentManagement.entity.UserDetails;

@Service
public class Userservice {
	@Autowired
	private UserRepository userrepository;
	   public UserDetails saveUser(UserDetails user) {
		   return userrepository.save(user);
	   }
	   public List<UserDetails> getAlluser() {
	        return  userrepository.findAll();
	    }
	  public String login(String username, String password) {
		  UserDetails user = userrepository.findByUsername(username);
		  if (user==null) {
			  return "user not found";
		  }if(user.getPassword().equals(password))
			  return "SUCCESS";
	  else {
		  return "invalid";
	  }
	  
}}
