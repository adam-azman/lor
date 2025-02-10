package edu.manipal.mit.cse.lor.LoRService.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LorResponseDto {
    private String id;
    private String registrationNumber;
    private String studentName;
    private String emailId;
    private String mobileNumber;
    private String dateOfBirth;
    private String linkedinId;

}
