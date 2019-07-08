package myapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "lesson")
public class Lesson implements Serializable {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public Lesson(){

    }

    public Lesson(int id,String name,String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

//    @ManyToOne
//    @JoinColumn(name = "course_id")
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

   /* @ElementCollection(targetClass = LessonFile.class)
    private List<LessonFile> lessonFiles = new ArrayList<>(0);*/

    @OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<LessonFile> lessonFiles = new ArrayList<>();

    public List<LessonFile> getLessonFiles() {
        return lessonFiles;
    }

    public void setLessonFiles(List<LessonFile> lessonFiles) {
        this.lessonFiles = lessonFiles;
    }

    public void addLessonFile(LessonFile lessonFile){
        lessonFile.setLesson(this);
        getLessonFiles().add(lessonFile);
    }

    public void removeLessonFile(LessonFile lessonFile){
        getLessonFiles().remove(lessonFile);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}
