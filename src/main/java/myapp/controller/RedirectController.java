package myapp.controller;

import myapp.dto.CourseDTO;
import myapp.model.Course;
import myapp.service.api.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/redirect")
public class RedirectController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = {"/courseRedirect"}, method = RequestMethod.GET)
    public ModelAndView redirectToCourse(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("first"));


        CourseDTO courseDTO = courseService.getCourseById(id);

        ModelAndView modelAndView = new ModelAndView("specificCourse");
        modelAndView.addObject("courseDTO", courseDTO);


        return modelAndView;

    }
}
