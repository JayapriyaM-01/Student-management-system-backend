package studentManagement.example.StudentManagement.Service;

import studentManagement.example.StudentManagement.entity.*;
import studentManagement.example.StudentManagement.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
	@Autowired
	private StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<StudentDetails> getAllStudents() {
        return repository.findAll();
    }

    public Optional<StudentDetails> getStudentById(Long id) {
        return repository.findById(id);
    }

    public StudentDetails saveStudent(StudentDetails student) {
        return repository.save(student);
    }

    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }

	

}

