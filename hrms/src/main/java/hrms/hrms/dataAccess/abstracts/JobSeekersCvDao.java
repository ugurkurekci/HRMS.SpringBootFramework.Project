package hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.JobSeekersCV;

public interface JobSeekersCvDao extends JpaRepository<JobSeekersCV, Integer> {

}
