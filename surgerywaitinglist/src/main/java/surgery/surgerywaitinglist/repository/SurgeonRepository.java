package surgery.surgerywaitinglist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import surgery.surgerywaitinglist.entity.Surgeon;

public interface SurgeonRepository extends JpaRepository<Surgeon, Long>{

}
