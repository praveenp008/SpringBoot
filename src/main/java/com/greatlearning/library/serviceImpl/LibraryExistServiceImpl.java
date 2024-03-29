package com.greatlearning.library.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.greatlearning.library.entity.Library;
import com.greatlearning.library.respository.LibraryRepository;
import com.greatlearning.library.service.LibraryExistService;

@Service
public class LibraryExistServiceImpl implements LibraryExistService {

	@Autowired
	LibraryRepository libraryRepository;

	@Override
	public boolean checkLibraryExistsById(Long id) {
		return libraryRepository.existsById(id);
	}

	@Override
	public boolean checkLibraryExistsByExample(String commaSeperatedBookNames) {
		Library library = new Library();
		library.setCommaSeperatedBooknames(commaSeperatedBookNames);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeperatedBooknames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("name", "id");

		Example<Library> example = Example.of(library, exampleMatcher);
		return libraryRepository.exists(example);

	}
}
