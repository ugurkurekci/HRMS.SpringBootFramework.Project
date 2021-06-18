package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobAdverts;


public interface JobAdvertsService {

	Result add(JobAdverts jobAdverts);

	Result delete(JobAdverts jobAdverts);

	Result update(JobAdverts jobAdverts);

	Result changeToActive(int id);

	DataResult<List<JobAdverts>> getAll();

	DataResult<List<JobAdverts>> getAllSortedAsc();

	DataResult<List<JobAdverts>> getAllSortedDesc();

	DataResult<JobAdverts> getById(int id);

	DataResult<List<JobAdverts>> getAll(int pageNo, int pageSize);

	DataResult<List<JobAdverts>> getByIsActive();

	DataResult<List<JobAdverts>> getByIsActiveTrueOrderByDeadlineAsc();

	DataResult<List<JobAdverts>> getByIsActiveTrueOrderByDeadlineDesc();

	DataResult<List<JobAdverts>> getByIsActiveTrueAndEmployer_Id(int employerId);

	DataResult<List<JobAdverts>> getByCity_CityId(int cityId);

	DataResult<List<JobAdverts>> getByJobTitle_JobTitleId(int jobTitleId);

}
