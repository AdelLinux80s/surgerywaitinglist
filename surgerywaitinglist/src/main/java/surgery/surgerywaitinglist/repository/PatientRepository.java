package surgery.surgerywaitinglist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import surgery.surgerywaitinglist.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{

}
