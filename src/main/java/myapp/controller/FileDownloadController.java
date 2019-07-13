package myapp.controller;

import myapp.model.LessonFile;
import myapp.service.api.LessonFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;

/**
 * * Controller for downloading files
 */
@Controller
public class FileDownloadController {

    private static final String APPLICATION_PDF = "application/octet-stream";

    final LessonFileService lessonFileService;

    @Autowired
    public FileDownloadController(LessonFileService lessonFileService) {
        this.lessonFileService = lessonFileService;
    }

    /**
     * Download single file from server to user
     *
     * @param response - file for downloading
     * @param request  - id of downloading file
     */
    @RequestMapping(value = "/download", method = RequestMethod.GET, produces = APPLICATION_PDF)
    public @ResponseBody
    void downloadFile(HttpServletResponse response, HttpServletRequest request) throws IOException {

        Integer id = Integer.parseInt(request.getParameter("id"));


        LessonFile lessonFile = lessonFileService.getFileById(id);
        byte[] bytes = lessonFile.getFile();
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
    }
}