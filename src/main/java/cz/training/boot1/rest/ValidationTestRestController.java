package cz.training.boot1.rest;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cz.training.boot1.entity.Department;

@RestController
@RequestMapping(path = "/test/validation")
@CrossOrigin(origins = "*")
public class ValidationTestRestController {

	@RequestMapping( method = RequestMethod.POST)
	public Department test (@Valid @RequestBody Department dep) {
		return dep;
	}
	
}
