package myapp.model;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Class that is entity for course
 */
@Entity
@Table(name = "courses")
public class Course implements Serializable {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "full_description")
    private String fullDescription;

    public Course(){

    }

    public Course(String name,String description){
        this.name = name;
        this.description = description;
    }

    private Set<Lesson> lessons = new HashSet<Lesson>();

    @OneToMany(mappedBy = "courses", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Lesson> getLessons () {
        return lessons;
    }

    public void setLesson(Set<Lesson> lessons) {
        this.lessons = lessons;
    }

    public void addLesson(Lesson lesson){
        lesson.setCourse(this);
        getLessons().add(lesson);
    }

    public void removeLesson(Lesson lesson){
        getLessons().remove(lesson);
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

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString(){
        return "Course{ " +
                "id=" + id +
                " name=" + name +
                " description=" + description +
                "}";
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }
}
