package myapp.service.api;

import myapp.dto.CourseDTO;

import java.util.List;

public interface CourseService {
    List<CourseDTO> getCourses();
}
