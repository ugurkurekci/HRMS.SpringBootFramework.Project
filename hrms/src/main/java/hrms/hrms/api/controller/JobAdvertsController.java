package hrms.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@GetMapping("/getallSortedAsc")
	public DataResult<List<JobAdverts>> getallSortedAsc() {
		return jobAdvertsService.getAllSortedAsc();
	}

	@GetMapping("/getallSortedDesc")
	public DataResult<List<JobAdverts>> getallSortedDesc() {
		return jobAdvertsService.getAllSortedDesc();
	}

	@GetMapping("/getAllPageSize")
	public DataResult<List<JobAdverts>> getAllPageSize() {
		return jobAdvertsService.getAll(1, 1);
	}

	@GetMapping("/getByIsActive")
	public DataResult<List<JobAdverts>> getByIsActive() {
		return jobAdvertsService.getByIsActive();
	}

	@GetMapping("/getByIsActiveTrueOrderByDeadlineAsc")
	public DataResult<List<JobAdverts>> getByIsActiveTrueOrderByDeadlineAsc() {
		return jobAdvertsService.getByIsActiveTrueOrderByDeadlineAsc();
	}

	@GetMapping("/getByIsActiveTrueOrderByDeadlineDesc")
	public DataResult<List<JobAdverts>> getByIsActiveTrueOrderByDeadlineDesc() {
		return jobAdvertsService.getByIsActiveTrueOrderByDeadlineDesc();
	}

	@GetMapping("/getByIsActiveTrueAndEmployer_Id")
	public DataResult<List<JobAdverts>> getByIsActiveTrueAndEmployer_Id(int id) {
		return jobAdvertsService.getByIsActiveTrueAndEmployer_Id(id);
	}

	@GetMapping("/getByCity_CityId")
	public DataResult<List<JobAdverts>> getByCity_CityId(int id) {
		return jobAdvertsService.getByCity_CityId(id);
	}

	@GetMapping("/getByJobTitle_JobTitleId")
	public DataResult<List<JobAdverts>> getByJobTitle_JobTitleId(int id) {
		return jobAdvertsService.getByJobTitle_JobTitleId(id);
	}

	@GetMapping("/getById")
	public DataResult<JobAdverts> getById(int id) {
		return jobAdvertsService.getById(id);
	}

	@PostMapping("/add")

	public Result add(JobAdverts jobAdverts) {
		return jobAdvertsService.add(jobAdverts);
	}

	@PostMapping("/changeToActive")

	public Result changeToActive(int id) {
		return jobAdvertsService.changeToActive(id);
	}

	@DeleteMapping("/delete")

	public Result delete(JobAdverts jobAdverts) {
		return jobAdvertsService.delete(jobAdverts);
	}

	@PutMapping("/update")

	public Result update(JobAdverts jobAdverts) {
		return jobAdvertsService.update(jobAdverts);
	}
}
