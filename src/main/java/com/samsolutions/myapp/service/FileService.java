package com.samsolutions.myapp.service;

import com.samsolutions.myapp.config.ApplicationProperties;
import com.samsolutions.myapp.model.BlobFile;
import com.samsolutions.myapp.model.Lesson;
import com.samsolutions.myapp.model.LessonFile;
import com.samsolutions.myapp.service.api.FileDAOService;
import com.samsolutions.myapp.validator.UploadedFile;
import javafx.util.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service

public class FileService {

	private static final Logger logger = LoggerFactory.getLogger(FileService.class);

	private final FileDAOService fileDAOService;

	private ApplicationProperties properties = new ApplicationProperties();

	@Autowired
	public FileService(FileDAOService fileDAOService) {
		this.fileDAOService = fileDAOService;
	}

	public void addFile(UploadedFile uploadedFile, long lessonId) {
		try {
			MultipartFile file = uploadedFile.getFile();
			byte[] bytes = file.getBytes();
			String name = file.getOriginalFilename();
			String desc = uploadedFile.getDescription();
			Lesson lesson = new Lesson();
			lesson.setId(lessonId);
			LessonFile lessonFile = new LessonFile(name, desc, lesson);
			fileDAOService.addFile(lessonFile, bytes);

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("uploadFile method successful");
	}

	@Transactional
	public void deleteFile(long id) {
		fileDAOService.deleteFile(id);
	}

	@Transactional
	public Pair<String, byte[]> getDownloadFile(long id) {

		LessonFile lessonFile = fileDAOService.getFileById(id);
		BlobFile blobFile = fileDAOService.getFileByLessonFileId(lessonFile.getId());
		byte[] bytes = blobFile.getFile();

		return new Pair<>(lessonFile.getName(), bytes);
	}
	@Transactional
	public boolean checkQuestionsIsNotFull(long lessonId) {
		if (fileDAOService.getFilesByLessonId(lessonId)
				.size() < Integer.parseInt(properties.getProperty("file.count"))) {
			return true;
		}
		else {
			return false;
		}
	}
}