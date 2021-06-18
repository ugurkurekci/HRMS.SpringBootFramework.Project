package hrms.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "companyStaffVerifications" ,"emailActivation","mernisActivations"})
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "is_active")
	private boolean isActive = true;

	@Column(name = "is_deleted")
	private boolean isDelete = false;

	@JsonIgnore
	@Column(name = "created_at")
	private LocalDate createdAt = LocalDate.now();

	@OneToMany(mappedBy = "users")
	private List<EmailActivation> emailActivation;

	@OneToMany(mappedBy = "users")
	private List<CompanyStaffVerifications> companyStaffVerifications;
	
	@OneToMany(mappedBy = "users")
	private List<MernisActivations> mernisActivations;

}
