package edu.manipal.mit.cse.lor.LoRService.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "lor_request")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class LorRequest {

    @Id
    private String id;

    @Column(name = "registration_number")
    private String registrationNumber;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "mobile_number")
    private String mobileNumber;
    @Column(name = "date_of_birth")
    private String dateOfBirth;
    @Column(name = "linkedin_id")
    private String linkedinId;


}
