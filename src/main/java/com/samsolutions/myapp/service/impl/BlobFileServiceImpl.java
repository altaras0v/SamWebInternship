package com.samsolutions.myapp.service.impl;

import com.samsolutions.myapp.model.BlobFile;
import com.samsolutions.myapp.repository.BlobFileRepository;
import com.samsolutions.myapp.service.api.BlobFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Implementation of {@link BlobFileService}
 */
@Service
public class BlobFileServiceImpl implements BlobFileService {

	private static final Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);

	private final BlobFileRepository blobFileRepository;

	/**
	 * Constructor with needed repository
	 *
	 * @param blobFileRepository - repository for BLOB files
	 */
	@Autowired
	public BlobFileServiceImpl(BlobFileRepository blobFileRepository) {
		this.blobFileRepository = blobFileRepository;
	}

	// TODO: 14.07.2019 Make Tests

	/**
	 * Gets file from database with this id
	 *
	 * @param id - LessonFile id
	 * @return - needed blob file
	 */
	@Override
	@Transactional
	public BlobFile getFileByLessonFileId(long id) {
		logger.info("getFileByLessonId method");
		BlobFile blobFile = blobFileRepository.findByLessonFileId(id);
		return blobFile;
	}

	/**
	 * Add file to database
	 *
	 * @param blobFile - object for adding
	 */
	@Override
	@Transactional
	public void addFile(BlobFile blobFile) {
		logger.info("addFile method");
		blobFileRepository.save(blobFile);
	}

	@Override
	public void deleteFile(long id)
	{
		blobFileRepository.delete(id);
		logger.info("deleteFile method");
	}
}
