package hrms.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.JobSeekersService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobSeekers;

@RestController
@RequestMapping("/api/JobSeekers")
public class JobSeekersController {

	private JobSeekersService jobSeekersService;

	@Autowired
	public JobSeekersController(JobSeekersService jobSeekersService) {
		super();
		this.jobSeekersService = jobSeekersService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobSeekers>> getall() {
		return jobSeekersService.getAll();

	}

	@GetMapping("/getByEmail")
	public DataResult<JobSeekers> getByEmail(String email) {
		return jobSeekersService.getbyMail(email);

	}

	@PostMapping("/add")
	public Result add(@RequestBody JobSeekers jobSeekers) {
		return jobSeekersService.add(jobSeekers);
	}

	@DeleteMapping("/delete")
	public Result Delete(@RequestBody JobSeekers jobSeekers) {
		return jobSeekersService.delete(jobSeekers);
	}

}
