package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Users;

public interface UsersService {

	DataResult<List<Users>> getAll();

	Result add(Users users);

	Result delete(Users users);

}
