package org.magnum.mobilecloud.video;


import org.magnum.mobilecloud.video.repository.VideoRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;


@SpringBootApplication
@EnableResourceServer

@EnableJpaRepositories(basePackageClasses = VideoRepository.class)

@Configuration

public class Application {


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
