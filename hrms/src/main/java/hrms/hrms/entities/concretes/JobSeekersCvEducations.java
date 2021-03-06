package hrms.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "job_seeker_cv_educations")
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekersCvEducations {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	@JoinColumn(name = "job_seeker_cv_id")
	private JobSeekersCV jobSeekersCV;

	@Column(name = "school_name")
	private String schoolName;

	@Column(name = "deparment_name")
	private String deparmentName;

	@Column(name = "start_date")
	private LocalDate startDate;

	@Column(name = "graduation_date")
	private LocalDate graduationDate;

	@Column(name = "created_at")
	private LocalDate createdAt = LocalDate.now();
}
