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
@Table(name = "job_seeker_cv_skills")
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekersCvSkills {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JoinColumn(name="job_seeker_cv_id")
	@OneToOne
	private JobSeekersCV jobSeekersCV; 
	
	@Column(name="name")
	private String name;
	
	@Column(name="created_at")
	private LocalDate createdAt=LocalDate.now();
}
