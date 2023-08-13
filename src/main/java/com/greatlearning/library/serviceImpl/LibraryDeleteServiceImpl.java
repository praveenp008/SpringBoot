package com.greatlearning.library.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.library.entity.Library;
import com.greatlearning.library.respository.LibraryRepository;
import com.greatlearning.library.service.LibraryDeleteService;

@Service
public class LibraryDeleteServiceImpl implements LibraryDeleteService {

	@Autowired
	LibraryRepository libraryRepository;

	@Override
	public String deleteOnelibrary(Library library) {
		libraryRepository.delete(library);
		return "Deleted this library: " + library;
	}

	// delete all the records
	@Override
	public String pruneTable() {
		libraryRepository.deleteAll();
		return "Prune complete";
	}

	// delete specific libraries
	@Override
	public String deleteAllThese(List<Library> libraries) {
		libraryRepository.deleteInBatch(libraries);
		return "Delete All complete";
	}

	// delete all - uses different query than deleteAll -prune
	@Override
	public String deleteAllInBatch() {
		libraryRepository.deleteAllInBatch();
		return "Deleted All in Batch completed";
	}

	@Override
	public String deleteById(Long id) {
		libraryRepository.deleteById(id);
		return "Library with id " + id + " is deleted";
	}

	@Override
	public String deleteAllTheseInBatch(List<Library> libraries) {
		libraryRepository.deleteInBatch(libraries);
		return "Delete all the libraries in the list batch mode";
	}

}
