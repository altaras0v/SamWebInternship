package myapp.service.api;

import myapp.dto.LessonFileDTO;
import myapp.model.LessonFile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LessonFileService {
    List<LessonFileDTO> getFiles();
    List<LessonFileDTO> getFilesByLessonId(int id);
    LessonFile getFileById(int id);
    void addFile(LessonFile lessonFile);

}
