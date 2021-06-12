package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hrms.hrms.business.abstracts.JobSeekersService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.ErrorResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.JobSeekersDao;
import hrms.hrms.entities.concretes.JobSeekers;

@Service
public class JobSeekersManager implements JobSeekersService {

	private JobSeekersDao jobSeekersDao;

	@Autowired
	public JobSeekersManager(JobSeekersDao jobSeekersDao) {
		
		this.jobSeekersDao = jobSeekersDao;

	}

	@Override
	public DataResult<List<JobSeekers>> getAll() {
		return new SuccessDataResult<List<JobSeekers>>(jobSeekersDao.findAll());
	}

	@Override
	public Result add(JobSeekers jobSeekers) {

		if (checkIfEmailExists(jobSeekers.getEmail()))
			return new ErrorResult(" Bu Email zaten kaydedilmiş.");
		
		jobSeekersDao.save(jobSeekers);
		return new SuccessResult(" is arayan eklendi. ");
	}

	@Override
	public Result delete(JobSeekers jobSeekers) {
		jobSeekersDao.delete(jobSeekers);
		return new SuccessResult(" is arayan silindi. ");
	}

	private boolean checkIfEmailExists(String email) {
		return jobSeekersDao.findByEmail(email) != null;
	}

	@Override
	public DataResult<JobSeekers> getbyMail(String mail) {
		return new SuccessDataResult<JobSeekers>(this.jobSeekersDao.findByEmail(mail));
	}
	
}
