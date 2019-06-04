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

  /*  public CourseServiceImpl(){
       SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        System.out.println("************");
        List<Course> courseList = (List<Course>) courseRepository.findAll();
        System.out.println(courseRepository.findAll());
        System.out.println("*******************************");
       //testMethod();
    }*/

    /*@Transactional
    public void testMethod() {
*//*
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        courseRepository = ctx.getBean(CourseRepository.class);
*//*
        *//*Course course = new Course();
        course.setId(1);
        course.setName("First name");
        course.setDecription("First desc");
        courseRepository.save(course);*//*

        List<Course> courseList = (List<Course>) courseRepository.findAll();
        System.out.println("*******************************");
        System.out.println(courseRepository.findAll()); //выведет лист

        // Создание DTO
       // System.out.println(courseList);
        //CourseDTO firstDto = new CourseDTO(courseList.get(0).getName(),courseList.get(0).getDescription());
        //System.out.println(firstDto.getDescription());

        //вывести по имени

       *//* customizedCoursesNameRepository = ctx.getBean(CustomizedCoursesNameRepository.class);
        Optional<Course>  courseOptional = customizedCoursesNameRepository.findByname("Irish");
        System.out.println(courseOptional.toString()); // *//*
       List<String> userNameOfCourse = new ArrayList<>();
       String userData = "I";
        for (Course course:courseList){
            if (course.getName().contains(userData))
            userNameOfCourse.add(course.getName());
        }
        System.out.println(userNameOfCourse.toString());
    }*/
/*    @Transactional
    public List<String> getNamesLikeUserData(){
*//*
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        courseRepository = ctx.getBean(CourseRepository.class);
*//*
        List<Course> courseList = (List<Course>) courseRepository.findAll();
        List<String> userNameOfCourse = new ArrayList<>();
        String userData = "I";
        for (Course course:courseList){
            if (course.getName().contains(userData))
                userNameOfCourse.add(course.getName());
        }
        return userNameOfCourse;
    }*/

 /*   private List<CourseDTO> courseDTOList;
    private  List<Course> courseList;
    private List<String> coursesNames;
    public List<String> getCoursesNames(){
        coursesNames = new ArrayList<>();
        for (Course course:getCourseList()){
            coursesNames.add(course.getName());
        }
        return coursesNames;
    }
    private List<String> coursesDescription;
*/

//    private List<Course> getCourseList(){
//
//    }

//    public List<String> getCoursesDescription(){
//        coursesDescription = new ArrayList<>();
//        for (Course course:getCourseList()){
//            coursesDescription.add(course.getDescription());
//        }
//        return coursesDescription;
//    }
//

/*
    public void createCoursesDTO(){
        courseDTOList = new ArrayList<>();
        CourseDTO courseDTO1 = new CourseDTO(getCoursesNames().get(0),getCoursesDescription().get(0));
        CourseDTO courseDTO2 = new CourseDTO(getCoursesNames().get(1),getCoursesDescription().get(1));
        courseDTOList.add(courseDTO1);
        courseDTOList.add(courseDTO2);
    }
*/

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
                .map(c -> new CourseDTO(c.getName(), c.getDescription()))
                .collect(Collectors.toList());
        }

}
