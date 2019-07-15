package myapp.file;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Arrays;
import java.util.List;

//ПРОВЕРИТЬ, ЧТО ТАКОЙ ФАЙЛ УЖЕ ЕСТЬ
/**
 * Class-validator for uploading files
 */
@Component
public class FileValidator implements Validator {

    final List<String> TYPES_OF_FILE = Arrays.asList("png", "jpg", "pdf", "mp3", "mp4", "doc", "docx", "txt",
            "xls", "xlsx", "html", "jpeg"); // valid format for uploading file
    final int MAX_SIZE = 16567500; // size for medium BLOB format

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    /**
     * Parameters validation
     *
     * @param o      - file that will be uploaded
     * @param errors - error if it exist
     */
    @Override
    public void validate(Object o, Errors errors) {

        UploadedFile file = (UploadedFile) o;

        // Check that size not null
        if (file.getFile().getSize() == 0) {
            errors.rejectValue("file", "uploadForm.selectFile", "Please select a file!");
        } else {
            //Check that file is not too large
            if (file.getFile().getSize() > MAX_SIZE) {
                errors.rejectValue("file", "uploadForm.selectFile", "File size too large! Max size 16 MB");
            }
            //Check valid format of file
            String fileExtension = file.getFile().getOriginalFilename().substring(file.getFile().getOriginalFilename().lastIndexOf(".") + 1, file.getFile().getOriginalFilename().length());
            if (!TYPES_OF_FILE.contains(fileExtension.toLowerCase())) {
                errors.rejectValue("file", "uploadForm.selectFile", "This file format is not supported!");
            }
        }
    }
}