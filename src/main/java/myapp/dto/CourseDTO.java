package myapp.dto;

/**
 * Course data transfer object
 */
public class CourseDTO {
    private String name;
    private String description;
    private int id;

    public CourseDTO(){}

    public CourseDTO(String name,String description,int id){
        this.name = name;
        this.description = description;
        this.id = id;
    }
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

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }
}
