package hrms.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.CitiesService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Cities;

@RestController
@RequestMapping("/api/cities")
public class CitiesController {

	private CitiesService citiesService;

	@Autowired
	public CitiesController(CitiesService citiesService) {
		super();
		this.citiesService = citiesService;
	}

	@GetMapping("/getall")
	public DataResult<List<Cities>> getAll() {
		return citiesService.getAll();

	}

	@GetMapping("/getbyName")
	public DataResult<Cities> getByName(String name) {
		return citiesService.getByName(name);
	}

	@PostMapping("/add")
	public Result add(@RequestBody Cities cities) {
		return citiesService.add(cities);
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestBody Cities cities) {
		return citiesService.delete(cities);
	}

}
