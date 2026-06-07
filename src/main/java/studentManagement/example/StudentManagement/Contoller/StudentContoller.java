package studentManagement.example.StudentManagement.Contoller;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import studentManagement.example.StudentManagement.Service.StudentService;
import studentManagement.example.StudentManagement.entity.StudentDetails;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/students")
public class StudentContoller {
           private final StudentService service;
           public StudentContoller(StudentService service) {
        	   this.service = service;
           }
           @GetMapping
           public List<StudentDetails> getAll() {
               return service.getAllStudents();
           }
           @GetMapping("/{id}")
           public ResponseEntity<StudentDetails> getById(@PathVariable Long id) {
               return service.getStudentById(id)
                       .map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
           }
           
           
           @PostMapping("/add")
           public StudentDetails create(@RequestBody StudentDetails student) {
               return service.saveStudent(student);
           }
          
           
           @PutMapping("/{id}")
           public ResponseEntity<StudentDetails> update(@PathVariable Long id, @RequestBody StudentDetails updated) {
               return service.getStudentById(id)
                       .map(existing -> {
                           existing.setName(updated.getName());
                           existing.setDepartment(updated.getDepartment());
                           existing.setEmail(updated.getEmail());
                           existing.setPhone(updated.getPhone());
                           return ResponseEntity.ok(service.saveStudent(existing));
                       })
                       .orElse(ResponseEntity.notFound().build());
           }
           @DeleteMapping("/{id}")
           public ResponseEntity<Void> delete(@PathVariable Long id) {
               service.deleteStudent(id);
               return ResponseEntity.noContent().build();
           }
}



