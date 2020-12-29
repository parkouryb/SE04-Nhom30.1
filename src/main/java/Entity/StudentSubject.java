package Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "student_subject")
public class StudentSubject implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

//    @OneToMany
    @Column(name = "student")
    private Student student;
    @Column(name = "subject")
    private Subject subject;

    public StudentSubject() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
