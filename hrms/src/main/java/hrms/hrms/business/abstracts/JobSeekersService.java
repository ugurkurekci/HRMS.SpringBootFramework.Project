package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobSeekers;

public interface JobSeekersService {

	DataResult<List<JobSeekers>> getAll();
	
	DataResult<JobSeekers> getbyMail(String mail);

	Result add(JobSeekers jobSeekers);
	
	Result delete(JobSeekers jobSeekers);
}
