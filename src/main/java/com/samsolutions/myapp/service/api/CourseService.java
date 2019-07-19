package com.samsolutions.myapp.service.api;

import com.samsolutions.myapp.dto.CourseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
	List<CourseDTO> getCourses();

	void addCourse(CourseDTO course);

	CourseDTO getCourseById(long id);

	void deleteCourse(long id);
}
