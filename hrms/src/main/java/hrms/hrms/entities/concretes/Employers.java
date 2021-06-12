package hrms.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "user_id")
public class Employers extends Users {

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "website")
	private String webSite;

	@Column(name = "corporate_email")
	private String corporateEmail;

	@Column(name = "phone")
	private String phone;

	@JsonIgnore
	@Column(name = "created_at")
	private LocalDate createdAt = LocalDate.now();
}