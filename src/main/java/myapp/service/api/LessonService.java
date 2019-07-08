package myapp.service.api;

import myapp.dto.LessonDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LessonService {
    List<LessonDTO> getLessons();
}
