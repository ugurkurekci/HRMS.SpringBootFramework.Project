package hrms.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_positions")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "jobAdverts", "jobSeekersCvExperiences" })

public class JobTitle {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "title")
	private String title;

	@Column(name = "is_active")
	private boolean isActive = true;

	@Column(name = "is_deleted")
	private boolean isDelete = false;

	@JsonIgnore
	@Column(name = "created_at")
	private LocalDate createdAt = LocalDate.now();

	@OneToMany(mappedBy = "jobTitle")
	private List<JobAdverts> jobAdverts;

	@OneToMany(mappedBy = "jobTitle")
	private List<JobSeekersCvExperiences> jobSeekersCvExperiences;
}
