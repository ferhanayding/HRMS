package kodlama.io.hrms61.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms61.bussines.abstracts.TechService;
import kodlama.io.hrms61.core.utitiles.results.DataResult;
import kodlama.io.hrms61.core.utitiles.results.Result;
import kodlama.io.hrms61.entities.concretes.Tech;

@RestController
@RequestMapping("/TechController/")
public class TechController {

	private TechService techService;

	@Autowired
	public TechController(TechService techService) {
		super();
		this.techService = techService;
	}
	@GetMapping("getall")
	DataResult<List<Tech>> getAll(){
		return this.techService.getAll();
	}
	
	@PostMapping("add")
	Result add(@RequestBody Tech tech) {
		return this.techService.add(tech);
	}
}
