package edu.manipal.lorbackend.service;

import edu.manipal.lorbackend.entity.Student;
import edu.manipal.lorbackend.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Optional<Student> getStudentDetails(String registrationNumber, String emailId/*, String dateOfBirth*/) {
        return studentRepository.findByRegistrationNumberAndEmailId/*AndDateOfBirth*/(registrationNumber, emailId/*, dateOfBirth*/);
    }
}
