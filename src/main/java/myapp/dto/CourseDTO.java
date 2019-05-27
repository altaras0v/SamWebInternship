package myapp.dto;
//add fields
public class CourseDTO {
    private String name;
    private String description;

    public CourseDTO(String name,String description){
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDecription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
