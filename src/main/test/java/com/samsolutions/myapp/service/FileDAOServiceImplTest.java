package com.samsolutions.myapp.service;

import com.samsolutions.myapp.dto.LessonFileDTO;
import com.samsolutions.myapp.repository.BlobFileRepository;
import com.samsolutions.myapp.repository.LessonFileRepository;
import com.samsolutions.myapp.service.api.FileDAOService;
import com.samsolutions.myapp.service.impl.FileDAOServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class FileDAOServiceImplTest {

    @Mock
    LessonFileRepository lessonFileRepository;

    @Mock
    BlobFileRepository blobFileRepository;

    @Mock
    DataSource dataSource;

    @InjectMocks
	FileDAOService fileDAOService = new FileDAOServiceImpl(lessonFileRepository,blobFileRepository,dataSource);

    @Test
    public void getFilesShouldCallRepository(){

        //when
        fileDAOService.getFiles();

        //then
        verify(lessonFileRepository).findAll();
    }

    @Test
    public void getFilesShouldReturnNotNullWhenRepositoryReturnEmptyCollection(){

        when(lessonFileRepository.findAll()).thenReturn(Collections.emptyList());

        //when
        List<LessonFileDTO> files = fileDAOService.getFiles();

        //then
        assertThat(files).isNotNull();
    }

    @Test
    public void getFilesShouldReturnEmptyWhenRepositoryReturnEmptyCollection(){

        when(lessonFileRepository.findAll()).thenReturn(Collections.emptyList());

        //when
        List<LessonFileDTO> files = fileDAOService.getFiles();

        //then
        assertThat(files).isEmpty();
    }

}
