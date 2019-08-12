package com.samsolutions.myapp.service.impl;

import com.samsolutions.myapp.dto.LessonDTO;
import com.samsolutions.myapp.model.Lesson;
import com.samsolutions.myapp.repository.LessonRepository;
import com.samsolutions.myapp.service.api.LessonDAOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of {@link LessonDAOService}
 */
@Service
public class LessonDAOServiceImpl implements LessonDAOService {

	private static final Logger logger = LoggerFactory.getLogger(LessonDAOServiceImpl.class);

	private final LessonRepository lessonRepository;

	/**
	 * Constructor with needed repository
	 *
	 * @param lessonRepository - repository(CRUD) for lesson
	 */
	@Autowired
	public LessonDAOServiceImpl(LessonRepository lessonRepository)
	{

		this.lessonRepository = lessonRepository;
	}

	/**
	 * Gel all lessons from database
	 *
	 * @return list with lesson DTOs
	 */
	@Override
	@Transactional
	public List<LessonDTO> getLessons()
	{
		List<Lesson> lessons = (List<Lesson>) lessonRepository.findAll();
		logger.info("getLessons method");

		return lessons.stream()
				.map(c -> new LessonDTO(c.getId(), c.getName(), c.getDescription()))
				.collect(Collectors.toList());
	}

	// TODO: 09.07.2019 Сделать тесты!

	/**
	 * Get lessons from database for this course
	 *
	 * @param id - course id
	 * @return list with lesson DTOs for needed course (for view)
	 */
	@Override
	@Transactional
	public List<LessonDTO> getLessonsByCourseId(long id)
	{
		logger.info("getLessonsByCourseId");
		List<Lesson> lessons = lessonRepository.findAllByCourseId(id);

		return lessons.stream()
				.map(c -> new LessonDTO(c.getId(), c.getName(), c.getDescription()))
				.collect(Collectors.toList());
	}

	/**
	 * Get lesson from database with this id
	 *
	 * @param id - lesson id
	 * @return lesson DTOs with needed id
	 */
	@Override
	@Transactional
	public LessonDTO getLessonById(long id)
	{
		logger.info("getLessonsById method");

		Lesson lesson = lessonRepository.findById(id).get();
		return new LessonDTO(lesson.getId(), lesson.getName(), lesson.getDescription());
	}

	/**
	 * Delete lesson from database
	 *
	 * @param id - lesson id
	 */
	@Override
	@Transactional
	public void deleteLesson(long id)
	{
		lessonRepository.deleteById(id);
		logger.info("deleteLesson method");
	}

	/**
	 * Add lesson to database
	 *
	 * @param lesson - object for adding
	 */
	@Override
	@Transactional
	public void addLesson(Lesson lesson)
	{
		lessonRepository.save(lesson);
		logger.info("addLesson method");
	}

	/**
	 * Get lesson from database with this test id
	 * @param id - test id
	 * @return - lesson entity with needed test id
	 */
	@Override
	public Lesson getLessonByTestId(long id) {
		logger.info("getLessonByTestId method");
		return lessonRepository.findByTestId(id);
	}
}
