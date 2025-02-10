package edu.manipal.mit.cse.lor.LoRService.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LorRequestDto {
    private String id;
    private String registrationNumber;
    private String studentName;
    private String emailId;
    private String mobileNumber;
    private String dateOfBirth;
    private String linkedinId;

}
