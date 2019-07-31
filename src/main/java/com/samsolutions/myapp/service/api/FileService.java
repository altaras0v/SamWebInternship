package com.samsolutions.myapp.service.api;

import com.samsolutions.myapp.dto.LessonFileDTO;
import com.samsolutions.myapp.model.BlobFile;
import com.samsolutions.myapp.model.LessonFile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FileService {

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
	 * Add file
	 *
	 * @param lessonFile - name and description of file
	 * @param file - bytes of file
	 */
	void addFile(LessonFile lessonFile, byte[] file);

	/**
	 * Delete file
	 *
	 * @param id - if of file that will be delete
	 */
	void deleteFile(long id);

	/**
	 * Get file for this LessonFile
	 *
	 * @param id - LessonFile id
	 * @return BlobFile (bytes)
	 */
	BlobFile getFileByLessonFileId(long id);
}
