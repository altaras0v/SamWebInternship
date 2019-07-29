package com.samsolutions.myapp.controller;

import com.samsolutions.myapp.dto.LessonDTO;
import com.samsolutions.myapp.model.BlobFile;
import com.samsolutions.myapp.model.Lesson;
import com.samsolutions.myapp.model.LessonFile;
import com.samsolutions.myapp.service.api.BlobFileService;
import com.samsolutions.myapp.service.api.LessonFileService;
import com.samsolutions.myapp.validator.FileValidator;
import com.samsolutions.myapp.validator.UploadedFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Controller for uploading files
 * lessonId - id of lesson that will have this file
 */
@Controller
@SessionAttributes("lessonId")
public class FileUploadController {

	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

	private final LessonFileService lessonFileService;

	private final BlobFileService blobFileService;

	private final FileValidator fileValidator;

	/**
	 * Constructor for controller
	 *
	 * @param lessonFileService - service for lessonFile (name and description of file)
	 * @param blobFileService   - service for blobFile (bytes of file)
	 * @param fileValidator     - validation object (check size and type of file)
	 */
	@Autowired
	public FileUploadController(LessonFileService lessonFileService, BlobFileService blobFileService, FileValidator fileValidator)
	{
		this.lessonFileService = lessonFileService;
		this.blobFileService = blobFileService;
		this.fileValidator = fileValidator;
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
	public ModelAndView redirectToUpload(HttpServletRequest request, @ModelAttribute LessonDTO lessonDTO, ModelMap model)
	{
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
	ModelAndView uploadFileHandler(@ModelAttribute("uploadedFile") UploadedFile uploadedFile, BindingResult result, ModelMap model)
	{

		long id = (long) model.get("lessonId");

		ModelAndView modelAndView = new ModelAndView();
		String name;

		MultipartFile file = uploadedFile.getFile();

		fileValidator.validate(uploadedFile, result);
		String desc;
		if (uploadedFile.getDescription() != null) {
			desc = uploadedFile.getDescription();
		}
		else {
			desc = "";
		}

		if (result.hasErrors()) {
			logger.info("uploadFile method error");
			modelAndView.setViewName("upload");
		}
		else {
			try {

				byte[] bytes = file.getBytes();
				name = file.getOriginalFilename();

				System.out.println(Arrays.toString(bytes));

				Lesson lesson = new Lesson();
				lesson.setId(id);
				LessonFile lessonFile = new LessonFile(name, desc, lesson);
				lessonFileService.addFile(lessonFile);

				BlobFile blobFile = new BlobFile(bytes, lessonFile);
				blobFileService.addFile(blobFile);

				RedirectView redirectView = new RedirectView("upload");
				redirectView.setStatusCode(HttpStatus.FOUND);
				modelAndView.setView(redirectView);
				modelAndView.addObject("lessonId", id);

			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("uploadFile method successful");
		}
		return modelAndView;
	}

	/**
	 * Go to upload.jsp
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String fileUploaded()
	{
		return "upload";
	}


	/**
	 * Controller for deleting files
	 *
	 * @param request - file id
	 * @return mainpage
	 */
	@RequestMapping(value = "/deleteFile", method = RequestMethod.GET)
	public ModelAndView deleteFile(HttpServletRequest request)
	{
		ModelAndView mav = new ModelAndView(new RedirectView("/"));
		long id = Long.parseLong(request.getParameter("fileId"));
		blobFileService.deleteFile(blobFileService.getFileByLessonFileId(id)
				.getId());
		lessonFileService.deleteFile(id);
		return mav;
	}
}