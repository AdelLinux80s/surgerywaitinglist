package surgery.surgerywaitinglist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import surgery.surgerywaitinglist.entity.WaitingList;

@Repository
public interface WaitingListRepository extends JpaRepository<WaitingList, Long>{

}
