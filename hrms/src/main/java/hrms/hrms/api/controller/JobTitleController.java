package hrms.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.JobTitleService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobTitle;

@RestController
@RequestMapping("/api/jobtitles")
public class JobTitleController {

	private JobTitleService jobTitleService;

	@Autowired
	public JobTitleController(JobTitleService jobTitleService) {
		super();
		this.jobTitleService = jobTitleService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobTitle>> getall() {
		return jobTitleService.getAll();

	}
	@GetMapping("/getbyTitle")
	public DataResult <JobTitle> getbyTitle(String title) {
		return jobTitleService.getByTitle(title);

	}

	@PostMapping("/add")
	public Result add(@RequestBody JobTitle jobTitle) {
		return jobTitleService.add(jobTitle);
	}

	@DeleteMapping("/delete")
	public Result Delete(@RequestBody JobTitle jobTitle) {
		return jobTitleService.delete(jobTitle);
	}
	
}
