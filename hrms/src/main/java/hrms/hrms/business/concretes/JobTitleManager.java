package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.JobTitleService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.ErrorResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.JobTitleDao;
import hrms.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService {

	private JobTitleDao jobTitleDao;

	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {

		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public DataResult<List<JobTitle>> getAll() {
		return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll(), "Data Listelendi");
	}

	@Override
	public Result add(JobTitle jobTitle) {

		if (checkIfTitleExists(jobTitle.getTitle()))
			return new ErrorResult(" Bu başlık zaten kaydedilmiş.");

		jobTitleDao.save(jobTitle);
		return new SuccessResult(" Ürün Eklendi");
	}

	@Override
	public Result delete(JobTitle jobTitle) {
		jobTitleDao.delete(jobTitle);
		return new SuccessResult(" Ürün Silindi");

	}

	@Override
	public DataResult<JobTitle> getByTitle(String title) {
		return new SuccessDataResult<JobTitle>(this.jobTitleDao.findByTitle(title));
	}

	private boolean checkIfTitleExists(String title) {
		return jobTitleDao.findByTitle(title) != null;
	}

}
