package surgery.surgerywaitinglist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import surgery.surgerywaitinglist.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{

}
