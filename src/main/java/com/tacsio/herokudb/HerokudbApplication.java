package com.tacsio.herokudb;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class HerokudbApplication {

	public static void main(String[] args) {
		SpringApplication.run(HerokudbApplication.class, args);
	}

}

@RestController
class SampleController {

	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;

	@GetMapping("/")
	public List<String> configs() {
		return Arrays.asList(url, username, password);
	}
}
