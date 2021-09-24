package surgery.surgerywaitinglist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import surgery.surgerywaitinglist.entity.Surgeon;

@Repository
public interface SurgeonRepository extends JpaRepository<Surgeon, Long>{

}
