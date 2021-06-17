package hrms.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "email_activations")
public class EmailActivation {

	@javax.persistence.Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	@JoinColumn(name = "user_id")
	@ManyToOne
	private Users users;

	@Column(name = "activation_code")
	private String activationCode;

	@Column(name = "email")
	private String email;

	@Column(name = "is_activated", columnDefinition = "boolean default false")
	private boolean isActivated = false;

	@Column(name = "created_at", columnDefinition = "Date default CURRENT_DATE")
	private final LocalDate createdAt = LocalDate.now();

	@Column(name = "expiration_date")
	private LocalDate expiratioDate;

	@Column(name = "activation_date")
	private LocalDate activationDate;
}
