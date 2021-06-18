package hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.JobSeekersCvLanguages;

public interface JobSeekersCvLanguageDao extends JpaRepository<JobSeekersCvLanguages, Integer> {

}
