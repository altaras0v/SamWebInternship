package com.samsolutions.myapp.service.api;

import com.samsolutions.myapp.dto.CourseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for course
 */
@Service
public interface CourseService {
	/**
	 * Get all courses
	 *
	 * @return list with course DTOs
	 */
	List<CourseDTO> getCourses();

	/**
	 * Add course
	 *
	 * @param course - course for adding
	 */
	void addCourse(CourseDTO course);

	/**
	 * Get course with this id
	 *
	 * @param id - id of course
	 * @return - DTO of this course
	 */
	CourseDTO getCourseById(long id);

	/**
	 * delete course
	 *
	 * @param id - id of course that will be delete
	 */
	void deleteCourse(long id);
}
