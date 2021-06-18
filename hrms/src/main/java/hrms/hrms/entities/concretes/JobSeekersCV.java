package hrms.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_seeker_cvs")
@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "jobSeekersCvEducations", "jobSeekersCvExperiences",
		"jobSeekersCvImages", "jobSeekersCvLanguages", "jobSeekersCvSkills", "jobSeekerCvWebSites" })

public class JobSeekersCV {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	@JoinColumn(name = "job_seeker_id")
	private JobSeekers jobSeekers;

	@Column(name = "cover_letter")
	private String coverLetter;

	@Column(name = "created_at")
	private LocalDate createdAt = LocalDate.now();

	@OneToMany(mappedBy = "jobSeekersCV")
	private List<JobSeekersCvEducations> jobSeekersCvEducations;

	@OneToMany(mappedBy = "jobSeekersCV")
	private List<JobSeekersCvExperiences> jobSeekersCvExperiences;

	@OneToMany(mappedBy = "jobSeekersCV")
	private List<JobSeekersCvImages> jobSeekersCvImages;

	@OneToMany(mappedBy = "jobSeekersCV")
	private List<JobSeekersCvLanguages> jobSeekersCvLanguages;

	@OneToMany(mappedBy = "jobSeekersCV")
	private List<JobSeekersCvSkills> jobSeekersCvSkills;

	@OneToMany(mappedBy = "jobSeekersCV")
	private List<JobSeekerCvWebSites> jobSeekerCvWebSites;
}
