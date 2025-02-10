package edu.manipal.mit.cse.lor.LoRService.service;

import edu.manipal.mit.cse.lor.LoRService.dto.LorRequestDto;
import edu.manipal.mit.cse.lor.LoRService.dto.LorResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface LorRequestService {
    LorResponseDto createLorRequest(LorRequestDto lorRequestDTO);
    LorResponseDto getLorRequestById(String lorId);
}