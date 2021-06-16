package hrms.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.JobAdvertsService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobAdverts;

@RestController
@RequestMapping("/api/jobadverts")

public class JobAdvertsController {

	private JobAdvertsService jobAdvertsService;

	@Autowired
	public JobAdvertsController(JobAdvertsService jobAdvertsService) {
		super();
		this.jobAdvertsService = jobAdvertsService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobAdverts>> getall() {
		return jobAdvertsService.getAll();
	}

	@PostMapping("/add")

	public Result add(JobAdverts jobAdverts) {
		return jobAdvertsService.add(jobAdverts);
	}
}
