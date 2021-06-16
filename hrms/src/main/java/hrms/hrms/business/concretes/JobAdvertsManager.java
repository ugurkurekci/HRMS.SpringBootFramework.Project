package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.JobAdvertsService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.JobAdvertsDao;
import hrms.hrms.entities.concretes.JobAdverts;

@Service
public class JobAdvertsManager implements JobAdvertsService {

	private JobAdvertsDao jobAdvertsDao;

	@Autowired
	public JobAdvertsManager(JobAdvertsDao jobAdvertsDao) {
		super();
		this.jobAdvertsDao = jobAdvertsDao;
	}

	@Override
	public DataResult<List<JobAdverts>> getAll() {
		return new SuccessDataResult<List<JobAdverts>>(jobAdvertsDao.findAll());
	}

	@Override
	public Result add(JobAdverts jobAdverts) {
		jobAdvertsDao.save(jobAdverts);
		return new SuccessResult(" ilan eklendi. ");
	}

	@Override
	public Result delete(JobAdverts jobAdverts) {
		jobAdvertsDao.delete(jobAdverts);
		return new SuccessResult(" ilan silindi. ");
	}

}
