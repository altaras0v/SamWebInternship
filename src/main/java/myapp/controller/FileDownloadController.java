package myapp.controller;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
@RequestMapping("/download")
public class FileDownloadController {

    private static final String APPLICATION_PDF = "application/octet-stream";

    @RequestMapping(value = "/a", method = RequestMethod.GET, produces = APPLICATION_PDF)
    public @ResponseBody
    void downloadA(HttpServletResponse response,HttpServletRequest request,@RequestParam(name = "first") String s) throws IOException {
         String FILE_PATH = "C:\\Tomcat\\apache-tomee-plume-7.0.5\\tmpFiles\\"+request.getParameter("first");


         File file = new File(FILE_PATH);
        if (!file.exists()){
            throw new FileNotFoundException("file with path: " + FILE_PATH + " was not found.");
        }

        //File file = getFile();
        InputStream in = new FileInputStream(file);

        response.setContentType(APPLICATION_PDF);
        response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
        response.setHeader("Content-Length", String.valueOf(file.length()));
        FileCopyUtils.copy(in, response.getOutputStream());
    }

    /*private File getFile() throws FileNotFoundException {
        File file = new File(FILE_PATH);
        if (!file.exists()){
            throw new FileNotFoundException("file with path: " + FILE_PATH + " was not found.");
        }
        return file;
    }*/

}