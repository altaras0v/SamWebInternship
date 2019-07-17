package com.samsolutions.myapp.service.api;

import com.samsolutions.myapp.dto.LessonFileDTO;
import com.samsolutions.myapp.model.LessonFile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LessonFileService {
	List<LessonFileDTO> getFiles();

	List<LessonFileDTO> getFilesByLessonId(int id);

	LessonFile getFileById(int id);

	void addFile(LessonFile lessonFile);

}
