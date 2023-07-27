package com.greatlearning.library;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.greatlearning.library.model.GreatLearning;

@SpringBootApplication
public class SpringBootLibraryDesignApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLibraryDesignApplication.class, args);
		System.out.println("Hello spring boot");
		// this will restart the server automatically, hence dev should not be worried
		// about closing and starting the server
		System.out.println("Hello Dev-Tools");

	}

	@Override
	public void run(String... args) throws Exception {
		GreatLearning greatLearning = new GreatLearning();
		greatLearning.setCourseName("Designing micro services with spring boot");
		greatLearning.setCourseType("Information Technology");
		greatLearning.setInstructorName("GL faculty");

		System.out.println("Great learning object " + greatLearning);

		System.out.println("Get method for course name " + greatLearning.getCourseName());
		System.out.println("Get course type " + greatLearning.getCourseType());
		System.out.println("Get instructor name " + greatLearning.getInstructorName());

		GreatLearning greatLearning1 = new GreatLearning("Desingning micro services with spring boot", "IT",
				"GL Faculty");

		System.out.println("Great Learning object created using all args constructor " + greatLearning1);

		// using all args constructor GreatLearning
		GreatLearning greatLearningUsingAllArgsConstructor = new GreatLearning(
				"Designing micro services with spring boot", "Information Technology", "GL Faculty");
		System.out.println("Using all args constructor " + greatLearningUsingAllArgsConstructor);

		// design pattern GreatLearning greatLearningTeleDesignPattern// not recommended
		// to use

		GreatLearning greatLearningTeleDesignPattern = new GreatLearning("SDE", "IT");
		System.out.println("greatLearningTeleDesignPattern " + greatLearningTeleDesignPattern);

		// instantiate with builder : this can be without creating new object : this is
		// better than telescoping design pattern
		GreatLearning greatLearningWithBuiilderDesignPattern = GreatLearning.builder().courseName("Builder pattern")
				.courseType("IT").build();

		System.out.println("Implementation with Builder pattern " + greatLearningWithBuiilderDesignPattern);

		GreatLearning greatLearningOnlyCourseName = GreatLearning.builder().courseName("Advantage of Builder pattern")
				.build();
		System.out.println("GLOnlyCourseName " + greatLearningOnlyCourseName);

	}

}
