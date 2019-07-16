package myapp.service.impl;

import myapp.dto.LessonDTO;
import myapp.model.Lesson;
import myapp.repository.LessonRepository;
import myapp.service.api.LessonService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@ComponentScan(basePackages = {"myapp"})
public class LessonServiceImpl implements LessonService {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);

	@Autowired
	private LessonRepository lessonRepository;

	public LessonServiceImpl() {

	}

	@Override
	@Transactional
	public List<LessonDTO> getLessons() {
		List<Lesson> lessons = (List<Lesson>) lessonRepository.findAll();
		logger.info("getLessons method");

		return lessons
				.stream()
				.map(c -> new LessonDTO(c.getId(), c.getName(), c.getDescription()))
				.collect(Collectors.toList());
	}

	// TODO: 09.07.2019 Сделать тесты!
	@Override
	public List<LessonDTO> getLessonsByCourseId(int id) {
		logger.info("getLessonsByCourseId");
		List<Lesson> lessons = lessonRepository.findAllByCourseId(id);


		return lessons
				.stream()
				.map(c -> new LessonDTO(c.getId(), c.getName(), c.getDescription()))
				.collect(Collectors.toList());
	}

	@Override
	public LessonDTO getLessonsById(int id) {
		logger.info("getLessonsById method");

		Lesson lesson = lessonRepository.findOne(id);
		return new LessonDTO(lesson.getId(), lesson.getName(), lesson.getDescription());
	}
}
