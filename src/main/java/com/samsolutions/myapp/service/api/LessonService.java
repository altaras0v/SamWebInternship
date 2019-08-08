package com.samsolutions.myapp.service.api;

import com.samsolutions.myapp.dto.LessonDTO;
import com.samsolutions.myapp.model.Lesson;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for lesson
 */
@Service
public interface LessonService {

	/**
	 * Get all lessons
	 * @return list with lessons DTOs
	 */
	List<LessonDTO> getLessons();

	/**
	 * Get lessons for this course
	 * @param id - course id
	 * @return list with lessons DTOs with needed course id
	 */
	List<LessonDTO> getLessonsByCourseId(long id);

	/**
	 * Get needed lessons
	 * @param id - lesson id
	 * @return lessonDTO of lesson with this id
	 */
	LessonDTO getLessonById(long id);

	/**
	 * Delete lesson
	 * @param id - lesson id
	 */
	void deleteLesson(long id);

	/**
	 * Add lesson
	 * @param lesson - object for adding
	 */
	void addLesson(Lesson lesson);

	/**
	 * Get lesson for this test
	 * @param id - test id
	 * @return lesson with needed test id
	 */
	Lesson getLessonByTestId(long id);
}
