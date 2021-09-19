package surgery.surgerywaitinglist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import surgery.surgerywaitinglist.entity.WaitingList;

public interface WaitingListRepository extends JpaRepository<WaitingList, Long>{

}
