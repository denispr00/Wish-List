package owish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

//import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//@SpringBootApplication(scanBasePackages = {"owish.rest", "owish.core"})
@SpringBootApplication
// @EnableJpaAuditing
// @ImportResource("classpath:core-spring.xml")
// @ContextConfiguration("classpath:core-spring.xml")
// @EnableJpaRepositories(basePackages = {"owish.core.dao"})
public class Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}