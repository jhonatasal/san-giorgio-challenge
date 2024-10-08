package br.com.compass.uol.san_giorgio_challenge;

import br.com.compass.uol.san_giorgio_challenge.adapter.config.BaseComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@BaseComponentScan
public class SanGiorgioChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SanGiorgioChallengeApplication.class, args);
	}

}
