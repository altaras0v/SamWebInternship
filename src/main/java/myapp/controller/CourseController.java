package myapp.controller;

import myapp.dto.CourseDTO;
import myapp.service.api.CourseService;
import myapp.service.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CourseController {
   /* @Autowired
    @Qualifier("CourseRepository")
    private CourseService courseService;
    @Autowired
    public  void setCourseService(CourseService courseService){
        this.courseService=courseService;
    }*/

    @RequestMapping(value = {"/index", "/hello", "/", ""}, method = RequestMethod.GET)
    public ModelAndView getCourse() {
        CourseServiceImpl courseService = new CourseServiceImpl();
        List<CourseDTO> listCourses = courseService.getCourses();

        ModelAndView modelAndView = new ModelAndView("courses");
        modelAndView.addObject("listsCourses", listCourses);

        return modelAndView;







    /*@GetMapping(value = {"/index", "/courses", "/", ""})
    public String getIndex(){
            return "courses";
    }*/

    /*@RequestMapping("/new")
    public String getWelcome(){
        return "new";
    }*/
    }
}