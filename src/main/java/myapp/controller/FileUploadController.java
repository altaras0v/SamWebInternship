package myapp.controller;

import myapp.FileValidator;
import myapp.UploadedFile;
import myapp.dto.LessonDTO;
import myapp.dto.LessonFileDTO;
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
    public String redirectToLesson(HttpServletRequest request, HttpServletResponse response,@ModelAttribute LessonDTO lessonDTO, ModelMap model) {
        Integer id = Integer.parseInt(request.getParameter("id"));

        LessonDTO lessonDTO1 = new LessonDTO(id);


        ModelAndView modelAndView = new ModelAndView("upload");
        model.addAttribute("lessonId",lessonDTO1);

        return "/upload";

    }


    /**
     * Upload single file using Spring Controller
     */
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public @ResponseBody
    ModelAndView uploadFileHandler(@ModelAttribute("uploadedFile") UploadedFile uploadedFile, BindingResult result,ModelMap model) {

        LessonDTO lessonDTO = (LessonDTO) model.get("lessonId");

        System.out.println("Transporter"+lessonDTO.getId());


        ModelAndView modelAndView = new ModelAndView();
        String name = null;

        MultipartFile file = uploadedFile.getFile();
        fileValidator.validate(uploadedFile, result);

        if (result.hasErrors()) {
            modelAndView.setViewName("upload");
        } else {
            try {


                byte[] bytes = file.getBytes();

                name = file.getOriginalFilename();

                LessonFileDTO fileDTO = new LessonFileDTO(name,bytes);

                // Creating the directory to store file
                String rootPath = System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator + "tmpFiles");
                if (!dir.exists()) dir.mkdirs();

                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                logger.info("Server File Location=" + serverFile.getAbsolutePath());

                RedirectView redirectView = new RedirectView("upload");
                redirectView.setStatusCode(HttpStatus.FOUND);
                modelAndView.setView(redirectView);
               // modelAndView.addObject("filename",name);

            } catch (Exception e) {
                e.printStackTrace();
            }
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
