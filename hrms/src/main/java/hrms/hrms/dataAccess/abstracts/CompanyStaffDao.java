package hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.CompanyStaffs;

public interface CompanyStaffDao extends JpaRepository<CompanyStaffs, Integer> {

}
