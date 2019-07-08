package myapp.controller;

import myapp.dto.CourseDTO;
import myapp.dto.LessonDTO;
import myapp.model.Lesson;
import myapp.service.api.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @RequestMapping(value = { "/courses"}, method = RequestMethod.GET)
    public ModelAndView getLesson() {

        List<LessonDTO> listLesson = lessonService.getLessons();

        ModelAndView modelAndView = new ModelAndView("courses");
        modelAndView.addObject("listsLesson", listLesson);

        return modelAndView;

    }

}
