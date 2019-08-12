package com.samsolutions.myapp.service.impl;

import com.samsolutions.myapp.dto.CourseDTO;
import com.samsolutions.myapp.model.Course;
import com.samsolutions.myapp.repository.CourseRepository;
import com.samsolutions.myapp.service.api.CourseDAOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of {@link CourseDAOService}
 */

@Service
public class CourseDAOServiceImpl implements CourseDAOService {

	private static final Logger logger = LoggerFactory.getLogger(CourseDAOServiceImpl.class);

	private final CourseRepository courseRepository;

	/**
	 * Constructor with needed repository
	 *
	 * @param courseRepository - repository(CRUD) for course
	 */
	@Autowired
	public CourseDAOServiceImpl(CourseRepository courseRepository)
	{

		this.courseRepository = courseRepository;
	}

	/**
	 * Get all courses from database
	 *
	 * @return list with courses DTOs for views
	 */
	@Override
	@Transactional
	public List<CourseDTO> getCourses()
	{
		List<Course> courses = (List<Course>) courseRepository.findAll();
		logger.info("getCourses method");

		return courses.stream()
				.map(c -> new CourseDTO(c.getName(), c.getDescription(), c.getFullDescription(), c.getId()))
				.collect(Collectors.toList());
	}

	/**
	 * Add course to database
	 *
	 * @param course - course for adding
	 */
	@Override
	@Transactional
	public void addCourse(CourseDTO course)
	{
		courseRepository.save(new Course(course.getName(), course.getDescription(), course.getFullDescription()));
		logger.info("addCourses method");
	}

	// TODO: 08.07.2019   Написать тесты!!!

	/**
	 * Get course from database with this is
	 *
	 * @param id - id of course
	 * @return course DTO for view
	 */
	@Override
	@Transactional
	public CourseDTO getCourseById(long id)
	{
		Course course = courseRepository.findById(id).get();
		logger.info("getCourseById method");
		return new CourseDTO(course.getName(), course.getDescription(), course.getFullDescription(), course.getId());
	}

	/**
	 * Delete course from database
	 *
	 * @param id - id of course that will be delete
	 */
	@Override
	@Transactional
	public void deleteCourse(long id)
	{
		courseRepository.deleteById(id);
		logger.info("deleteLesson method");
	}
}
