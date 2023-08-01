package com.greatlearning.library;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;

import com.greatlearning.library.entity.Library;
import com.greatlearning.library.model.FullName;
import com.greatlearning.library.model.GreatLearning;
import com.greatlearning.library.serviceImpl.LibraryReadServiceImpl;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringBootLibraryDesignApplication implements CommandLineRunner {

	@Autowired
	LibraryReadServiceImpl libraryReadServiceImpl;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLibraryDesignApplication.class, args);
		System.out.println("Hello spring boot");
		// this will restart the server automatically, hence dev should not be worried
		// about closing and starting the server
		System.out.println("Hello Dev-Tools");

	}

	@Override
	public void run(String... args) throws Exception {
		/*
		 * GreatLearning greatLearning = new GreatLearning();
		 * greatLearning.setCourseName("Designing micro services with spring boot");
		 * greatLearning.setCourseType("Information Technology"); //
		 * greatLearning.setInstructorName("GL faculty");
		 * 
		 * System.out.println("Great learning object " + greatLearning);
		 * 
		 * System.out.println("Get method for course name " +
		 * greatLearning.getCourseName()); System.out.println("Get course type " +
		 * greatLearning.getCourseType()); System.out.println("Get instructor name " +
		 * greatLearning.getInstructorName());
		 * 
		 * 
		 * GreatLearning greatLearning1 = new
		 * GreatLearning("Desingning micro services with spring boot", "IT",
		 * "GL Faculty");
		 * 
		 * System.out.
		 * println("Great Learning object created using all args constructor " +
		 * greatLearning1);
		 * 
		 * // using all args constructor GreatLearning
		 * 
		 * GreatLearning greatLearningUsingAllArgsConstructor = new GreatLearning(
		 * "Designing micro services with spring boot", "Information Technology",
		 * "GL Faculty"); System.out.println("Using all args constructor " +
		 * greatLearningUsingAllArgsConstructor);
		 * 
		 * // design pattern GreatLearning greatLearningTeleDesignPattern// not
		 * recommended // to use
		 * 
		 * GreatLearning greatLearningTeleDesignPattern = new GreatLearning("SDE",
		 * "IT"); System.out.println("greatLearningTeleDesignPattern " +
		 * greatLearningTeleDesignPattern);
		 * 
		 * // instantiate with builder : this can be without creating new object : this
		 * is // better than telescoping design pattern GreatLearning
		 * greatLearningWithBuiilderDesignPattern =
		 * GreatLearning.builder().courseName("Builder pattern")
		 * .courseType("IT").build();
		 * 
		 * System.out.println("Implementation with Builder pattern " +
		 * greatLearningWithBuiilderDesignPattern);
		 * 
		 * GreatLearning greatLearningOnlyCourseName =
		 * GreatLearning.builder().courseName("Advantage of Builder pattern") .build();
		 * System.out.println("GLOnlyCourseName " + greatLearningOnlyCourseName);
		 * 
		 */

		/*
		 * //for complex object creation using builder
		 * log.info("Executing run() method"); GreatLearning greatLearningComplexObject
		 * = GreatLearning.builder().
		 * courseName("Complex object creation with builder patter") .courseType("IT")
		 * .instructorName(FullName.builder().fistName("Praveen").lastName("Patil").
		 * build()) .build();
		 * //System.out.println("Complex object creation with builder "
		 * +greatLearningComplexObject);
		 * log.info("Complex object creation with builder -> {}",
		 * greatLearningComplexObject);
		 */

		// Execute queries
		// List<Library> libraries = libraryReadServiceImpl.getAllLibrary();
		log.info("Fetch all libraries -> {}", libraryReadServiceImpl.getAllLibrary());

		log.info("Fetch all libraries with No Books -> {}", libraryReadServiceImpl.getAllLibrariesWithNoBooks());

		Page<Library> page = libraryReadServiceImpl.getLibrariesPaged();
		List<Library> libraries = page.get().collect(Collectors.toList());
		log.info("Fetch libraries in Page format ->{}", libraries);

		// above code is written in one line
		log.info("Fetch libraries in Page format ->{}",
				libraryReadServiceImpl.getLibrariesPaged().get().collect(Collectors.toList()));

		log.info("Fetch libraries in custom page format "
				+ libraryReadServiceImpl.getLibrariesCustomPaged(2, 2).get().collect(Collectors.toList()));

		// display with latest order
		log.info("Fetch libraries with latest added order ->{}", libraryReadServiceImpl.getLirariesWithLatestOrder());

		log.info("Fetch libraries custom sorted by id : Ascending -> {}",
				libraryReadServiceImpl.getLibrariesCustomSortedById(Direction.ASC));

		log.info("Fetch libraries custom sorted by id : Descending -> {}",
				libraryReadServiceImpl.getLibrariesCustomSortedById(Direction.DESC));

		log.info("Fetch libraries custom sorted by name : Ascending -> {}",
				libraryReadServiceImpl.getLibrariesCustomSortedByName(Direction.ASC));

		log.info("Fetch libraries custom sorted by name : Descending -> {}",
				libraryReadServiceImpl.getLibrariesCustomSortedByName(Direction.DESC));

		log.info("Fetch libraries default paged sorted and with these books -> {} ", libraryReadServiceImpl
				.getibrariesPageAndSortedWithTheseBooks("xyz, abc, efg").get().collect(Collectors.toList()));
	}

}
