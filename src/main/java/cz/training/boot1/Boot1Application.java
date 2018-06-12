package cz.training.boot1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.redis.core.convert.Jsr310Converters;
@EntityScan(basePackageClasses = {
		Boot1Application.class,Jsr310JpaConverters.class
})
@SpringBootApplication
public class Boot1Application {

	
	public static void main(String[] args) {
		SpringApplication.run(Boot1Application.class, args);
	}
}
