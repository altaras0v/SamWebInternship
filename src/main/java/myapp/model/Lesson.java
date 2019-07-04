package myapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "lesson")
public class Lesson {
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


    private Set<LessonFile> lessonFiles = new HashSet<LessonFile>();

    @OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<LessonFile> getLessonFiles() {
        return lessonFiles;
    }

    public void setLessonFiles(Set<LessonFile> lessonFiles) {
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
