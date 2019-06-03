package myapp.service;

import myapp.dto.CourseDTO;
import myapp.model.Course;
import myapp.repository.CourseRepository;
import myapp.service.api.CourseService;
import myapp.service.impl.CourseServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CourseServiceImplTest {

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private CourseService courseService = new CourseServiceImpl();

    @InjectMocks
    private CourseServiceImpl courseServiceImpl = new CourseServiceImpl();

    @Test
    public void getCoursesListShouldCallRepository () {

        //when
        courseServiceImpl.getCourseList();


        //then
        verify(courseRepository).findAll();
    }

    @Test
    public void getCoursesListShouldReturnNotNullListWhenRepositoryReturnEmptyCollection() {
        //
        when(courseRepository.findAll()).thenReturn(Collections.emptyList());

        //when
      //  List<CourseDTO> courses = courseService.getCourses();
        List<Course>  coursesList = courseServiceImpl.getCourseList();

        //then
        //assertThat(courses).isNotNull();
        assertThat(coursesList).isNotNull();
    }

    @Test
    public void getCoursesListShouldReturnEmptyListWhenRepositoryReturnEmptyCollection() {
        //
        when(courseRepository.findAll()).thenReturn(Collections.emptyList());

        //when
        List<Course> courseList = courseServiceImpl.getCourseList();
       // List<CourseDTO> courses = courseService.getCourses();
        //then
       // assertThat(courses).isEmpty();
        assertThat(courseList).isEmpty();
    }
    @Test
    public void getCourseNamesShouldReturnNotNull() {
        //when
        List<String> namesList = courseServiceImpl.getCoursesNames();
        when(courseServiceImpl.getCoursesNames()).thenReturn(namesList);
        // List<CourseDTO> courses = courseService.getCourses();
        assertThat(namesList).isNotNull();
    }
    @Test
    public void getCourseNamesCheckSize() {
        //when
        List<String> namesList = courseServiceImpl.getCoursesNames();
        assertThat(courseServiceImpl.getCoursesNames().size()==courseServiceImpl.getCourseList().size()).isTrue();
    }
    @Test
    public void getCourseDescriptionShouldReturnNotNull() {
        //when
        List<String> descList = courseServiceImpl.getCoursesDescription();
        when(courseServiceImpl.getCoursesNames()).thenReturn(descList);
        // List<CourseDTO> courses = courseService.getCourses();
        assertThat(descList).isNotNull();
    }
    @Test
    public void getCourseDescriptionCheckSize() {
        //when
        assertThat(courseServiceImpl.getCoursesDescription().size()==courseServiceImpl.getCourseList().size()).isTrue();
    }
  /*  @Test
    public void getCoursesDTOShouldReturnNotNullList() {
        //

        courseServiceImpl.getCoursesNames();
        courseServiceImpl.getCoursesDescription();

        courseServiceImpl.createCoursesDTO();
        List<CourseDTO> courseDTOList = courseServiceImpl.getCourses();
        when(courseServiceImpl.getCourses()).thenReturn(courseDTOList);
        // List<CourseDTO> courses = courseService.getCourses();
        assertThat(courseDTOList).isEmpty();
    }*/
    @Test
    public void getCoursesDTOShouldReturnNullList() {
        //


        List<CourseDTO> courseDTOList = courseServiceImpl.getCourses();
        when(courseServiceImpl.getCourses()).thenReturn(courseDTOList);
        assertThat(courseDTOList).isNull();
    }
    // проверить на соответсвие полей
    /*public void checkDTOFields() {
        //
        List<CourseDTO> courseDTOList = courseServiceImpl.getCourses();
        when(courseServiceImpl.getCourses()).thenReturn(courseDTOList);
        // List<CourseDTO> courses = courseService.getCourses();
        assertThat(courseDTOList).isNotNull();
    }*/
}
