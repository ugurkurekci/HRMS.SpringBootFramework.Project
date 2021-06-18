package hrms.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.JobAdverts;

public interface JobAdvertsDao extends JpaRepository<JobAdverts, Integer> {

	JobAdverts getById(int id);

	List<JobAdverts> getByJobTitle(int jobTitleId);

	List<JobAdverts> getByCitiesId(int cityId);

	List<JobAdverts> getByJobTitleId(int jobTitleId);

	List<JobAdverts> getByIsActiveTrue();

	List<JobAdverts> getByIsActiveTrueOrderByApplicationDeadlineAsc();

	List<JobAdverts> getByIsActiveTrueOrderByApplicationDeadlineDesc();

	List<JobAdverts> getByIsActiveTrueAndEmployers(int employerId);
}
