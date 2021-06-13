package hrms.hrms.core.abstracts;

import hrms.hrms.entities.concretes.JobSeekers;

public interface MernisCheckService {

	boolean checkIfRealPerson(JobSeekers jobSeekers);
}
