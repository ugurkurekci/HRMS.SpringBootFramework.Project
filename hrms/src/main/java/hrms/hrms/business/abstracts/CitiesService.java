package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Cities;

public interface CitiesService {

	DataResult<List<Cities>> getAll();

	DataResult<Cities> getByName(String name);

	Result add(Cities cities);

	Result delete(Cities cities);

	Result update(Cities cities);

}
