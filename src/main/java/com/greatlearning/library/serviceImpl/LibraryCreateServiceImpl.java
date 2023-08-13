package com.greatlearning.library.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.library.entity.Library;
import com.greatlearning.library.respository.LibraryRepository;
import com.greatlearning.library.service.LibraryCreateService;

@Service
public class LibraryCreateServiceImpl implements LibraryCreateService {

	@Autowired
	LibraryRepository libraryRepository;

	@Override
	public String addSingleLibrary(Library library) {
		libraryRepository.save(library);
		// it's like commit in db then only it save/persist data in db
		libraryRepository.flush();
		return "Library saved";
	}

	@Override
	public String addAllLibraries(List<Library> libraries) {

		libraryRepository.saveAll(libraries);
		libraryRepository.flush();
		return "All libraries are saved";
	}

	@Override
	public Library addlibraryWithSaveAndFlush(Library library) {
		return libraryRepository.saveAndFlush(library);
	}
}
