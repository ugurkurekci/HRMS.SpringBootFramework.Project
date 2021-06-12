package hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import hrms.hrms.entities.concretes.Users;

public interface UsersDao extends JpaRepository<Users, Integer> {

	Users findByisActive( boolean active);
	
}
