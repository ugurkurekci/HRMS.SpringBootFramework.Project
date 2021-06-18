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

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_seeker_cv_languages")
public class JobSeekersCvLanguages {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@OneToOne
	@JoinColumn(name = "job_seeker_cv_id")
	private JobSeekersCV jobSeekersCV;

	@OneToOne
	@JoinColumn(name = "language_id")
	private Languages languages;

	@Column(name = "level")
	private int level;

	@Column(name = "created_at")
	private LocalDate createdAt = LocalDate.now();

}
