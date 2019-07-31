package com.samsolutions.myapp.service.impl;

import com.samsolutions.myapp.dto.LessonFileDTO;
import com.samsolutions.myapp.model.BlobFile;
import com.samsolutions.myapp.model.LessonFile;
import com.samsolutions.myapp.repository.BlobFileRepository;
import com.samsolutions.myapp.repository.LessonFileRepository;
import com.samsolutions.myapp.service.api.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of {@link FileService}
 * Adding,getting,removing file from database
 */
@Service
public class FileServiceImpl implements FileService {

	private static final Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

	private final LessonFileRepository lessonFileRepository;

	private final BlobFileRepository blobFileRepository;

	private final DataSource dataSource;

	@Autowired
	public FileServiceImpl(LessonFileRepository lessonFileRepository, BlobFileRepository blobFileRepository, DataSource dataSource) {
		this.lessonFileRepository = lessonFileRepository;
		this.blobFileRepository = blobFileRepository;
		this.dataSource = dataSource;
	}

	/**
	 * Get all LessonFiles from database
	 *
	 * @return list with lessonFile DTOs
	 */
	@Override
	@Transactional
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
	 * @return LessonFile DTOs for this lesson(for view)
	 */
	@Override
	@Transactional
	public List<LessonFileDTO> getFilesByLessonId(long id) {
		logger.info("getFilesByLessonId method");
		List<LessonFile> files = lessonFileRepository.findAllByLessonId(id);

		return files.stream()
				.map(c -> new LessonFileDTO(c.getId(), c.getName(), c.getDescription()))
				.collect(Collectors.toList());
	}

	/**
	 * Get lessonFile from database with this id
	 *
	 * @param id - id of file
	 * @return LessonFile with needed id
	 */
	@Override
	@Transactional
	public LessonFile getFileById(long id) {
		logger.info("getFileById method");

		return lessonFileRepository.findById(id)
				.get();
	}

	/**
	 * Add file to database
	 *
	 * @param lessonFile - name and description of file
	 * @param file       - bytes of file
	 */
	@Override
	@Transactional
	public void addFile(LessonFile lessonFile, byte[] file) {
		lessonFileRepository.save(lessonFile);
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}


		assert connection != null;
		try (PreparedStatement preparedStatement = connection.
				prepareStatement("insert into blob_file(file_id,file) values (?,?)");
			 InputStream inputStream = new ByteArrayInputStream(file)) {

			preparedStatement.setLong(1, lessonFile.getId());
			preparedStatement.setBinaryStream(2, inputStream);
			preparedStatement.executeUpdate();

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		logger.info("addFile method");
	}

	/**
	 * Delete file from database
	 *
	 * @param id - if of file that will be delete
	 */
	@Override
	@Transactional
	public void deleteFile(long id) {
		lessonFileRepository.deleteById(id);

		logger.info("deleteLessonFile method");
	}

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
		return blobFileRepository.findByLessonFileId(id);
	}
}