package com.samsolutions.myapp.service;

import com.samsolutions.myapp.dto.LessonDTO;
import com.samsolutions.myapp.model.Lesson;
import com.samsolutions.myapp.repository.LessonRepository;
import com.samsolutions.myapp.service.api.LessonDAOService;
import com.samsolutions.myapp.service.impl.LessonDAOServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class LessonDAOServiceImplTest {

    @Mock
    private LessonRepository lessonRepository;

    @InjectMocks
    private LessonDAOService lessonDAOService = new LessonDAOServiceImpl(lessonRepository);

    public List<Lesson> createLessonList(){
        Lesson lessonOne = new Lesson();
        lessonOne.setName("First Name");
        lessonOne.setDescription("First Desc");
        Lesson lessonTwo = new Lesson();
        lessonTwo.setName("Second Name");
        lessonTwo.setDescription("Second Desc");
        List<Lesson> lessonList = new ArrayList<>();
        lessonList.add(lessonOne);
        lessonList.add(lessonTwo);
        return lessonList;
    }

    @Test
    public void getLessonsShouldCallRepository(){

        //when
        lessonDAOService.getLessons();

        //then
        verify(lessonRepository).findAll();

    }

    @Test
    public void getLessonsShouldReturnNotNullListWhenRepositoryReturnEmptyCollection() {
        //
        when(lessonRepository.findAll()).thenReturn(Collections.emptyList());

        //when
        List<LessonDTO> lessonsList = lessonDAOService.getLessons();

        //then
        assertThat(lessonsList).isNotNull();
    }

    @Test
    public void getLessonsListShouldReturnEmptyListWhenRepositoryReturnEmptyCollection() {
        //

        when(lessonRepository.findAll()).thenReturn(Collections.emptyList());

        //when
        List<LessonDTO> lessonList = lessonDAOService.getLessons();

        //then
        assertThat(lessonList).isEmpty();
    }

    @Test
    public void getLessonsDTOShouldReturnNotNullList() {
        //

        when(lessonRepository.findAll()).thenReturn(createLessonList());

        //when
        List<LessonDTO> lessonDTOList = lessonDAOService.getLessons();

        //then
        assertThat(lessonDTOList).isNotNull();
    }

    @Test
    public void getLessonsDTOShouldReturnNames() {

        when(lessonRepository.findAll()).thenReturn(createLessonList());

        List<LessonDTO> lessonDTOList = lessonDAOService.getLessons();

        assertThat(lessonDTOList.get(0).getName().contains("First Name") && lessonDTOList.get(0).getDescription().contains("First Desc")).isTrue();
        assertThat(lessonDTOList.get(1).getName().contains("Second Name") && lessonDTOList.get(1).getDescription().contains("Second Desc")).isTrue();
    }


}
