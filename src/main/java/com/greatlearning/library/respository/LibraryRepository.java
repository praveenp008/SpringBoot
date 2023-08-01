package com.greatlearning.library.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.library.entity.Library;


@Repository //it enables crud operations
public interface LibraryRepository extends JpaRepository<Library, Long> {

	
}
