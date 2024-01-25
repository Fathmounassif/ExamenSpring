package ma.fath.ExamSpring.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

//Citoyen.java
@Entity @Data
public class Citoyen {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String nom;

 @ManyToOne
 @JoinColumn(name = "centre_vaccination_id")
 private CentreVaccination centreVaccination;

 // Getters and Setters
}

