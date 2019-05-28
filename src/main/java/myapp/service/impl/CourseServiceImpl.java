package myapp.service.impl;

import myapp.CourseRepository;
import myapp.dto.CourseDTO;
import myapp.model.Course;
import myapp.service.api.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// inject to coursecontroller
// return list of dto
// это в jsp (в модель)
// и вывести в bootstrap

@Service
public class CourseServiceImpl implements CourseService {

    // где создавать объект
    // где вызывать add
    //@Autowired
    private CourseRepository courseRepository;

    @Transactional
    public void testMethod() {

        System.out.println("*******************************");
        System.out.println(courseRepository.findAll());
    }



    private List<CourseDTO> courseDTOList;

    public CourseServiceImpl(){
        courseDTOList = new ArrayList<>();
        CourseDTO courseDTO1 = new CourseDTO("English","Learn English language1qqqq");
        CourseDTO courseDTO2 = new CourseDTO("Spanish","Learn Spanish Language");
        courseDTOList.add(courseDTO1);
        courseDTOList.add(courseDTO2);

    }

    @Override
    public List<CourseDTO> getCourses() {
        return courseDTOList;
    }

}
