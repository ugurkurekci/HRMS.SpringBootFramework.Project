package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hrms.hrms.business.abstracts.CitiesService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.CitiesDao;
import hrms.hrms.entities.concretes.Cities;

@Service
public class CitiesManager implements CitiesService {

	private CitiesDao citiesDao;

	@Autowired
	public CitiesManager(CitiesDao citiesDao) {

		this.citiesDao = citiesDao;
	}

	@Override
	public DataResult<List<Cities>> getAll() {

		return new SuccessDataResult<List<Cities>>(this.citiesDao.findAll(), " Sehirler Listelendi. ");

	}

	@Override
	public DataResult<Cities> getByName(String name) {
		return new SuccessDataResult<Cities>(this.citiesDao.findByName(name));
	}

	@Override
	public Result add(Cities cities) {
		this.citiesDao.save(cities);
		return new SuccessResult(" Sehir eklendi");

	}

	@Override
	public Result delete(Cities cities) {
		this.citiesDao.delete(cities);
		return new SuccessResult(" Sehir Silindi");
	}

	@Override
	public Result update(Cities cities) {
		this.citiesDao.save(cities);
		return new SuccessResult( " Sehir Guncellendi" );
	}

}
