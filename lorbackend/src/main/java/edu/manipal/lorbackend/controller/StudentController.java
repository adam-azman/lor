package edu.manipal.lorbackend.controller;

import edu.manipal.lorbackend.entity.Student;
import edu.manipal.lorbackend.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/validate")
    public ResponseEntity<?> validateStudent(
            @RequestParam String registrationNumber,
            @RequestParam String emailId,
            @RequestParam String dateOfBirth) {

        // Basic email validation
        if (!emailId.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid email format.");
        }

        // Fetch student details
        Optional<Student> student = studentService.getStudentDetails(registrationNumber, emailId/*, dateOfBirth*/);

        if (student.isPresent()) {
//            System.out.println("Found student: " + student.get());
            return ResponseEntity.ok(student.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found.");
        }
    }


}
