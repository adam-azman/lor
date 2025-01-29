package edu.manipal.mit.cse.lor.repository;

import edu.manipal.mit.cse.lor.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, String> {
    Optional<Student> findByRegistrationNumberAndEmailId/*AndDateOfBirth*/(
            String registrationNumber, String emailId/*, String dateOfBirth*/);
}
