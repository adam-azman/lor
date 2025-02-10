package edu.manipal.mit.cse.lor.LoRService.repository;

import edu.manipal.mit.cse.lor.LoRService.entity.LorRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface LorRequestRepository extends JpaRepository<LorRequest, String> {
    long count();
    Optional<LorRequest> findById(String lorId);
}
