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

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
        courseList.add(courseOne); courseList.add(courseTwo);
        return courseList;
    }

    @Test
    public void getCoursesShouldCallRepository () {

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
        List<CourseDTO>  coursesList = courseService.getCourses();

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
 /*   @Test
    public void getCourseNamesShouldReturnNotNull() {

        when(courseRepository.findAll()).thenReturn(createCourseList());

        //then
        List<String> namesList = courseServiceImpl.getCoursesNames();
        assertThat(namesList).isNotNull();
    }
 */
   /*
   @Test
   public void getCourseNamesShouldReturnNames() {


        when(courseRepository.findAll()).thenReturn(createCourseList());

        //when
        List<String> namesList = courseServiceImpl.getCoursesNames();

        //then
        assertThat(namesList).containsExactly("My Course 1", "My Course 2");
    }

    @Test
    public void getCourseDescriptionShouldReturnNotNull() {
        when(courseRepository.findAll()).thenReturn(createCourseList());

        //then
        List<String> descList = courseServiceImpl.getCoursesDescription();
        assertThat(descList).isNotNull();

    }

    @Test
    public void getCourseDescriptionShouldReturnNames() {

        when(courseRepository.findAll()).thenReturn(createCourseList());

        //when
        List<String> descList = courseServiceImpl.getCoursesDescription();

        //then
        assertThat(descList).containsExactly("Desc1", "Desc2");
    }

   */

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

        assertThat(courseDTOList.get(0).getName().contains("My Course 1")&&courseDTOList.get(0).getDescription().contains("Desc1")).isTrue();
        assertThat(courseDTOList.get(1).getName().contains("My Course 2")&&courseDTOList.get(1).getDescription().contains("Desc2")).isTrue();
    }

}
