package myapp.service.impl;

import myapp.AppConfig;
import myapp.repository.*;
import myapp.dto.CourseDTO;
import myapp.model.Course;
import myapp.service.api.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        System.out.println("************");
       /* List<Course> courseList = (List<Course>) courseRepository.findAll();
        System.out.println(courseRepository.findAll());
        System.out.println("*******************************");*/
       testMethod();
    }

    @Transactional
    public void testMethod() {
/*
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        courseRepository = ctx.getBean(CourseRepository.class);
*/
        /*Course course = new Course();
        course.setId(1);
        course.setName("First name");
        course.setDecription("First desc");
        courseRepository.save(course);*/

        List<Course> courseList = (List<Course>) courseRepository.findAll();
        System.out.println("*******************************");
        System.out.println(courseRepository.findAll()); //выведет лист

        // Создание DTO
       // System.out.println(courseList);
        //CourseDTO firstDto = new CourseDTO(courseList.get(0).getName(),courseList.get(0).getDescription());
        //System.out.println(firstDto.getDescription());

        //вывести по имени

       /* customizedCoursesNameRepository = ctx.getBean(CustomizedCoursesNameRepository.class);
        Optional<Course>  courseOptional = customizedCoursesNameRepository.findByname("Irish");
        System.out.println(courseOptional.toString()); // */
       List<String> userNameOfCourse = new ArrayList<>();
       String userData = "I";
        for (Course course:courseList){
            if (course.getName().contains(userData))
            userNameOfCourse.add(course.getName());
        }
        System.out.println(userNameOfCourse.toString());
    }
    @Transactional
    public List<String> getNamesLikeUserData(){
/*
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        courseRepository = ctx.getBean(CourseRepository.class);
*/
        List<Course> courseList = (List<Course>) courseRepository.findAll();
        List<String> userNameOfCourse = new ArrayList<>();
        String userData = "I";
        for (Course course:courseList){
            if (course.getName().contains(userData))
                userNameOfCourse.add(course.getName());
        }
        return userNameOfCourse;
    }

    private List<CourseDTO> courseDTOList;

   /* public CourseServiceImpl(){
        courseDTOList = new ArrayList<>();
        CourseDTO courseDTO1 = new CourseDTO("English","Learn English language1qqqq");
        CourseDTO courseDTO2 = new CourseDTO("Spanish","Learn Spanish Language");
        courseDTOList.add(courseDTO1);
        courseDTOList.add(courseDTO2);

    }*/

    @Override
    public List<CourseDTO> getCourses() {
        return courseDTOList;
    }

}
