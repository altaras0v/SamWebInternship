package myapp.service.impl;

import myapp.repository.LessonRepository;
import myapp.service.api.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@Service
@ComponentScan(basePackages = {"myapp"})
public class LessonServiceImpl implements LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    public LessonServiceImpl(){

    }

}
