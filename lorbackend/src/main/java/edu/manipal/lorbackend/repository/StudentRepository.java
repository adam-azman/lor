package edu.manipal.lorbackend.repository;

import edu.manipal.lorbackend.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, String> {
    Optional<Student> findByRegistrationNumberAndEmailId/*AndDateOfBirth*/(
            String registrationNumber, String emailId/*, String dateOfBirth*/);
}
