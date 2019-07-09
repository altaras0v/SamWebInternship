package myapp.service.api;

import myapp.dto.LessonDTO;
import myapp.model.Lesson;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LessonService {
    List<LessonDTO> getLessons();
    List<LessonDTO> getLessonsByCourseId(int id);
    LessonDTO getLessonsById(int id);
}
