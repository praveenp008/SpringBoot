package com.greatlearning.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;

import com.greatlearning.library.entity.Library;
import com.greatlearning.library.model.FullName;
import com.greatlearning.library.model.GreatLearning;
import com.greatlearning.library.service.LibraryCountService;
import com.greatlearning.library.service.LibraryCreateService;
import com.greatlearning.library.service.LibraryDeleteService;
import com.greatlearning.library.service.LibraryExistService;
import com.greatlearning.library.service.LibraryReadService;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringBootLibraryDesignApplication implements CommandLineRunner {

	@Autowired
	LibraryReadService libraryReadServiceImpl;

	@Autowired
	LibraryCreateService createServiceImpl;

	@Autowired
	LibraryCountService countServiceImpl;

	@Autowired
	LibraryExistService existServiceImpl;

	@Autowired
	LibraryDeleteService deleteServiceImpl;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLibraryDesignApplication.class, args);
		System.out.println("Hello spring boot");
		// this will restart the server automatically, hence dev should not be worried
		// about closing and starting the server
		System.out.println("Hello Dev-Tools");

	}

	@Override
	public void run(String... args) throws Exception {

		// readServiceImplMethodsExecution();

		// createServiceImplMethodsExecution();

		// countServiceImplMethodsExecution();

		// existServiceImplMethodsExecution();

		// deleteServiceImplMethodsExecution();

	}

	private void deleteServiceImplMethodsExecution() {
		log.info("Delete one library -> {}", deleteServiceImpl
				.deleteOnelibrary(Library.builder().id(13l).commaSeperatedBooknames("").name("G library").build()));

		log.info("Prune library table -> {}", deleteServiceImpl.pruneTable());

		List<Library> libraries = new ArrayList<Library>();
		libraries.add(Library.builder().id(12l).commaSeperatedBooknames("").name("F library").build());
		libraries.add(Library.builder().id(13l).commaSeperatedBooknames("").name("G library").build());
		log.info("Delete all these libraries -> {}", deleteServiceImpl.deleteAllThese(libraries));

		log.info("Delete all in batch -> {}", deleteServiceImpl.deleteAllInBatch());

		log.info("Delete By id -> {}", deleteServiceImpl.deleteById(6l));

		List<Library> librariesone = new ArrayList<Library>();
		librariesone.add(Library.builder().id(12l).commaSeperatedBooknames("").name("F library").build());
		librariesone.add(Library.builder().id(13l).commaSeperatedBooknames("").name("G library").build());

		log.info("Deleted all libraries in batch mode -> {}", deleteServiceImpl.deleteAllTheseInBatch(librariesone));
	}

	private void existServiceImplMethodsExecution() {
		log.info("Check if Library Exists by Id -> {}", existServiceImpl.checkLibraryExistsById(1l));

		log.info("Check if Library Exists by Id to display false -> {}", existServiceImpl.checkLibraryExistsById(20l));

		log.info("Check if Library Exists by example -> {}",
				existServiceImpl.checkLibraryExistsByExample("xyz, abc, efg"));

		log.info("Check if Library Exists by example for false -> {}",
				existServiceImpl.checkLibraryExistsByExample("xyz, abc, efg, asdas"));
	}

	private void countServiceImplMethodsExecution() {
		log.info("count the number of libraries -> {}", countServiceImpl.countLibraries());

		log.info("count the libraries with zero books-> {}", countServiceImpl.countLibrariesWithZeroBooks());
	}

	private void createServiceImplMethodsExecution() {
		log.info("Persist a single library -> {}", createServiceImpl.addSingleLibrary(
				Library.builder().id(12l).name("F library").commaSeperatedBooknames("xyz, abc").build()));

		List<Library> libraries = new ArrayList<Library>();
		libraries.add(Library.builder().id(13l).name("G Library").commaSeperatedBooknames("abc, efg").build());
		libraries.add(Library.builder().id(14l).name("H Library").commaSeperatedBooknames("efg").build());
		log.info("Persist All libraries -> {}", createServiceImpl.addAllLibraries(libraries));

		log.info("Persist a library save and flush combined -> {}", createServiceImpl.addlibraryWithSaveAndFlush(
				Library.builder().id(15l).name("E-Commerce").commaSeperatedBooknames("Amazon, Flipkat").build()));
	}

	private void readServiceImplMethodsExecution() {
		GreatLearning greatLearning = new GreatLearning();
		greatLearning.setCourseName("Designing micro services with spring boot");
		greatLearning.setCourseType("Information Technology");
		// greatLearning.setInstructorName("GL faculty");

		System.out.println("Great learning object " + greatLearning);

		System.out.println("Get method for course name " + greatLearning.getCourseName());
		System.out.println("Get course type " + greatLearning.getCourseType());
		System.out.println("Get instructor name " + greatLearning.getInstructorName());

		// GreatLearning greatLearning1 = new GreatLearning("Desingning micro services
		// with spring boot", "IT", "GL Faculty");

		// System.out.println("Great Learning object created using all args constructor
		// " + greatLearning1);

		// using all args constructor GreatLearning

		// GreatLearning greatLearningUsingAllArgsConstructor = new
		// GreatLearning("Designing micro services with spring boot", "Information
		// Technology", "GL Faculty");
		// System.out.println("Using all args constructor " +
		// greatLearningUsingAllArgsConstructor);

		// design pattern GreatLearning greatLearningTeleDesignPattern// not recommended
		// // to use

		GreatLearning greatLearningTeleDesignPattern = new GreatLearning("SDE", "IT");
		System.out.println("greatLearningTeleDesignPattern " + greatLearningTeleDesignPattern);

		// instantiate with builder : this can be without creating new object : this is
		// better than telescoping design pattern GreatLearning
		// greatLearningWithBuiilderDesignPattern =
		// GreatLearning.builder().courseName("Builder
		// pattern").courseType("IT").build();

		// System.out.println("Implementation with Builder pattern " +
		// greatLearningWithBuiilderDesignPattern);

		GreatLearning greatLearningOnlyCourseName = GreatLearning.builder().courseName("Advantage of Builder pattern")
				.build();
		System.out.println("GLOnlyCourseName " + greatLearningOnlyCourseName);

		// for complex object creation using builder
		log.info("Executing run() method");
		GreatLearning greatLearningComplexObject = GreatLearning.builder()
				.courseName("Complex object creation with builder patter").courseType("IT")
				.instructorName(FullName.builder().fistName("Praveen").lastName("Patil").build()).build();
		System.out.println("Complex object creation with builder " + greatLearningComplexObject);
		log.info("Complex object creation with builder -> {}", greatLearningComplexObject);

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
				.getLibrariesPageAndSortedWithTheseBooks("xyz, abc, efg").get().collect(Collectors.toList()));

		log.info("Fetch libraries default paged and default sorted by name -> {}",
				libraryReadServiceImpl.getLibrariesPageAndSortByName().get().collect(Collectors.toList()));

		log.info("Fetch libraries custome page and default sorted by name and with these books -> {}",
				libraryReadServiceImpl
						.getLibrariesCustomSortedWithDeafaultOrderByNameAndWithTheseBooks("xyz, abc, efg", 0, 3).get()
						.collect(Collectors.toList()));

		log.info("Fetch libraries with default sorted by name -> {}",
				libraryReadServiceImpl.getSortedByNameWithTheseBooks("xyz, abc, efg"));

		List<Long> ids = new ArrayList<Long>();
		ids.add((long) 1);
		ids.add((long) 2);
		log.info("Fetch list of lib by ids -> {}", libraryReadServiceImpl.getLibrariesByIds(ids));

		long id = 12l;
		Optional<Library> optionalLibrary = libraryReadServiceImpl.getALibraryById(id);
		if (optionalLibrary.isPresent()) {
			log.info("Fetch optional lib by id -> {}", optionalLibrary.get());
		} else {
			log.info("No Matchig Optional library found with this id was found in DB", id);
		}

		Optional<Library> SingleoptionalLibrary = libraryReadServiceImpl
				.getLibrariesWithTheseBooks("learn python, learn lex, learn ML");
		if (SingleoptionalLibrary.isPresent()) {
			log.info("Fetch Libraries with these books -> {}", SingleoptionalLibrary.get());
		} else {
			log.info("No Matchig library found with this id ", +id + " was found in DB");
		}
	}

}
