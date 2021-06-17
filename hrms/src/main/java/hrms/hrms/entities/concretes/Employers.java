package hrms.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "user_id")
public class Employers extends Users {

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "website")
	private String webSite;

	@Column(name = "corporate_email")
	private String corporateEmail;

	@Column(name = "phone")
	private String phone;

	@OneToMany(mappedBy = "employers")
	private List<JobAdverts> jobAdverts ;

}
