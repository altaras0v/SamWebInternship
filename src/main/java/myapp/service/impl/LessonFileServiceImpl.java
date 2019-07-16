package myapp.service.impl;

import myapp.dto.LessonFileDTO;
import myapp.model.LessonFile;
import myapp.repository.LessonFileRepository;
import myapp.service.api.LessonFileService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@ComponentScan(basePackages = {"myapp"})
public class LessonFileServiceImpl implements LessonFileService {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);

	@Autowired
	LessonFileRepository lessonFileRepository;

	public LessonFileServiceImpl() {
	}

	@Override
	public List<LessonFileDTO> getFiles() {
		logger.info("getFiles method");
		List<LessonFile> files = (List<LessonFile>) lessonFileRepository.findAll();

		return files
				.stream()
				.map(c -> new LessonFileDTO(c.getId(), c.getName(), c.getDescription()))
				.collect(Collectors.toList());
	}

	@Override
	public List<LessonFileDTO> getFilesByLessonId(int id) {
		logger.info("getFilesByLessonId method");
		List<LessonFile> files = lessonFileRepository.findAllByLessonId(id);

		return files
				.stream()
				.map(c -> new LessonFileDTO(c.getId(), c.getName(), c.getDescription()))
				.collect(Collectors.toList());
	}

	// TODO: 10.07.2019 Make tests!

	@Override
	public LessonFile getFileById(int id) {

		logger.info("getFileById method");

		LessonFile file = lessonFileRepository.findOne(id);
		return file;
	}

	@Override
	public void addFile(LessonFile lessonFile) {
		lessonFileRepository.save(lessonFile);
		logger.info("addFile method");
	}

}
