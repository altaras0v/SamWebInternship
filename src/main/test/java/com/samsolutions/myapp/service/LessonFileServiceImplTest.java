package com.samsolutions.myapp.service;

import com.samsolutions.myapp.dto.LessonFileDTO;
import com.samsolutions.myapp.repository.LessonFileRepository;
import com.samsolutions.myapp.service.api.LessonFileService;
import com.samsolutions.myapp.service.impl.LessonFileServiceImpl;
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
public class LessonFileServiceImplTest {

    @Mock
    LessonFileRepository lessonFileRepository;

    @InjectMocks
    LessonFileService lessonFileService = new LessonFileServiceImpl(lessonFileRepository);

    @Test
    public void getFilesShouldCallRepository(){

        //when
        lessonFileService.getFiles();

        //then
        verify(lessonFileRepository).findAll();
    }

    @Test
    public void getFilesShouldReturnNotNullWhenRepositoryReturnEmptyCollection(){

        when(lessonFileRepository.findAll()).thenReturn(Collections.emptyList());

        //when
        List<LessonFileDTO> files = lessonFileService.getFiles();

        //then
        assertThat(files).isNotNull();
    }

    @Test
    public void getFilesShouldReturnEmptyWhenRepositoryReturnEmptyCollection(){

        when(lessonFileRepository.findAll()).thenReturn(Collections.emptyList());

        //when
        List<LessonFileDTO> files = lessonFileService.getFiles();

        //then
        assertThat(files).isEmpty();
    }

}
