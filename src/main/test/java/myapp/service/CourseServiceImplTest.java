package myapp.service;

import myapp.dto.CourseDTO;
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

@RunWith(MockitoJUnitRunner.class)
public class CourseServiceImplTest {

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private CourseService courseService = new CourseServiceImpl();

    @InjectMocks
    private CourseServiceImpl courseServiceImpl = new CourseServiceImpl();

    @Test
    public void getCoursesShouldCallRepository () {

        //when
        courseService.getCourses();
       // courseServiceImpl.getCourseList();

        //then
        verify(courseRepository).findAll();
    }

    @Test
    public void getCoursesShouldReturnNotNullListWhenRepositoryReturnEmptyCollection() {
        //
        when(courseRepository.findAll()).thenReturn(Collections.emptyList());

        //when
        List<CourseDTO> courses = courseService.getCourses();

        //then
        assertThat(courses).isNotNull();
    }

    @Test
    public void getCoursesShouldReturnEmptyListWhenRepositoryReturnEmptyCollection() {
        //
        when(courseRepository.findAll()).thenReturn(Collections.emptyList());

        //when
        List<CourseDTO> courses = courseService.getCourses();

        //then
        assertThat(courses).isEmpty();
    }
}
