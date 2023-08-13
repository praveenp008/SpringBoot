package com.greatlearning.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.library.entity.Library;
import com.greatlearning.library.service.LibraryDeleteService;

@RestController
@RequestMapping("/deleteService")
public class LibraryDeleteController {

	// used for dependency injection
	@Autowired
	LibraryDeleteService deleteService;

	@DeleteMapping("/deleteOneLibrary")
	public String deleteOneLibrary(Library library) {
		return deleteService.deleteOnelibrary(library);
	}

	@DeleteMapping("/pruneTable")
	public String pruneTable() {
		return deleteService.pruneTable();
	}

	@DeleteMapping("/deleteAllThese")
	public String deleteAllThese(@RequestBody List<Library> libraries) {
		return deleteService.deleteAllThese(libraries);
	}

	@DeleteMapping("/deleteAllBatch")
	public String deleteAllBatch() {
		return deleteService.deleteAllInBatch();
	}

	@DeleteMapping("/deleteLibraryById")
	public String deleteLibraryById(Long id) {
		return deleteService.deleteById(id);
	}

	//for list we use Requestbody
	@PostMapping("/deleteAllTheseInBatch")
	public String deleteAllTheseInBatch(@RequestBody  List<Library> libraries) {
		return deleteService.deleteAllTheseInBatch(libraries);
	}

}
