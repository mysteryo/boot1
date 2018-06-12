package cz.training.boot1.rest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cz.training.boot1.entity.Car;
import cz.training.boot1.entity.Department;
import cz.training.boot1.entity.Persona;
import cz.training.boot1.rest.Test1RestController.Person;

@RestController
@RequestMapping(path = "/jpa")
public class JPA1TestController {

	@PersistenceContext
	private EntityManager em;
	
	@RequestMapping(path = "/insert1" , method = RequestMethod.GET)
	@Transactional
	public void insert1() {
		Department d = new Department();
		d.setName("tesDep");
		em.persist(d);
		Persona p = new Persona();
		Car cars [] = new Car [2];
		cars[0] = new Car();
		cars[0].setName("Skodovka");
		cars[0].setPersons(new ArrayList<>());
		em.persist(cars[0]);
		cars[1] = new Car();
		cars[1].setName("Felina");
		cars[1].setPersons(new ArrayList<>());
		em.persist(cars[1]);
		
		for(int i = 0; i < 20; i++) {
			
		p.setFirstName("karel");
		p.setLastName("goryl");
		p.setDateOfBirth(LocalDate.now());
		p.setDepartment(d);
		if(i % 3 == 0) {
			p.setCars(Arrays.asList(cars[0]));
		}
		else if (i % 3 == 1) {
			p.setCars(Arrays.asList(cars[1]));
		}
		else p.setCars(new ArrayList<>());
		
		p.getCars().forEach(c -> c.getPersons().add(p));
		em.persist(p);
		
		}
		
	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.GET, path = "/rel1")
	public void rel1() {
		Persona p = em.find(Persona.class,1);
		System.out.println(p.getFirstName());
		System.out.println(p.getLastName());
	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.GET, path = "/rel2")
	public Persona rel2() {
		Persona p = em.createQuery("SELECT p from Persona p JOIN FETCH p.department LEFT JOIN FETCH p.cars where p.id=:id",Persona.class).setParameter("id", 1).
				getSingleResult();
		
		return p;
	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.GET, path = "/rel3")
	public void rel3() {
		Persona p = em.find(Persona.class, 1);
		
		System.out.println(p.getFirstName());
		System.out.println(p.getLastName());
		p.getCars().forEach(c -> System.out.println(c.getId() + "- " + c.getName()));
		System.out.println(p.getDepartment().getName());
	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.GET,path = "person1")
	public Persona persona1() {
		Persona p = em.find(Persona.class	, 1);
		return p;
	}
}
