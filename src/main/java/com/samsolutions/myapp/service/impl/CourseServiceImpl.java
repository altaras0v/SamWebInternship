package com.samsolutions.myapp.service.impl;

import com.samsolutions.myapp.dto.CourseDTO;
import com.samsolutions.myapp.model.Course;
import com.samsolutions.myapp.repository.CourseRepository;
import com.samsolutions.myapp.service.api.CourseService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

	private static final Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);

	private final CourseRepository courseRepository;

	@Autowired
	public CourseServiceImpl(CourseRepository courseRepository) {

		this.courseRepository = courseRepository;
	}

	@Override
	@Transactional
	public List<CourseDTO> getCourses() {
		List<Course> courses = (List<Course>) courseRepository.findAll();
		logger.info("getCourses method");

		return courses
				.stream()
				.map(c -> new CourseDTO(c.getName(), c.getDescription(), c.getFullDescription(), c.getId()))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public void addCourse(CourseDTO course) {
		courseRepository.save(new Course(course.getName(), course.getDescription(),course.getFullDescription()));
	}

	// TODO: 08.07.2019   Написать тесты!!!

	@Override
	@Transactional
	public CourseDTO getCourseById(long id) {
		Course course = courseRepository.findOne(id);
		return new CourseDTO(course.getName(), course.getDescription(), course.getFullDescription(), course.getId());
	}
}
