package hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.JobSeekersCvEducations;

public interface JobSeekersCvEducationDao extends JpaRepository<JobSeekersCvEducations, Integer> {

}
