package myapp.service.impl;

import myapp.dto.CourseDTO;
import myapp.model.Course;
import myapp.repository.CourseRepository;
import myapp.service.api.CourseService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@ComponentScan(basePackages = {"myapp"})
public class CourseServiceImpl implements CourseService {

    private  static final org.slf4j.Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);

    @Autowired
    private CourseRepository courseRepository;

    public CourseServiceImpl(){

    }

    @Override
    @Transactional
    public List<CourseDTO> getCourses() {
        List<Course> courses = (List<Course>) courseRepository.findAll();
        logger.info("getCourses method");

        return courses
                .stream()
                .map(c -> new CourseDTO(c.getName(), c.getDescription(),c.getFullDescription(), c.getId()))
                .collect(Collectors.toList());
        }

    @Override
    @Transactional
    public void addCourse(CourseDTO course) {
        courseRepository.save(new Course(course.getName(),course.getDescription()));
    }

    // TODO: 08.07.2019   Написать тесты!!!

    @Override
    @Transactional
    public CourseDTO getCourseById(int id) {
        //Course course = courseRepository.findById(id);
        Course course = courseRepository.findOne(id);
        return new CourseDTO(course.getName(),course.getDescription(),course.getFullDescription(),course.getId());
    }
}
