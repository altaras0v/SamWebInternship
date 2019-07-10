package myapp.service;

import myapp.dto.LessonFileDTO;
import myapp.model.LessonFile;
import myapp.repository.LessonFileRepository;
import myapp.service.api.LessonFileService;
import myapp.service.impl.LessonFileServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyIterable;
import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.Silent.class)
public class LessonFileServiceImplTest {

    @Mock
    LessonFileRepository lessonFileRepository;

    @InjectMocks
    LessonFileService lessonFileService = new LessonFileServiceImpl();

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
