package hrms.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.UsersService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Users;

@RestController
@RequestMapping("/api/users")
public class UsersController {

	private UsersService usersService;

	@Autowired
	public UsersController(UsersService usersService) {
		super();
		this.usersService = usersService;
	}

	@GetMapping("/getall")
	public DataResult<List<Users>> getAll() {
		return this.usersService.getAll();
	}


	@PostMapping("/add")
	public Result add(@RequestBody Users users) {
		return this.usersService.add(users);
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestBody Users users) {
		return this.usersService.delete(users);
	}
}
