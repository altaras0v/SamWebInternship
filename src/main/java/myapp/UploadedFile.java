package myapp;

import org.springframework.web.multipart.MultipartFile;

/**
 * File that will be upload
 * Type - MultipartFile
 */
public class UploadedFile {

    private String description;

    private MultipartFile file;

    public MultipartFile getFile(){
        return file;
    }

    public void setFile(MultipartFile file){
        this.file = file;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
