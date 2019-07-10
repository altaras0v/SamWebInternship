package myapp.service.api;

import myapp.dto.LessonFileDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LessonFileService {
    List<LessonFileDTO> getFiles();
    List<LessonFileDTO> getFilesByLessonId(int id);
    LessonFileDTO getFileById(int id);

}
