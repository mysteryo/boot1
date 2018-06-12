package cz.training.boot1.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cz.training.boot1.service.Test1Service;

@RestController
@RequestMapping(path="/rest/test1")
public class Test1RestController {
	
	@RequestMapping(path = "/hello",method = RequestMethod.GET)
	public String hello() {
		return "What you looking ats";
	}
	
	@RequestMapping(path = "/hello",method = RequestMethod.POST)
	public String helloPost(@RequestBody String body) {
		return "What you looking at "+body;
	}
	
	@RequestMapping(path = "/path-test/{id}",method = RequestMethod.GET)
	public String pathTest(@PathVariable("id") int id) {
		return "hello " +id;
	}
	
	@RequestMapping(path = "/reqParam",method = RequestMethod.GET)
	public String pathTest(@RequestParam("par1") String par1, @RequestParam("par2") int par2) {
		return "hell no " +par1+" "+par2;
	}
	
	@RequestMapping(path = "/status1/{id}",method = RequestMethod.GET)
	public ResponseEntity<String> status1(@PathVariable("id") int id) {
		if(id !=1 && id != 2) {
			return new ResponseEntity<>("xxx",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<> ("XXX", HttpStatus.OK);
	}
	
	@RequestMapping(path = "/status2/{id}",method = RequestMethod.GET)
	public String status2(@PathVariable("id") int id) {
		if(id !=1 && id != 2) 
			throw new DeniedException();
			return "xxx";
		
		
	}
	
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public static class DeniedException extends RuntimeException{
		
	}
	
	public static class Person {
		private String firstName;
		private String lastName;
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
	}
	
	@RequestMapping(path = "/test-person",method = RequestMethod.GET, produces="application/json")
	public Person p1 () {
		Person p = new Person();
		p.setFirstName("jano");
		p.setLastName("boha");
		return p;
	}
	@RequestMapping(path = "/test-person",method = RequestMethod.POST, produces="application/json", consumes = "application/json")
	public Person p1Post(@RequestBody Person p) {
		System.out.println("P: "+p.getFirstName() + " " +p.getLastName());
		return p;
	}
	
	@Autowired //ala inject
	private Test1Service test1service;
	
	@RequestMapping(path = "hallo" , method = RequestMethod.GET)
	public String hallo() {
	test1service.test1();
	return "Helloworld";
	}
}
	
	
	
	

	
	


