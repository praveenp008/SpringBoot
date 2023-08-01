package com.greatlearning.library.serviceImpl;

import org.springframework.stereotype.Service;

import com.greatlearning.library.model.FullName;
import com.greatlearning.library.model.GreatLearning;
import com.greatlearning.library.service.ExampleService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ExampleServiceImpl implements ExampleService {

	@Override
	public GreatLearning get() {
		log.info("Inside get() method");
		GreatLearning greatLearning = new GreatLearning();
		greatLearning.setCourseName("learn controllers in spring boot");
		greatLearning.setCourseType("Information Technology");
		// greatLearning.setInstructorName("GL Faculty");
		greatLearning.setInstructorName(FullName.builder().fistName("Praveen").lastName("Patil").build());
		return greatLearning;

	}

	@Override
	public GreatLearning customInfo(String courseName, String courseType, String firstName, String lastName) {
		log.info("Inside customInfo() method");
		GreatLearning greatLearning = new GreatLearning();
		greatLearning.setCourseName(courseName);
		greatLearning.setCourseType(courseType);
		// FullName fullName = FullName.builder().fistName("Praveen").lastName("Patil").build();
		greatLearning.setInstructorName(FullName.builder().fistName("Praveen").lastName("Patil").build());
		// greatLearning.setInstructorName(instructorName);
		return greatLearning;

	}
}
