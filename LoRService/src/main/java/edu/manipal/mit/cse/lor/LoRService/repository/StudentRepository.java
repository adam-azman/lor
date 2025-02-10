package edu.manipal.mit.cse.lor.LoRService.repository;

import edu.manipal.mit.cse.lor.LoRService.entity.Alumni;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Alumni, String> {
    Optional<Alumni> findByRegistrationNumberAndEmailId/*AndDateOfBirth*/(
            String registrationNumber, String emailId/*, String dateOfBirth*/);
}
