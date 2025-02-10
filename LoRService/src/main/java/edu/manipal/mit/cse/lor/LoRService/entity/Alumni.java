package edu.manipal.mit.cse.lor.LoRService.entity;


import jakarta.persistence.*;
import lombok.Data;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@Data
@Entity
@Table(name = "alumni")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Alumni {
    @Id
    @Column(name = "registration_number", nullable = false, unique = true)
    @JsonProperty("registration_number")
    private String registrationNumber;

    @Column(name = "email_id", nullable = false, unique = true)
    @JsonProperty("email_id")
    private String emailId;

    @Column(name = "student_name", nullable = false)
    @JsonProperty("student_name")
    private String studentName;

    @Column(name = "gender")
    @JsonProperty("gender")
    private String gender;

    @Column(name = "mobile_number")
    @JsonProperty("mobile_number")
    private String mobileNumber;

    @Column(name = "date_of_birth", nullable = false)
    @JsonProperty("date_of_birth")
    private String dateOfBirth; // Use `LocalDate` for better date handling


}
