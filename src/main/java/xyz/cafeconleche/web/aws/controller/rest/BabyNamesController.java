package xyz.cafeconleche.web.aws.controller.rest;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import xyz.cafeconleche.web.aws.service.BabyNamesService;
import xyz.cafeconleche.web.aws.vo.BabyName;

@RestController
@RequestMapping(value={"/babyNames"}, produces="application/json; charset=UTF-8")
public class BabyNamesController {

	@Autowired
	private BabyNamesService babyNamesService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<BabyName>> list() {
		
		List<BabyName> babyNames = babyNamesService.findAll();
		return ResponseEntity.ok(babyNames);
	}

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public ResponseEntity<BabyName> get(@PathVariable("name") String name) {
		
		BabyName babyName = babyNamesService.findByName(name);
		return ResponseEntity.ok(babyName);
	}
		
	@ApiOperation(value = "Add", notes="Adds up to 20 names")
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<BabyName> add(@RequestBody BabyName babyName) {

		long count = babyNamesService.count();
		if(count < 20) {
			Random rand = new Random();
			babyName.setId(rand.nextInt());
			babyName = babyNamesService.save(babyName);
			return ResponseEntity.status(HttpStatus.CREATED).body(babyName);
		}

		return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
	}

	@RequestMapping(value = "/{name}", method = RequestMethod.PUT)
	public ResponseEntity<BabyName> update(@PathVariable("name") String name, @RequestBody BabyName babyName) {

		BabyName temp = babyNamesService.findByName(name);
		
		if(temp != null){
			babyName.setName(name);
			babyName = babyNamesService.upcate(babyName);
			return ResponseEntity.ok(babyName);
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	@RequestMapping(value = "/{name}", method = RequestMethod.DELETE)
	public ResponseEntity<BabyName> delete(@PathVariable("name") String name) {

		BabyName babyName = babyNamesService.findByName(name);
		if(babyName != null){
			babyName = babyNamesService.delete(babyName);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(babyName);
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
}