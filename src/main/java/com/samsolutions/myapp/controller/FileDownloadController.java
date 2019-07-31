package com.samsolutions.myapp.controller;

import com.samsolutions.myapp.model.BlobFile;
import com.samsolutions.myapp.model.LessonFile;
import com.samsolutions.myapp.service.api.FileService;
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
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * * Controller for downloading files
 */
@Controller
public class FileDownloadController {

	private static final Logger logger = LoggerFactory.getLogger(FileDownloadController.class);

	private static final String APPLICATION_PDF = "application/octet-stream";

	private final FileService fileService;



	/**
	 * Controller for files
	 *
	 * @param fileService - service for lessonFile (name and description of file)
	 */
	@Autowired
	public FileDownloadController(FileService fileService)
	{
		this.fileService = fileService;
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

		LessonFile lessonFile = fileService.getFileById(id);
		BlobFile blobFile = fileService.getFileByLessonFileId(lessonFile.getId());
		byte[] bytes = blobFile.getFile();


		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		outputStream.write(bytes);
		outputStream.close();

		ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);

		response.setCharacterEncoding("utf-8");
		response.setContentType(APPLICATION_PDF);
		response.setHeader("Content-Type", "application/octet-stream; charset=utf-8");
		String filename = URLEncoder.encode(lessonFile.getName(),"UTF-8");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
		response.setHeader("Content-Length", String.valueOf(bytes.length));
		FileCopyUtils.copy(inputStream, response.getOutputStream());

		logger.info("download file controller");
	}
}