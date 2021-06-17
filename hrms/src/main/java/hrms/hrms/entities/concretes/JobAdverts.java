package hrms.hrms.entities.concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_adverts")
public class JobAdverts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employers employers;

	@ManyToOne
	@JoinColumn(name = "job_position_id")
	private JobTitle jobTitle;

	@JoinColumn(name = "city_id")
	@ManyToOne
	private Cities cities;

	@Column(name = "description")
	private String description;

	@Column(name = "min_salary")
	private int minSalary;

	@Column(name = "max_salary")
	private int maxSalary;

	@Column(name = "number_of_open_positions")
	private int numberOfOpenPositions;

	@JsonIgnore
	@Column(name = "created_at")
	private final LocalDate createdAt = LocalDate.now();

	@Column(name = "application_deadline")
	private LocalDateTime applicationDeadline;

	@Column(name = "is_active")
	private boolean isActive = true;
	@Column(name = "is_deleted")
	private boolean isDelete = false;
}
