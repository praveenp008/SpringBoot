package com.greatlearning.library.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.greatlearning.library.entity.Library;
import com.greatlearning.library.respository.LibraryRepository;
import com.greatlearning.library.service.LibraryReadService;

@Service
public class LibraryReadServiceImpl implements LibraryReadService {

	@Autowired
	LibraryRepository readRepository;

	@Override
	public List<Library> getAllLibrary() {
		return readRepository.findAll();
	}

	@Override
	public List<Library> getAllLibrariesWithNoBooks() {

		Library libraryWithNoBooks = new Library();
		libraryWithNoBooks.setCommaSeperatedBooknames("");
		System.out.println("How this lib looks " + libraryWithNoBooks);

		// Below ExampleMatcher will make sure that only commaseperated considered //

		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSepearatedBooknames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");

		Example<Library> example = Example.of(libraryWithNoBooks, exampleMatcher);
		return readRepository.findAll(example);
	}

	@Override
	public Page<Library> getLibrariesPaged() {

		PageRequest pageable = PageRequest.of(1, 3);
		return readRepository.findAll(pageable);

	}

	@Override
	public Page<Library> getLibrariesCustomPaged(int pageNumber, int numberOfRecordsOnAPage) {
		PageRequest pageable = PageRequest.of(pageNumber, numberOfRecordsOnAPage);
		return readRepository.findAll(pageable);

	}

	@Override
	public List<Library> getLirariesWithLatestOrder() {
		return readRepository.findAll(Sort.by(Direction.DESC, "id"));
	}

	@Override
	public List<Library> getLibrariesCustomSortedById(Direction direction) {
		return readRepository.findAll(Sort.by(direction, "id"));
	}

	@Override
	public List<Library> getLibrariesCustomSortedByName(Direction direction) {
		return readRepository.findAll(Sort.by(direction, "name"));
	}

	@Override
	public Page<Library> getibrariesPageAndSortedWithTheseBooks(String commaSeperatedBookNames) {

		Library libraryWithTheseBooks = new Library();
		libraryWithTheseBooks.setCommaSeperatedBooknames(commaSeperatedBookNames);
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

	@Override
	public Page<Library> getLibrariesPageAndSortByName() {
		PageRequest pageable = PageRequest.of(0, 2, Sort.by("name"));
		return readRepository.findAll(pageable);
	}

	@Override
	public Page<Library> getLibrariesCustomSortedWithDeafaultOrderByNameAndWithTheseBooks(
			String commaSeperatedBookNames, int pageNumber, int numberOfRecordsOnAPage) {

		Library libraryWithTheseBooks = new Library();
		libraryWithTheseBooks.setCommaSeperatedBooknames(commaSeperatedBookNames);
		System.out.println("How this lib looks " + libraryWithTheseBooks);

		// Below ExampleMatcher will make sure that only commaseperated considered
		// id and name are ignored

		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSepearatedBooknames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");

		Example<Library> example = Example.of(libraryWithTheseBooks, exampleMatcher);

		PageRequest customePage = PageRequest.of(pageNumber, numberOfRecordsOnAPage, Sort.by("name"));

		return readRepository.findAll(example, customePage);

	}

	@Override
	public List<Library> getSortedByNameWithTheseBooks(String commaSeperatedBookNames) {

		Library libraryWithTheseBooks = new Library();
		libraryWithTheseBooks.setCommaSeperatedBooknames(commaSeperatedBookNames);
		System.out.println("How this lib looks " + libraryWithTheseBooks);

		// Below ExampleMatcher will make sure that only commaseperated considered
		// id and name are ignored

		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSepearatedBooknames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");

		Example<Library> example = Example.of(libraryWithTheseBooks, exampleMatcher);

		return readRepository.findAll(example, Sort.by("name"));

	}

	@Override
	public List<Library> getLibrariesByIds(List<Long> ids) {
		return readRepository.findAllById(ids);

	}

	@Override
	public Optional<Library> getLibrariesById(Long id) {
		return readRepository.findById(id);

	}

	@Override
	public Optional<Library> getLibrariesWithTheseBooks(String commaSeperatedBookNames) {
		Library libraryWithTheseBooks = new Library();
		libraryWithTheseBooks.setCommaSeperatedBooknames(commaSeperatedBookNames);

		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSepearatedBooknames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<Library> example = Example.of(libraryWithTheseBooks, exampleMatcher);
		return readRepository.findOne(example);
	}
	
	
	
	
}
