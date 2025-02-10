package edu.manipal.mit.cse.lor.LoRService.service;

import edu.manipal.mit.cse.lor.LoRService.entity.Alumni;
import edu.manipal.mit.cse.lor.LoRService.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Optional<Alumni> getStudentDetails(String registrationNumber, String emailId/*, String dateOfBirth*/) {
        return studentRepository.findByRegistrationNumberAndEmailId/*AndDateOfBirth*/(registrationNumber, emailId/*, dateOfBirth*/);
    }
}
