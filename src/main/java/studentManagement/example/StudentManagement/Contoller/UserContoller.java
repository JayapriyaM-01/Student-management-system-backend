package studentManagement.example.StudentManagement.Contoller;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import studentManagement.example.StudentManagement.Service.Userservice;
import studentManagement.example.StudentManagement.config.JwtUtil;
import studentManagement.example.StudentManagement.entity.UserDetails;

@RestController
@CrossOrigin(origins = "https://student-management-system-frontend-mu.vercel.app/")
@RequestMapping("/api")
public class UserContoller {
	@Autowired
	private Userservice userService;
	
	@Autowired
	private JwtUtil jwtUtil;
	@GetMapping("/test")
	public String test() {
		return "api working";
		
	}
	@GetMapping
	public List<UserDetails> getAll(){
		return userService.getAlluser();
	}
	
	//register API
    @PostMapping("/register")
    public UserDetails register(@RequestBody UserDetails user) {
        return userService.saveUser(user);
    }
    //login API
    @PostMapping("/login")
   public ResponseEntity<?> login(@RequestBody Map<String,String> data){
    	String username=data.get("username");
    	String password=data.get("password");
    	String result = userService.login(username,password);
    	if(result.toLowerCase().contains("success")) {
    		String token = jwtUtil.generateToken(username);
    		return ResponseEntity.ok(Map.of(
    				"message", result,
    				"token", token
    				));
    	}else {
    	return ResponseEntity.ok(result);
    }
    }
}
