package com.samsolutions.myapp.service.api;

import com.samsolutions.myapp.model.BlobFile;
import org.springframework.stereotype.Service;

/**
 * Service for BLOB files
 */
@Service
public interface BlobFileService {
	/**
	 * Get file for this LessonFile
	 *
	 * @param id - LessonFile id
	 * @return BlobFile (bytes)
	 */
	BlobFile getFileByLessonFileId(long id);

	/**
	 * Add BlobFile
	 *
	 * @param blobFile - object for adding
	 */
	void addFile(BlobFile blobFile);

	// TODO: 23.07.2019 add comments

	void deleteFile(long id);


}