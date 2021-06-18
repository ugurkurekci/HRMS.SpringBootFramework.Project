package hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.JobSeekersCvImages;

public interface JobSeekersCvImagesDao extends JpaRepository<JobSeekersCvImages, Integer> {

}
