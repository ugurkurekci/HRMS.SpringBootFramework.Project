package hrms.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "company_staffs")
@PrimaryKeyJoinColumn(name = "user_id")
public class CompanyStaffs extends Users {
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

}
