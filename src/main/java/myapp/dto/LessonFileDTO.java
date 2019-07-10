package myapp.dto;

public class LessonFileDTO {

    private int id;
    private String name;
    private byte[] file;

    LessonFileDTO(){}

    public LessonFileDTO(int id, String name, byte[] file){
        this.id=id;
        this.name=name;
        this.file=file;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
}
