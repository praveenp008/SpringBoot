package com.greatlearning.library.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.greatlearning.library.entity.Library;
import com.greatlearning.library.respository.LibraryRepository;

@Service
public class LibraryReadServiceImpl {

	@Autowired
	LibraryRepository readRepository;

	public List<Library> getAllLibrary() {
		return readRepository.findAll();
	}

	public List<Library> getAllLibrariesWithNoBooks() {

		Library libraryWithNoBooks = new Library();
		libraryWithNoBooks.setCommaSepearatedBooknames("");
		System.out.println("How this lib looks " + libraryWithNoBooks);

		// Below ExampleMatcher will make sure that only commaseperated considered //

		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSepearatedBooknames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");

		Example<Library> example = Example.of(libraryWithNoBooks, exampleMatcher);
		return readRepository.findAll(example);
	}

	public Page<Library> getLibrariesPaged() {

		PageRequest pageable = PageRequest.of(1, 3);
		return readRepository.findAll(pageable);

	}

	public Page<Library> getLibrariesCustomPaged(int pageNumber, int numberOfRecordsOnAPage) {
		PageRequest pageable = PageRequest.of(pageNumber, numberOfRecordsOnAPage);
		return readRepository.findAll(pageable);

	}

	public List<Library> getLirariesWithLatestOrder() {
		return readRepository.findAll(Sort.by(Direction.DESC, "id"));
	}

	public List<Library> getLibrariesCustomSortedById(Direction direction) {
		return readRepository.findAll(Sort.by(direction, "id"));
	}

	public List<Library> getLibrariesCustomSortedByName(Direction direction) {
		return readRepository.findAll(Sort.by(direction, "name"));
	}

	public Page<Library> getibrariesPageAndSortedWithTheseBooks(String commaSeperatedBookNames) {

		Library libraryWithTheseBooks = new Library();
		libraryWithTheseBooks.setCommaSepearatedBooknames("");
		System.out.println("How this lib looks " + libraryWithTheseBooks);

		// Below ExampleMatcher will make sure that only commaseperated considered 
		// id and name are ignored

		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSepearatedBooknames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");

		Example<Library> example = Example.of(libraryWithTheseBooks, exampleMatcher);

		PageRequest first3records = PageRequest.of(0, 1, Sort.by("name"));

		return readRepository.findAll(example, first3records);
	}

}
