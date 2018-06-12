package cz.training.boot1.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
/*
 * @service - backend
 * repository dao
 * controller rest controller
 */
@Service
public class Test1Service {

	private Logger log = Logger.getLogger(Test1Service.class.getName());
	
	public void test1() {
		log.info("Hello world");
	}
}
