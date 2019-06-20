package myapp.controller;

import myapp.FileValidator;
import myapp.UploadedFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

@Controller
@SessionAttributes("filename")
public class FileUploadController {

    private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    @Autowired
    FileValidator fileValidator;

    /**
     * Upload single file using Spring Controller
     */
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public @ResponseBody
    ModelAndView uploadFileHandler(@ModelAttribute("uploadedFile") UploadedFile uploadedFile, BindingResult result) {

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
                modelAndView.addObject("filename",name);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return modelAndView;

    }
    @RequestMapping(value = "/upload",method = RequestMethod.GET)
    public String fileUploaded(){
        return "upload";
    }
}
