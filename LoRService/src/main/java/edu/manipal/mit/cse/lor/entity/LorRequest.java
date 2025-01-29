package edu.manipal.mit.cse.lor.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "lor_request")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LorRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String registrationNumber;

    @Column(nullable = false)
    private String studentName;

    @Column(nullable = false, unique = true)
    private String emailId;

    @Column(nullable = false)
    private String mobileNumber;

    @Column(nullable = false)
    private String dateOfBirth;

    private String linkedinId;
}

