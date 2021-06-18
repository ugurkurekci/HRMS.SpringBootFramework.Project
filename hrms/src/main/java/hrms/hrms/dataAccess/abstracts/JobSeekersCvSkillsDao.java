package hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.JobSeekersCvSkills;

public interface JobSeekersCvSkillsDao extends JpaRepository<JobSeekersCvSkills, Integer> {

}
