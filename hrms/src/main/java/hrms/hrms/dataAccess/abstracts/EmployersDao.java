package hrms.hrms.dataAccess.abstracts;



import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.Employers;

public interface EmployersDao extends JpaRepository<Employers, Integer> {

	Employers findByEmail( final String email);

	Employers findByPhone(final String phone);

}
