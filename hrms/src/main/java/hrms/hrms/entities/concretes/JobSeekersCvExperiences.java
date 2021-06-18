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

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "job_seeker_cv_experiences")
public class JobSeekersCvExperiences {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	@JoinColumn(name = "job_seeker_cv_id")
	private JobSeekersCV jobSeekersCV;

	@OneToOne
	@JoinColumn(name = "job_position_id")
	private JobTitle jobTitle;

	@Column(name = "workplace_name")
	private String workplaceName;

	@Column(name = "start_date")
	private LocalDate starDate;
	@Column(name = "quit_date")
	private LocalDate quitDate;

	@Column(name = "created_at")
	private LocalDate createdAt = LocalDate.now();
}
