package com.greatlearning.library.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
//if builder is used we no need to write enabling bilder pattern. all done with annotation
@Builder
public class GreatLearning {

	private String courseName;
	private String courseType;
	private String instructorName;
	// 3 factorial constructors can be created for the given varibles. which 3*2=6
	// constructors
	// it's referred as telescpoing constructor design pattern

	/*
	 * // Tele scoping design pattern public GreatLearning() {
	 * 
	 * }
	 */

	
	
	// creating different constructors - con
	public GreatLearning(String courseName) {
		this.courseName = courseName;
	}

	public GreatLearning(String courseName, String courseType) {
		this.courseName = courseName;
		this.courseType = courseType;
	}

	/*
	 * comment for all args constructor annotation
	 */
	/*
	 * public GreatLearning(String courseName, String courseType, String
	 * instructorName) { super(); this.courseName = courseName; this.courseType =
	 * courseType; this.instructorName = instructorName;
	 * 
	 * }
	 */
	/*
	 * // comment for constructor injection method public String getCourseName() {
	 * return courseName; }
	 * 
	 * public void setCourseName(String courseName) { this.courseName = courseName;
	 * }
	 * 
	 * public String getCourseType() { return courseType; }
	 * 
	 * public void setCourseType(String courseType) { this.courseType = courseType;
	 * }
	 * 
	 * public String getInstructorName() { return instructorName; }
	 * 
	 * public void setInstructorName(String instructorName) { this.instructorName =
	 * instructorName; }
	 * 
	 * @Override public String toString() { return "GreatLearning [courseName=" +
	 * courseName + ", courseType=" + courseType + ", instructorName=" +
	 * instructorName + "]"; }
	 */

}
