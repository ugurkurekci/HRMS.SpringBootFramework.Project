package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.UsersService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.UsersDao;
import hrms.hrms.entities.concretes.Users;

@Service
public class UsersManager implements UsersService {

	private UsersDao usersDao;

	@Autowired
	public UsersManager(UsersDao usersDao) {

		this.usersDao = usersDao;
	}

	@Override
	public DataResult<List<Users>> getAll() {
		return new SuccessDataResult<List<Users>>(usersDao.findAll());
	}

	@Override
	public Result add(Users users) {
		usersDao.save(users);
		return new SuccessResult(" kullanıcı eklendi.  ");
	}

	@Override
	public Result delete(Users users) {
		usersDao.delete(users);
		return new SuccessResult(" kullanıcı silindi.  ");
	}

	

	
}
