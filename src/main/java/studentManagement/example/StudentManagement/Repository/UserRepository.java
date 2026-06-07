package studentManagement.example.StudentManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import studentManagement.example.StudentManagement.entity.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails, Long> {

	UserDetails findByUsername(String username);

}
