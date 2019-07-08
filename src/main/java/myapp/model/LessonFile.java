package myapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

}
