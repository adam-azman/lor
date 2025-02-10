package edu.manipal.mit.cse.lor.LoRService.service.impl;

import edu.manipal.mit.cse.lor.LoRService.dto.LorRequestDto;
import edu.manipal.mit.cse.lor.LoRService.dto.LorResponseDto;
import edu.manipal.mit.cse.lor.LoRService.entity.LorRequest;
import edu.manipal.mit.cse.lor.LoRService.repository.LorRequestRepository;
import edu.manipal.mit.cse.lor.LoRService.service.LorRequestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@AllArgsConstructor
@Service
public class LorRequestServiceImpl implements LorRequestService {
    private  LorRequestRepository lorRequestRepository;
    @Override
    public LorResponseDto createLorRequest(@RequestBody LorRequestDto lorRequestDTO) {
        System.out.println("Received LOR Request: " + lorRequestDTO);

        String todayDate = java.time.LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("ddMMyyyy"));
        long count = lorRequestRepository.count() + 1;
        String generatedId = String.format("lor-%s-%04d", todayDate, count);

        LorRequest newRequest = LorRequest.builder()
                .id(generatedId)
                .registrationNumber(lorRequestDTO.getRegistrationNumber())
                .studentName(lorRequestDTO.getStudentName())
                .mobileNumber(lorRequestDTO.getMobileNumber())
                .dateOfBirth(lorRequestDTO.getDateOfBirth())
                .linkedinId(lorRequestDTO.getLinkedinId())
                .emailId(lorRequestDTO.getEmailId())
                .build();

        LorRequest lorRequest = lorRequestRepository.save(newRequest);

        return LorResponseDto.builder()
                .id(lorRequest.getId())
                .registrationNumber(lorRequest.getRegistrationNumber())
                .studentName(lorRequest.getStudentName())
                .emailId(lorRequest.getEmailId())
                .linkedinId(lorRequest.getLinkedinId())
                .dateOfBirth(lorRequest.getDateOfBirth())
                .mobileNumber(lorRequest.getMobileNumber())
                .build();
    }
    @Override
    public LorResponseDto getLorRequestById(String lorId) {
        Optional<LorRequest> lorRequest = lorRequestRepository.findById(lorId);
        if (lorRequest.isPresent()) {
            LorRequest request = lorRequest.get();
            return new LorResponseDto(request.getId(), request.getRegistrationNumber(),
                    request.getStudentName(), request.getEmailId(), request.getMobileNumber(),
                    request.getDateOfBirth(), request.getLinkedinId());
        } else {
            throw new RuntimeException("LOR Request with ID " + lorId + " not found.");
        }
    }
}
