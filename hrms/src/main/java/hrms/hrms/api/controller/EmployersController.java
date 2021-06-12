package hrms.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.EmployersService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Employers;

@RestController
@RequestMapping("/api/Employers")
public class EmployersController {

	private EmployersService employersService;

	@Autowired
	public EmployersController(EmployersService employersService) {
		super();
		this.employersService = employersService;
	}

	@GetMapping("/getall")
	public DataResult<List<Employers>> getall() {
		return employersService.getAll();

	}

	@GetMapping("/getByPhone")
	public DataResult<Employers> getByPhone(String email) {
		return employersService.getEmployersphone(email);

	}
	
	@GetMapping("/getByEmail")
	public DataResult<Employers> getByEmail(String email) {
		return employersService.getbyMail(email);

	}

	@PostMapping("/add")
	public Result add(@RequestBody Employers employers) {
		return employersService.add(employers);
	}

	@DeleteMapping("/delete")
	public Result Delete(@RequestBody Employers employers) {
		return employersService.delete(employers);
	}
}
