package com.samsolutions.myapp.service.api;

import com.samsolutions.myapp.dto.CourseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
	List<CourseDTO> getCourses();

	void addCourse(CourseDTO course); // TODO: 12.07.2019 переписать метод

	CourseDTO getCourseById(long id);

	void deleteCourse(long id);
}
