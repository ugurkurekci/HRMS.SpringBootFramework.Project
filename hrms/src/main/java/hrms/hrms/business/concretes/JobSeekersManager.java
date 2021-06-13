package hrms.hrms.business.concretes;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hrms.hrms.business.abstracts.JobSeekersService;
import hrms.hrms.core.abstracts.MernisCheckService;
import hrms.hrms.core.utilities.Business.BusinessRules;
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
	private MernisCheckService mernisCheckService;

	@Autowired
	public JobSeekersManager(JobSeekersDao jobSeekersDao, MernisCheckService mernisCheckService) {

		this.jobSeekersDao = jobSeekersDao;
		this.mernisCheckService = mernisCheckService;

	}

	@Override
	public DataResult<List<JobSeekers>> getAll() {
		return new SuccessDataResult<List<JobSeekers>>(jobSeekersDao.findAll());
	}

	@Override
	public Result add(JobSeekers jobSeekers) {

		if (checkIfEmailExists(jobSeekers.getEmail()))
			return new ErrorResult(" Bu Email zaten kaydedilmiş.");

		Result result = BusinessRules.run(CheckIdentityNumber(jobSeekers), nullControl(jobSeekers));

		if (result.isSuccess()) {
			mernisCheckService.checkIfRealPerson(jobSeekers);
			jobSeekersDao.save(jobSeekers);
			return new SuccessResult(" is arayan eklendi. ");
		}

		return new ErrorResult(" Mernis dogrulamasından gecemediniz veya bos alan bıraktınız.");
		

	}

	@Override
	public Result delete(JobSeekers jobSeekers) {
		jobSeekersDao.delete(jobSeekers);
		return new SuccessResult(" is arayan silindi. ");
	}

	@Override
	public DataResult<JobSeekers> getbyMail(String mail) {
		return new SuccessDataResult<JobSeekers>(this.jobSeekersDao.findByEmail(mail));
	}

	private boolean checkIfEmailExists(String email) {
		return jobSeekersDao.findByEmail(email) != null;

	}

	private Result CheckIdentityNumber(JobSeekers jobSeekers) {
		if (jobSeekers.getIdentityNumber().length() != 11) {
			return new ErrorResult("Tc Kimlik No 11 haneli olmak zorundadır.");
		}
		return new SuccessResult();
	}

	private Result nullControl(JobSeekers jobSeekers) {
		if (Objects.isNull(jobSeekers.getBirthDate()) || Objects.isNull(jobSeekers.getEmail())
				|| Objects.isNull(jobSeekers.getId()) || Objects.isNull(jobSeekers.getFirstName())
				|| Objects.isNull(jobSeekers.getIdentityNumber()) || Objects.isNull(jobSeekers.getLastName())
				|| Objects.isNull(jobSeekers.getPassword())) {

			return new ErrorResult(" Tüm alanlar zorunludur.");
		}
		return new SuccessResult();
	}

}
