package myapp.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "lesson_file")
public class LessonFile implements Serializable {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Lob
    @Column(name = "file", columnDefinition="BLOB")
    private byte[] file;

    private Lesson lesson;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilePath() {
        return name;
    }

    public void setFilePath(String name) {
        this.name = name;
    }


    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
}
