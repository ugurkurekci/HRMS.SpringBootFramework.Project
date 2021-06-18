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

@Table(name = "job_seeker_cv_web_sites")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class JobSeekerCvWebSites {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@OneToOne
	@JoinColumn(name = "job_seeker_cv_id")
	private JobSeekersCV jobSeekersCV;

	@OneToOne
	@JoinColumn(name = "web_site_id")
	private WebSites webSites;

	@Column(name = "address")
	private String adress;

	@Column(name = "created_at")
	private LocalDate createdAt = LocalDate.now();

}
