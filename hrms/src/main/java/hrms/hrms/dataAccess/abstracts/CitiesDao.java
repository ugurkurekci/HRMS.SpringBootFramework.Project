package hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.Cities;

public interface CitiesDao extends JpaRepository<Cities, Integer> {
	Cities findByName(String name);
}
