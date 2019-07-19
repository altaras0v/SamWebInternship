package com.samsolutions.myapp.service.api;

import com.samsolutions.myapp.dto.LessonDTO;
import com.samsolutions.myapp.model.Lesson;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LessonService {
	List<LessonDTO> getLessons();

	List<LessonDTO> getLessonsByCourseId(long id);

	LessonDTO getLessonById(long id);

	void deleteLesson(long id);

	void addLesson(Lesson lesson);
}
