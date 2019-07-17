package com.samsolutions.myapp.service.api;

import com.samsolutions.myapp.dto.LessonDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LessonService {
	List<LessonDTO> getLessons();

	List<LessonDTO> getLessonsByCourseId(int id);

	LessonDTO getLessonsById(int id);
}
