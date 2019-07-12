package myapp;

import org.springframework.web.multipart.MultipartFile;

/**
 * File that will be upload
 * Type - MultipartFile
 */
public class UploadedFile {

    private MultipartFile file;

    public MultipartFile getFile(){
        return file;
    }

    public void setFile(MultipartFile file){
        this.file = file;
    }

}
