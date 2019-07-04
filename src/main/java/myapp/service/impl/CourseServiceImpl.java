package myapp.service.impl;

import myapp.dto.CourseDTO;
import myapp.model.Course;
import myapp.repository.CourseRepository;
import myapp.repository.CustomizedCoursesNameRepository;
import myapp.service.api.CourseService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

// inject to coursecontroller
// return list of dto
// это в jsp (в модель)
// и вывести в bootstrap

@Service
@ComponentScan(basePackages = {"myapp"})
public class CourseServiceImpl implements CourseService {
    private  static final org.slf4j.Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);

    // где создавать объект
    // где вызывать add


    @Autowired
    private CourseRepository courseRepository;


    @Autowired
    private CustomizedCoursesNameRepository customizedCoursesNameRepository;



    public CourseServiceImpl(){

        //getCourses();
       // CreateCoursesDTO();
      // System.out.println(getCourses().toString());

    }

    @Override
    @Transactional
    public List<CourseDTO> getCourses() {
        List<Course> courses = (List<Course>) courseRepository.findAll();
       // logger.info("getCourses method");

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

    //Написать тесты!!!
    @Override
    @Transactional
    public CourseDTO getCourseById(int id) {
        Course course = courseRepository.findById(id);
        return new CourseDTO(course.getName(),course.getDescription(),course.getFullDescription(),course.getId());
    }
}
