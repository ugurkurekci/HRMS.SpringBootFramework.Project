package hrms.hrms.business.concretes;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.EmployersService;
import hrms.hrms.core.abstracts.VerificationService;
import hrms.hrms.core.utilities.Business.BusinessRules;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.ErrorResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.EmployersDao;
import hrms.hrms.entities.concretes.Employers;

@Service
public class EmployersManager implements EmployersService {
	private EmployersDao employersDao;
	private VerificationService verificationService;

	@Autowired
	public EmployersManager(EmployersDao employersDao, VerificationService verificationService) {

		this.employersDao = employersDao;
		this.verificationService = verificationService;

	}

	@Override
	public DataResult<List<Employers>> getAll() {
		return new SuccessDataResult<List<Employers>>(employersDao.findAll());
	}

	@Override

	public Result add(Employers employers) {

		if (checkIfEmailExists(employers.getEmail()))
			return new ErrorResult(" Bu Email zaten kaydedilmiş.");

		Result result = BusinessRules.run(nullControl(employers));
		if (result.isSuccess()) {
			employersDao.save(employers);
			verificationService.sendVerificationCode(employers.getEmail());
			return new SuccessResult(" is veren eklendi. Eposta adresinize dogrulama kodu gönderildi");
		}
		return result;
	}

	@Override
	public Result delete(Employers employers) {
		employersDao.delete(employers);
		return new SuccessResult(" is veren silindi. ");
	}

	@Override
	public DataResult<Employers> getEmployersphone(String phone) {
		return new SuccessDataResult<Employers>(this.employersDao.findByPhone(phone));
	}

	@Override
	public DataResult<Employers> getbyMail(String mail) {
		return new SuccessDataResult<Employers>(this.employersDao.findByEmail(mail));
	}

	private boolean checkIfEmailExists(String email) {
		return employersDao.findByEmail(email) != null;
	}

	private Result nullControl(Employers employers) {
		if (Objects.isNull(employers.getCompanyName()) || Objects.isNull(employers.getEmail())
				|| Objects.isNull(employers.getId()) || Objects.isNull(employers.getCorporateEmail())
				|| Objects.isNull(employers.getPassword()) || Objects.isNull(employers.getPhone())
				|| Objects.isNull(employers.getWebSite())) {

			return new ErrorResult(" Tüm alanlar zorunludur.");
		}
		return new SuccessResult();
	}

}
