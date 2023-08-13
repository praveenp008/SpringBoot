package com.greatlearning.library.service;

import java.util.List;

import com.greatlearning.library.entity.Library;

public interface LibraryDeleteService {

	String deleteOnelibrary(Library library);

	// delete all the records
	String pruneTable();

	// delete specific libraries
	String deleteAllThese(List<Library> libraries);

	// delete all - uses different query than deleteAll -prune
	String deleteAllInBatch();

	String deleteById(Long id);

	String deleteAllTheseInBatch(List<Library> libraries);

}