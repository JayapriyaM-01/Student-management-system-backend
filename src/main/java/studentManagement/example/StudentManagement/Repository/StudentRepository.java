package studentManagement.example.StudentManagement.Repository;
import studentManagement.example.StudentManagement.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentDetails, Long> {
	

}
