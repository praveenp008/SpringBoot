
package com.greatlearning.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.library.model.GreatLearning;
import com.greatlearning.library.service.ExampleService;

//@Controller
@RestController
public class ExampleContoller {

	// injecting service class in controller
	@Autowired
	ExampleService exampleService;

	@GetMapping("/info")
	// @ResponseBody
	public GreatLearning get() {
		/*
		 * GreatLearning greatLearning = new GreatLearning();
		 * greatLearning.setCourseName("learn controllers in spring boot");
		 * greatLearning.setCourseType("Information Technology"); //
		 * greatLearning.setInstructorName("GL Faculty"); return greatLearning;
		 */

		return exampleService.get();

	}

	@PostMapping("/customInfo")
	public GreatLearning customInfo(String courseName, String courseType, String firstName, String lastName) {
		/*
		 * GreatLearning greatLearning = new GreatLearning();
		 * greatLearning.setCourseName(courseName);
		 * greatLearning.setCourseType(courseType); //
		 * greatLearning.setInstructorName(instructorName); return greatLearning;
		 */

		return exampleService.customInfo(courseName, courseType, firstName, lastName);
	}

}
