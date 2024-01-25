package ma.fath.ExamSpring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.fath.ExamSpring.Entities.CentreVaccination;

//CentreVaccinationRepository.java
public interface CentreVaccinationRepository extends JpaRepository<CentreVaccination, Long> {
}