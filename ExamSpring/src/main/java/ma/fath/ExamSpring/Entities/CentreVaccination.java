package ma.fath.ExamSpring.Entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

//CentreVaccination.java
@Entity @Data
public class CentreVaccination {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String nom;
private String adresse;

@OneToMany(mappedBy = "centreVaccination")
private List<Citoyen> citoyens;

// Getters and Setters
}


