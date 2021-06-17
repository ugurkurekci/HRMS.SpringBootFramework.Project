package hrms.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "company_staff_verifications")

public class CompanyStaffVerifications {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	@OneToOne
	@JoinColumn(name = "user_id")
	private Users users;

	@Column(name = "is_approved", columnDefinition = "boolean default false")
	private boolean isApproved = false;

	@Column(name = "created_at", columnDefinition = "Date default CURRENT_DATE")
	private final LocalDate createdAt = LocalDate.now();

	@Column(name = "approval_date")
	private LocalDate approvalDate;
}
