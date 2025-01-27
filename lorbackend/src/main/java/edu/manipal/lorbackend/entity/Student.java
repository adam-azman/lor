package edu.manipal.lorbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
@Data
@Entity
@Table(name = "students")
@JsonInclude(JsonInclude.Include.NON_NULL)  // Ignore null values during serialization
public class Student {
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

//    @Override
//    public String toString() {
//        return "Student{" +
//                "registrationNumber='" + registrationNumber + '\'' +
//                ", emailId='" + emailId + '\'' +
//                ", dateOfBirth='" + dateOfBirth + '\'' +
//                ", gender='" + gender + '\'' +
//                ", mobileNumber='" + mobileNumber + '\'' +
//                ", studentName='" + studentName + '\'' +
//                '}';
//    }
}
