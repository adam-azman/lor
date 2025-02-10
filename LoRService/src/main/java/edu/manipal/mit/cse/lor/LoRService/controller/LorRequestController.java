package edu.manipal.mit.cse.lor.LoRService.controller;

import edu.manipal.mit.cse.lor.LoRService.dto.LorRequestDto;
import edu.manipal.mit.cse.lor.LoRService.dto.LorResponseDto;
import edu.manipal.mit.cse.lor.LoRService.service.LorRequestService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/lor")
public class LorRequestController {

    private LorRequestService lorRequestService;


    @PostMapping("/submit")
    public ResponseEntity<LorResponseDto> submitRequest(@RequestBody LorRequestDto lorRequestDto) {
        LorResponseDto savedRequest= lorRequestService.createLorRequest(lorRequestDto);
        return new ResponseEntity<>(savedRequest, HttpStatus.CREATED);
    }
    @GetMapping("/enquire/{lorId}")
    public ResponseEntity<LorResponseDto> enquire(@PathVariable String lorId) {
        LorResponseDto lorResponseDto = lorRequestService.getLorRequestById(lorId.trim());
        return new ResponseEntity<>(lorResponseDto, HttpStatus.OK);
    }
}
