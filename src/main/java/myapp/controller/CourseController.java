package myapp.controller;

import myapp.dto.CourseDTO;
import myapp.model.Course;
import myapp.service.api.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Controller for courses (courses.jsp)
 */
@Controller
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    /**
     * Get courses from database and set them to list
     * @return modelAndView - list of courses
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public  ModelAndView getCourse() {

        List<CourseDTO> listCourses = courseService.getCourses();

        ModelAndView modelAndView = new ModelAndView("courses");
        modelAndView.addObject("listsCourses", listCourses);

        return modelAndView;

    }

    /**
     * Send to JSP DTO
     * @return mav - courseDTO
     */
    @RequestMapping(value = "/AddCourse", method = RequestMethod.GET)
    public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("AddCourse");
        mav.addObject("course", new CourseDTO());
        return mav;
    }

    //СДЕЛАТЬ РЕДИРЕКТ
    // TODO: 12.07.2019 Переделать метод. В БД - энтити 
    /**
     *  Add course to database
     * @param course - CourseDTO
     * @return - view where adding course
     */
    @RequestMapping(value = "/AddCourse", method = RequestMethod.POST)
    public ModelAndView AddCourse(HttpServletRequest request, @ModelAttribute("course")  CourseDTO course,
                                   HttpServletResponse response) {
       // courseService.editUser(user);
        ModelAndView mav = new ModelAndView("AddCourse");
        courseService.addCourse(course);
        //List users = userService.getAll();
        //mav.addObject("usersList", users);
        return mav;
    }



}