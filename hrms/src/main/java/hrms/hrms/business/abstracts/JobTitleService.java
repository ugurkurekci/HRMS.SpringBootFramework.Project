package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobTitle;

public interface JobTitleService {

	DataResult<List<JobTitle>> getAll();

	DataResult<JobTitle> getByTitle(String title);

	Result add(JobTitle jobTitle);

	Result delete(JobTitle jobTitle);

	Result update(JobTitle jobTitle);

}
