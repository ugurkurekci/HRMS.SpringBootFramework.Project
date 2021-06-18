package hrms.hrms.business.concretes;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.JobAdvertsService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.ErrorResult;
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
	public Result add(JobAdverts jobAdvert) {

		jobAdvertsDao.save(jobAdvert);
		return new SuccessResult(" ilan eklendi. ");
	}

	@Override
	public Result delete(JobAdverts jobAdvert) {
		jobAdvertsDao.delete(jobAdvert);
		return new SuccessResult(" ilan silindi. ");
	}

	@Override
	public Result update(JobAdverts jobAdverts) {

		jobAdvertsDao.save(jobAdverts);
		return new SuccessResult(" ilan guncellendi. ");
	}

	@Override
	public DataResult<JobAdverts> getById(int id) {
		return new SuccessDataResult<JobAdverts>(jobAdvertsDao.getById(id));
	}

	@Override
	public DataResult<List<JobAdverts>> getAll() {
		return new SuccessDataResult<List<JobAdverts>>(jobAdvertsDao.findAll());
	}

	@Override
	public DataResult<List<JobAdverts>> getAll(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return new SuccessDataResult<List<JobAdverts>>(this.jobAdvertsDao.findAll(pageable).getContent());
	}

	@Override
	public DataResult<List<JobAdverts>> getByIsActive() {
		return new SuccessDataResult<List<JobAdverts>>(jobAdvertsDao.getByIsActiveTrue());
	}

	@Override
	public DataResult<List<JobAdverts>> getByIsActiveTrueOrderByDeadlineAsc() {
		return new SuccessDataResult<List<JobAdverts>>(jobAdvertsDao.getByIsActiveTrueOrderByApplicationDeadlineAsc());
	}

	@Override
	public DataResult<List<JobAdverts>> getByIsActiveTrueOrderByDeadlineDesc() {
		return new SuccessDataResult<List<JobAdverts>>(jobAdvertsDao.getByIsActiveTrueOrderByApplicationDeadlineDesc());
	}

	@Override
	public DataResult<List<JobAdverts>> getByIsActiveTrueAndEmployer_Id(int employerId) {
		return new SuccessDataResult<List<JobAdverts>>(jobAdvertsDao.getByIsActiveTrueAndEmployers(employerId));
	}

	@Override
	public DataResult<List<JobAdverts>> getByCity_CityId(int cityId) {
		return new SuccessDataResult<List<JobAdverts>>(jobAdvertsDao.getByCitiesId(cityId));
	}

	@Override
	public DataResult<List<JobAdverts>> getByJobTitle_JobTitleId(int jobTitleId) {
		return new SuccessDataResult<List<JobAdverts>>(jobAdvertsDao.getByJobTitleId(jobTitleId));
	}

	@Override
	public Result changeToActive(int id) {
		if (getById(id) == null) {
			return new ErrorResult(" Böyle bir is ilani yok");
		}
		if (getById(id).getData().isActive() == false) {
			return new SuccessResult(" İs ilani kapali");
		}
		JobAdverts jobAdverts = getById(id).getData();
		jobAdverts.setActive(false);
		jobAdvertsDao.save(jobAdverts);
		return new SuccessResult(" İs ilani basarili bir sekilde kapatildi");
	}

	@Override
	public DataResult<List<JobAdverts>> getAllSortedAsc() {
		Sort sort = Sort.by(Sort.Direction.ASC, "minSalary");
		return new SuccessDataResult<List<JobAdverts>>(this.jobAdvertsDao.findAll(sort), "Basarili");
	}

	@Override
	public DataResult<List<JobAdverts>> getAllSortedDesc() {
		Sort sort = Sort.by(Sort.Direction.DESC, "minSalary");
		return new SuccessDataResult<List<JobAdverts>>(this.jobAdvertsDao.findAll(sort), "Basarili");
	}

}
