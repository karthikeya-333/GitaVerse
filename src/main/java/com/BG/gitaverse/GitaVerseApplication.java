package com.BG.gitaverse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class GitaVerseApplication {

	public static void main(String[] args) {
		SpringApplication.run(GitaVerseApplication.class, args);
	}

}
