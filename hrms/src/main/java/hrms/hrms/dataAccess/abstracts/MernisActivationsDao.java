package hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.MernisActivations;

public interface MernisActivationsDao extends JpaRepository<MernisActivations, Integer> {

}
