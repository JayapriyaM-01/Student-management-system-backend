 package studentManagement.example.StudentManagement.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "studentdetail")
public class StudentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    public StudentDetails() {
		
	}

	@Override
	public String toString() {
		return "StudentDetail [id=" + id + ", name=" + name + ",department=" + department + ", email=" + email + ", phone=" + phone + "]";
	}
	private String name;
	private String department;
    private String email;
    private String phone;
  
    // Constructors

	public StudentDetails(Long id, String name, String department, String email, String phone, String username,
			String password, String role) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.email = email;
		this.phone = phone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
