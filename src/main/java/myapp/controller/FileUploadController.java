package myapp.controller;

import myapp.FileValidator;
import myapp.UploadedFile;
import myapp.dto.LessonDTO;
import myapp.dto.LessonFileDTO;
import myapp.model.Lesson;
import myapp.model.LessonFile;
import myapp.service.api.LessonFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

@Controller
@SessionAttributes("lessonId")
/**
 * Controller for uploading files
 */
public class FileUploadController {

    private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    private final LessonFileService lessonFileService;

    @Autowired
    public FileUploadController(LessonFileService lessonFileService) {
        this.lessonFileService = lessonFileService;
    }

    @Autowired
    FileValidator fileValidator;

    @RequestMapping(value = {"/uploadRedirect"}, method = RequestMethod.POST)
    public ModelAndView redirectToUpload(HttpServletRequest request, HttpServletResponse response,@ModelAttribute LessonDTO lessonDTO, ModelMap model) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        model.addAttribute("lessonId",id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("upload");
        modelAndView.addObject("id",id);
        logger.info("redirectToUpload method");
        return modelAndView;
    }


    /**
     * Upload single file using Spring Controller
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody
    ModelAndView uploadFileHandler(@ModelAttribute("uploadedFile") UploadedFile uploadedFile, BindingResult result,ModelMap model) {

        int id = (int)model.get("lessonId");

        ModelAndView modelAndView = new ModelAndView();
        String name = null;

        MultipartFile file = uploadedFile.getFile();
        fileValidator.validate(uploadedFile, result);

        if (result.hasErrors()) {
            logger.info("uploadFile method error");
           modelAndView.setViewName("upload");
        } else {
            try {

                byte[] bytes = file.getBytes();

                name = file.getOriginalFilename();
                Lesson lesson = new Lesson();
                lesson.setId(id);
                LessonFile lessonFile = new LessonFile(name,bytes,lesson);
                lessonFileService.addFile(lessonFile);

                RedirectView redirectView = new RedirectView("upload");
                redirectView.setStatusCode(HttpStatus.FOUND);
                modelAndView.setView(redirectView);
                modelAndView.addObject("lessonId",id);

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
    @RequestMapping(value = "/upload",method = RequestMethod.GET)
    public String fileUploaded(){
        return "upload";
    }
}
