package myapp.service.api;

import myapp.dto.CourseDTO;
import myapp.model.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    List<CourseDTO> getCourses();
    void addCourse(Course course);
}
