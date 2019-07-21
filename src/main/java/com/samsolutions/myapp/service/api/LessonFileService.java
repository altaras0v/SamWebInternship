package com.samsolutions.myapp.service.api;

import com.samsolutions.myapp.dto.LessonFileDTO;
import com.samsolutions.myapp.model.LessonFile;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for LessonFile(name and description of file)
 */
@Service
public interface LessonFileService {
	/**
	 * Get all files
	 *
	 * @return list with lessonFile DTOs
	 */
	List<LessonFileDTO> getFiles();

	/**
	 * Get all files for this lesson
	 *
	 * @param id - lesson id
	 * @return list with lessonFile DTOs for lesson
	 */
	List<LessonFileDTO> getFilesByLessonId(long id);

	/**
	 * Get file with needed id (for downloading)
	 *
	 * @param id - id of file
	 * @return LessonFile with this id
	 */
	LessonFile getFileById(long id);

	/**
	 * Add lessonFile
	 *
	 * @param lessonFile - object for adding
	 */
	void addFile(LessonFile lessonFile);

}
