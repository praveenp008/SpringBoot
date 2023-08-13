package com.greatlearning.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;

import com.greatlearning.library.entity.Library;

public interface LibraryReadService {

	List<Library> getAllLibrary();

	List<Library> getAllLibrariesWithNoBooks();

	Page<Library> getLibrariesPaged();

	Page<Library> getLibrariesCustomPaged(int pageNumber, int numberOfRecordsOnAPage);

	List<Library> getLirariesWithLatestOrder();

	List<Library> getLibrariesCustomSortedById(Direction direction);

	List<Library> getLibrariesCustomSortedByName(Direction direction);

	Page<Library> getibrariesPageAndSortedWithTheseBooks(String commaSeperatedBookNames);

	Page<Library> getLibrariesPageAndSortByName();

	Page<Library> getLibrariesCustomSortedWithDeafaultOrderByNameAndWithTheseBooks(String commaSeperatedBookNames,
			int pageNumber, int numberOfRecordsOnAPage);

	List<Library> getSortedByNameWithTheseBooks(String commaSeperatedBookNames);

	List<Library> getLibrariesByIds(List<Long> ids);

	Optional<Library> getLibrariesById(Long id);

	Optional<Library> getLibrariesWithTheseBooks(String commaSeperatedBookNames);

}