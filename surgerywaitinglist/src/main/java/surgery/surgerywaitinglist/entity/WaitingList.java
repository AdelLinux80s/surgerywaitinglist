package surgery.surgerywaitinglist.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="waitingList")
public class WaitingList {

	@Id
	@GeneratedValue
	private Long waitingListId;
	private String waitingListProcedure;
	private String waitingListDiagnosis;
	private Long waitingListPatientId;
	private Long waitingListSurgeonId;
	private Long waitingListDepartmentId;
	private Date waitingListAdditionDate;
	private Date waitingListActualBookingDate;
}
