package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobAdverts;

public interface JobAdvertsService {

	DataResult<List<JobAdverts>> getAll();

	Result add(JobAdverts jobAdverts);

	Result delete(JobAdverts jobAdverts);
}
