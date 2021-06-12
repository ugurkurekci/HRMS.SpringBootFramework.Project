package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Employers;

public interface EmployersService {

	DataResult<List<Employers>> getAll();

	Result add(Employers employers);

	Result delete(Employers employers);
	DataResult<Employers> getEmployersphone(String phone);
	DataResult<Employers> getbyMail(String mail);
	
	
}
