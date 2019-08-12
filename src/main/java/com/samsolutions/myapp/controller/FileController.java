package com.samsolutions.myapp.controller;

import com.samsolutions.myapp.dto.LessonDTO;
import com.samsolutions.myapp.service.FileService;
import com.samsolutions.myapp.validator.FileValidator;
import com.samsolutions.myapp.validator.UploadedFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Controller for uploading files.
 * lessonId - id of lesson that will have this file
 */
@Controller
@SessionAttributes("lessonId")
public class FileController {

	private static final Logger logger = LoggerFactory.getLogger(FileController.class);

	private final FileService fileService;

	private final FileValidator fileValidator;

	private static final String APPLICATION_PDF = "application/octet-stream";

	/**
	 * Constructor for controller
	 *
	 * @param fileService   - service for lessonFile (name and description of
	 *                      file)
	 * @param fileValidator - validation object (check size and type of file)
	 */
	@Autowired
	public FileController(FileValidator fileValidator, FileService fileService) {
		this.fileValidator = fileValidator;
		this.fileService = fileService;
	}

	/**
	 * Redirect to upload view
	 *
	 * @param request   - id of lesson that will have this file
	 * @param lessonDTO - DTO of lesson for model attribute
	 * @param model     - model for session attribute
	 * @return upload view
	 */
	@RequestMapping(value = {"/uploadRedirect"}, method = RequestMethod.POST)
	public ModelAndView redirectToUpload(HttpServletRequest request, @ModelAttribute LessonDTO lessonDTO, ModelMap model) {
		Long id = Long.parseLong(request.getParameter("id"));
		model.addAttribute("lessonId", id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("upload");
		modelAndView.addObject("id", id);
		logger.info("redirectToUpload method");
		return modelAndView;
	}

	/**
	 * Upload single file using Spring Controller
	 *
	 * @param uploadedFile - file that will be upload (Multipart file and description)
	 * @param result       - object of error
	 * @param model        - model for session attribute (lesson id)
	 * @return view for uploading
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView uploadFileHandler(@ModelAttribute("uploadedFile") UploadedFile uploadedFile, BindingResult result, ModelMap model) {

		ModelAndView modelAndView = new ModelAndView();

		fileValidator.validate(uploadedFile, result);

		if (result.hasErrors()) {
			logger.info("uploadFile method error");
			modelAndView.setViewName("upload");
		}
		else {
				long id = (long) model.get("lessonId");
				fileService.addFile(uploadedFile,id);

				RedirectView redirectView = new RedirectView("upload");
				redirectView.setStatusCode(HttpStatus.FOUND);
				modelAndView.setView(redirectView);
				modelAndView.addObject("lessonId", id);
		}
		return modelAndView;
	}

	/**
	 * Go to upload.jsp
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String fileUploaded() {
		return "upload";
	}

	/**
	 * Controller for deleting files
	 *
	 * @param id - file id
	 * @return mainpage
	 */
	@RequestMapping(value = "/deleteFile/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteFile(@PathVariable("id") final long id) {
		fileService.deleteFile(id);
		return new ResponseEntity<>(HttpStatus.OK);
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
		long id = Long.parseLong(request.getParameter("id"));

		ByteArrayInputStream inputStream = new ByteArrayInputStream(fileService.getDownloadFile(id).getValue());

		response.setCharacterEncoding("utf-8");
		response.setContentType(APPLICATION_PDF);
		response.setHeader("Content-Type", "application/octet-stream; charset=utf-8");
		String filename = URLEncoder.encode(fileService.getDownloadFile(id).getKey(),"UTF-8");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
		response.setHeader("Content-Length", String.valueOf(fileService.getDownloadFile(id).getValue().length));
		FileCopyUtils.copy(inputStream, response.getOutputStream());
		inputStream.close();
		logger.info("download file controller");
	}
}