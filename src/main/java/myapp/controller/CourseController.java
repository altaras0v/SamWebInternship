package myapp.controller;

import myapp.dto.CourseDTO;
import myapp.model.Course;
import myapp.service.api.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    /*@Autowired
    public CourseController(CourseServiceImpl courseService) {
        this.courseService=courseService;
    }*/


    @RequestMapping(value = {"/index", "/hello","/courses", "/", ""}, method = RequestMethod.GET)
    public ModelAndView getCourse() {
/*
        CourseServiceImpl courseService = new CourseServiceImpl();
*/
        List<CourseDTO> listCourses = courseService.getCourses();


        ModelAndView modelAndView = new ModelAndView("courses");
        modelAndView.addObject("listsCourses", listCourses);
        //modelAndView.addObject("nameLikeUser",courseService.getNamesLikeUserData());

        return modelAndView;


    }
    @RequestMapping(value = "/AddCourse", method = RequestMethod.GET)
    public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("AddCourse");
        mav.addObject("course", new Course());
        return mav;
    }

    @RequestMapping(value = "/AddCourse", method = RequestMethod.POST)
    public ModelAndView AddCourse(HttpServletRequest request, @ModelAttribute("course")  Course course,
                                   HttpServletResponse response) {
       // courseService.editUser(user);
        ModelAndView mav = new ModelAndView("AddCourse");
        courseService.addCourse(course);
        //List users = userService.getAll();
        //mav.addObject("usersList", users);
        return mav;
    }
}