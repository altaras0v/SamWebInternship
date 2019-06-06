package myapp.service.impl;

import myapp.dto.CourseDTO;
import myapp.model.Course;
import myapp.repository.CourseRepository;
import myapp.repository.CustomizedCoursesNameRepository;
import myapp.service.api.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

// inject to coursecontroller
// return list of dto
// это в jsp (в модель)
// и вывести в bootstrap

@Service

@ComponentScan(basePackages = {"myapp"})
public class CourseServiceImpl implements CourseService {

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

        return courses
                .stream()
                .map(c -> new CourseDTO(c.getName(), c.getDescription(), c.getId()))
                .collect(Collectors.toList());
        }

    @Override
    @Transactional
    public void addCourse(Course course) {
        courseRepository.save(course);
    }

}
