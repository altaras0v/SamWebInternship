package myapp.service;

import myapp.dto.CourseDTO;
import myapp.model.Course;
import myapp.repository.CourseRepository;
import myapp.service.api.CourseService;
import myapp.service.impl.CourseServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyIterable;
import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CourseServiceImplTest {


    @Mock
    private CourseRepository courseRepository;


    @InjectMocks
    private CourseService courseService = new CourseServiceImpl();


    public List<Course> createCourseList() {
        Course courseOne = new Course();
        courseOne.setName("My Course 1");
        courseOne.setDescription("Desc1");
        Course courseTwo = new Course();
        courseTwo.setName("My Course 2");
        courseTwo.setDescription("Desc2");
        List<Course> courseList = new ArrayList<>();
        courseList.add(courseOne);
        courseList.add(courseTwo);
        return courseList;
    }

    @Test
    public void getCoursesShouldCallRepository() {

        //when
        courseService.getCourses();


        //then
        verify(courseRepository).findAll();
    }

    @Test
    public void getCoursesShouldReturnNotNullListWhenRepositoryReturnEmptyCollection() {
        //
        when(courseRepository.findAll()).thenReturn(Collections.emptyList());

        //when
        List<CourseDTO> coursesList = courseService.getCourses();

        //then
        assertThat(coursesList).isNotNull();
    }

    @Test
    public void getCoursesListShouldReturnEmptyListWhenRepositoryReturnEmptyCollection() {
        //

        when(courseRepository.findAll()).thenReturn(Collections.emptyList());

        //when
        List<CourseDTO> courseList = courseService.getCourses();

        //then
        assertThat(courseList).isEmpty();
    }

    @Test
    public void getCoursesDTOShouldReturnNotNullList() {

        when(courseRepository.findAll()).thenReturn(createCourseList());

        List<CourseDTO> courseDTOList = courseService.getCourses();

        assertThat(courseDTOList).isNotNull();
    }

    @Test
    public void getCoursesDTOShouldReturnNames() {

        when(courseRepository.findAll()).thenReturn(createCourseList());

        List<CourseDTO> courseDTOList = courseService.getCourses();

        assertThat(courseDTOList.get(0).getName().contains("My Course 1") && courseDTOList.get(0).getDescription().contains("Desc1")).isTrue();
        assertThat(courseDTOList.get(1).getName().contains("My Course 2") && courseDTOList.get(1).getDescription().contains("Desc2")).isTrue();
    }

    @Test
    public void addCoursesShouldCallRepository() {
        //given
        CourseDTO course = new CourseDTO();
        //when
        courseService.addCourse(course);
        //then
        verify(courseRepository).save(Mockito.any(Course.class));
    }

    @Test
    public void addCoursesShouldAddCourse() {
        //given
        CourseDTO course1 = new CourseDTO("1","1");
        Course course = new Course(course1.getName(),course1.getDescription());
        when(courseRepository.save(Mockito.any(Course.class))).thenReturn(course);
        //when
        courseService.addCourse(course1);
        //then
        verify(courseRepository,times(1)).save(Mockito.any(Course.class));

    }

}
