package Introduce.introduce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@PropertySource("classpath:/env.properties")
public class IntroduceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntroduceApplication.class, args);
	}

}
