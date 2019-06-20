package myapp;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//ПРОВЕРИТЬ, ЧТО ТАКОЙ ФАЙЛ УЖЕ ЕСТЬ
@Component
public class FileValidator implements Validator {

     List<String> fileTypes = Arrays.asList("png","jpg","pdf","mp3","mp4","doc","docx","txt","xls","xlsx","html","jpeg");


    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {

        UploadedFile file = (UploadedFile) o;

        if (file.getFile().getSize()==0){
            errors.rejectValue("file","uploadForm.selectFile","Please select a file!");
        }
        else {
            if (file.getFile().getSize() > 16567500) {
                errors.rejectValue("file", "uploadForm.selectFile", "File size too large! Max size 16 MB");
            }
            String fileExtension = file.getFile().getOriginalFilename().substring(file.getFile().getOriginalFilename().indexOf(".") + 1, file.getFile().getOriginalFilename().length());
            if (!fileTypes.contains(fileExtension.toLowerCase())) {
                errors.rejectValue("file", "uploadForm.selectFile", "This file format is not supported!");
            }
        }
    }
}
