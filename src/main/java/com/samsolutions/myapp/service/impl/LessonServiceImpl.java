package com.samsolutions.myapp.service.impl;

import com.samsolutions.myapp.dto.LessonDTO;
import com.samsolutions.myapp.model.Lesson;
import com.samsolutions.myapp.repository.LessonRepository;
import com.samsolutions.myapp.service.api.LessonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LessonServiceImpl implements LessonService {

	private static final Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);

	private final LessonRepository lessonRepository;

	@Autowired
	public LessonServiceImpl(LessonRepository lessonRepository) {

		this.lessonRepository = lessonRepository;
	}

	@Override
	@Transactional
	public List<LessonDTO> getLessons() {
		List<Lesson> lessons = (List<Lesson>) lessonRepository.findAll();
		logger.info("getLessons method");

		return lessons.stream()
				.map(c -> new LessonDTO(c.getId(), c.getName(), c.getDescription()))
				.collect(Collectors.toList());
	}

	// TODO: 09.07.2019 Сделать тесты!
	@Override
	public List<LessonDTO> getLessonsByCourseId(long id) {
		logger.info("getLessonsByCourseId");
		List<Lesson> lessons = lessonRepository.findAllByCourseId(id);

		return lessons.stream()
				.map(c -> new LessonDTO(c.getId(), c.getName(), c.getDescription()))
				.collect(Collectors.toList());
	}

	@Override
	public LessonDTO getLessonById(long id) {
		logger.info("getLessonsById method");

		Lesson lesson = lessonRepository.findOne(id);
		return new LessonDTO(lesson.getId(), lesson.getName(), lesson.getDescription());
	}

	@Override
	public void deleteLesson(long id) {
		lessonRepository.delete(id);
		logger.info("deleteLesson method");
	}

	@Override
	public void addLesson(Lesson lesson) {
		lessonRepository.save(lesson);
		logger.info("addLesson method");
	}
}
