package com.samsolutions.myapp.service.impl;

import com.samsolutions.myapp.dto.LessonFileDTO;
import com.samsolutions.myapp.model.LessonFile;
import com.samsolutions.myapp.repository.LessonFileRepository;
import com.samsolutions.myapp.service.api.LessonFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of {@link LessonFileService}
 */
@Service
public class LessonFileServiceImpl implements LessonFileService {

	private static final Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);

	private final LessonFileRepository lessonFileRepository;

	/**
	 * Constructor with needed repository
	 *
	 * @param lessonFileRepository - repository for LessonFile
	 */
	@Autowired
	public LessonFileServiceImpl(LessonFileRepository lessonFileRepository) {
		this.lessonFileRepository = lessonFileRepository;
	}

	/**
	 * Get all LessonFiles from database
	 *
	 * @return list with lessonFile DTOs
	 */
	@Override
	public List<LessonFileDTO> getFiles() {
		logger.info("getFiles method");
		List<LessonFile> files = (List<LessonFile>) lessonFileRepository.findAll();

		return files.stream()
				.map(c -> new LessonFileDTO(c.getId(), c.getName(), c.getDescription()))
				.collect(Collectors.toList());
	}

	/**
	 * Get LessonFiles from database for lesson with this id
	 *
	 * @param id - lesson id
	 * @return
	 */
	@Override
	public List<LessonFileDTO> getFilesByLessonId(long id) {
		logger.info("getFilesByLessonId method");
		List<LessonFile> files = lessonFileRepository.findAllByLessonId(id);

		return files.stream()
				.map(c -> new LessonFileDTO(c.getId(), c.getName(), c.getDescription()))
				.collect(Collectors.toList());
	}

	// TODO: 10.07.2019 Make tests!

	/**
	 * Get lessonFile from database with this id
	 *
	 * @param id - id of file
	 * @return LessonFile with needed id
	 */
	@Override
	public LessonFile getFileById(long id) {

		logger.info("getFileById method");

		LessonFile file = lessonFileRepository.findOne(id);
		return file;
	}

	/**
	 * Add lessonFile to database
	 *
	 * @param lessonFile - object for adding
	 */
	@Override
	public void addFile(LessonFile lessonFile) {
		lessonFileRepository.save(lessonFile);
		logger.info("addFile method");
	}

	@Override
	public void deleteFile(long id)
	{
		lessonFileRepository.delete(id);
		logger.info("deleteLessonFile method");
	}

}
