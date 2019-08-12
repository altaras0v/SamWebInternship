package com.samsolutions.myapp.service;

import com.samsolutions.myapp.dto.CourseDTO;
import com.samsolutions.myapp.model.Course;
import com.samsolutions.myapp.repository.CourseRepository;
import com.samsolutions.myapp.service.impl.CourseDAOServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CourseDAOServiceImplTest {


    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private CourseDAOServiceImpl courseService;

    public List<Course> createCourseList() {
        Course courseOne = new Course();
        courseOne.setName("My Course 1");
        courseOne.setDescription("Desc1");
        courseOne.setFullDescription("FullDesc1");
        Course courseTwo = new Course();
        courseTwo.setName("My Course 2");
        courseTwo.setDescription("Desc2");
        courseTwo.setFullDescription("FullDesc2");
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
        CourseDTO course1 = new CourseDTO("1","1","1");
        Course course = new Course(course1.getName(),course1.getDescription(),course1.getFullDescription());
        when(courseRepository.save(Mockito.any(Course.class))).thenReturn(course);
        //when
        courseService.addCourse(course1);
        //then
        verify(courseRepository,times(1)).save(Mockito.any(Course.class));

    }

}
