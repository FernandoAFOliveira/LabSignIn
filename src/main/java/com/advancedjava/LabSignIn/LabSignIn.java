//File: src/main/java/com/advancedjava/LabSignIn/

package com.advancedjava.LabSignIn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan; // Import statement for EntityScan

@SpringBootApplication
@EntityScan(basePackages = { "com.advancedjava.LabSignIn.model" })
public class LabSignIn {

	public static void main(String[] args) {
		SpringApplication.run(LabSignIn.class, args);
	}

}
