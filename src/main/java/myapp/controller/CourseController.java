package myapp.controller;

import myapp.dto.CourseDTO;
import myapp.service.api.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    /*@Autowired
    public CourseController(CourseServiceImpl courseService) {
        this.courseService=courseService;
    }*/


    @RequestMapping(value = {"/index", "/hello", "/", ""}, method = RequestMethod.GET)
    public ModelAndView getCourse() {
/*
        CourseServiceImpl courseService = new CourseServiceImpl();
*/
        List<CourseDTO> listCourses = courseService.getCourses();


        ModelAndView modelAndView = new ModelAndView("courses");
        modelAndView.addObject("listsCourses", listCourses);
        //modelAndView.addObject("nameLikeUser",courseService.getNamesLikeUserData());

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