package com.samsolutions.myapp.controller;

import com.samsolutions.myapp.model.BlobFile;
import com.samsolutions.myapp.model.LessonFile;
import com.samsolutions.myapp.service.api.BlobFileService;
import com.samsolutions.myapp.service.api.LessonFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * * Controller for downloading files
 */
@Controller
public class FileDownloadController {

	private static final Logger logger = LoggerFactory.getLogger(FileDownloadController.class);

	private static final String APPLICATION_PDF = "application/octet-stream";

	private final LessonFileService lessonFileService;

	private final BlobFileService blobFileService;

	/**
	 * Controller for files
	 *
	 * @param lessonFileService - service for lessonFile (name and description of file)
	 * @param blobFileService   - service for blobFile (bytes of file)
	 */
	@Autowired
	public FileDownloadController(LessonFileService lessonFileService, BlobFileService blobFileService)
	{
		this.lessonFileService = lessonFileService;
		this.blobFileService = blobFileService;
	}

	/**
	 * Download single file from server to user
	 *
	 * @param response - file for downloading
	 * @param request  - id of downloading file
	 */
	@RequestMapping(value = "/download", method = RequestMethod.GET, produces = APPLICATION_PDF)
	public @ResponseBody
	void downloadFile(HttpServletResponse response, HttpServletRequest request) throws IOException
	{

		Long id = Long.parseLong(request.getParameter("id"));


		LessonFile lessonFile = lessonFileService.getFileById(id);
		BlobFile blobFile = blobFileService.getFileByLessonFileId(lessonFile.getId());
		byte[] bytes = blobFile.getFile();
		File file = new File(lessonFile.getName());
		System.out.println(lessonFile.getName());

		FileOutputStream out = new FileOutputStream(file);
		out.write(bytes);
		out.close();

		InputStream in = new FileInputStream(file);
		response.setCharacterEncoding("utf-8");
		response.setContentType(APPLICATION_PDF);
		response.setHeader("Content-Disposition", "attachment; filename=\"" + lessonFile.getName() + "\"");
		response.setHeader("Content-Length", String.valueOf(file.length()));
		FileCopyUtils.copy(in, response.getOutputStream());

		logger.info("download file controller");
	}
}