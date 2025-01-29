package edu.manipal.mit.cse.lor.repository;


import edu.manipal.mit.cse.lor.entity.LorRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LorRequestRepository extends JpaRepository<LorRequest, Long> {
    Optional<LorRequest> findByRegistrationNumber(String registrationNumber);
}
