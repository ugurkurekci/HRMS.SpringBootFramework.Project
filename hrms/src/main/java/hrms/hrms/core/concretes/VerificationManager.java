package hrms.hrms.core.concretes;

import org.springframework.stereotype.Service;

import hrms.hrms.core.abstracts.VerificationService;

@Service
public class VerificationManager implements VerificationService {

	@Override
	public boolean sendVerificationCode(String email) {

		System.out.println("Dogrulama adresi maile gönderildi..");
		return true;
	}

}
