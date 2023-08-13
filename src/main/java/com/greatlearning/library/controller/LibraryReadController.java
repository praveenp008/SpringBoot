package com.greatlearning.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.library.entity.Library;
import com.greatlearning.library.service.LibraryReadService;

@RestController
@RequestMapping("/readService")
public class LibraryReadController {

	@Autowired
	LibraryReadService readService;

	@GetMapping("/getAllLibrary")
	public List<Library> getAllLibrary() {
		return readService.getAllLibrary();
	}

	@GetMapping("/getAllLibrariesWithNoBooks")
	public List<Library> getAllLibrariesWithNoBooks() {
		return readService.getAllLibrariesWithNoBooks();
	}

	@GetMapping("/getAllLibrariesPaged")
	public Page<Library> getAllLibrariesPaged() {
		return readService.getLibrariesPaged();
	}

	@GetMapping("/getLibrariesCustomPaged")
	public Page<Library> getLibrariesCustomPaged(int pageNumber, int numberOfRecordsOnAPage) {
		return readService.getLibrariesCustomPaged(pageNumber, numberOfRecordsOnAPage);
	}

	@GetMapping("/getLibrariesWithLatestAddedOrder")
	public List<Library> getLibrariesWithLatestAddedOrder() {
		return readService.getLirariesWithLatestOrder();
	}

	@GetMapping("/getLibrariesCustomSortedById")
	public List<Library> getLibrariesCustomSortedById(Direction diection) {
		return readService.getLibrariesCustomSortedById(diection);
	}

	@GetMapping("/getLibrariesCustomSortedByName")
	public List<Library> getLibrariesCustomSortedByName(Direction diection) {
		return readService.getLibrariesCustomSortedByName(diection);
	}

	@GetMapping("/getLibrariesPagedAndSortedByNameWithTheseBooks")
	public Page<Library> getLibrariesPagedAndSortedByNameWithTheseBooks(String commaSeperatedBookNames) {
		return readService.getLibrariesPageAndSortedWithTheseBooks(commaSeperatedBookNames);
	}

	@GetMapping("/getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks")
	public Page<Library> getLibrariesPagedAndSortedByNameWithTheseBooks(String commaSeperatedBookNames, int pageNumber,
			int numberOfRecordsOnPage) {
		return readService.getLibrariesCustomSortedWithDeafaultOrderByNameAndWithTheseBooks(commaSeperatedBookNames,
				pageNumber, numberOfRecordsOnPage);
	}

	@GetMapping("/getSortedByNameWithTheseBooks")
	public List<Library> getSortedByNameWithTheseBooks(String commaSeperatedBookNames) {
		return readService.getSortedByNameWithTheseBooks(commaSeperatedBookNames);
	}

	@GetMapping("/getLibrariesByIds")
	public List<Library> getLibrariesByIds(@RequestBody List<Long> ids) {
		return readService.getLibrariesByIds(ids);
	}

	@GetMapping("/getALibrararyById")
	public Optional<Library> getALibraryById(Long id) {
		return readService.getALibraryById(id);
	}

	// should use for unique record else it gives 500
	@GetMapping("/getALibraryByWithTheseBooks")
	public Optional<Library> getALibraryByWithTheseBooks(String commaSeperatedBookNames) {
		return readService.getLibrariesWithTheseBooks(commaSeperatedBookNames);
	}

	
	@GetMapping("/getLibrariesPagedAndSortedByName")
	public Page<Library> getLibrariesPagedAndSortedByName() {
		return readService.getLibrariesPageAndSortByName();
	}
	 

}
