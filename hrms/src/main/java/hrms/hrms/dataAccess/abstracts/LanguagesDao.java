package hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.Languages;

public interface LanguagesDao extends JpaRepository<Languages, Integer> {

}
