package hrms.hrms.core.concretes;

import java.util.Locale;

import org.springframework.stereotype.Service;

import hrms.hrms.core.abstracts.MernisCheckService;
import hrms.hrms.entities.concretes.JobSeekers;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisCheckManager implements MernisCheckService {

	@Override
	public boolean checkIfRealPerson(JobSeekers jobSeekers) {

		KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();

		boolean result = true;

		try {
			result = kpsPublicSoapProxy.TCKimlikNoDogrula(Long.parseLong(jobSeekers.getIdentityNumber()),
					jobSeekers.getFirstName().toUpperCase(new Locale("tr")),
					jobSeekers.getLastName().toUpperCase(new Locale("tr")), jobSeekers.getBirthDate());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}
}
