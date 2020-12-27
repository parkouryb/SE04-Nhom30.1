package Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="trainingScores")
public class TrainingScores implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
//    @Column(name="studentId", length = 100)
//    private String studentId = "HaHieuDepzai";

    @Column(name="sem_year")
    private String sem_year = "*&^";

    @Column(name="point")
    private int point;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "trainingScores")
    private Set<Student> students = new HashSet<Student>();

    public TrainingScores() {
    }

    public TrainingScores(String sem_year, int point) {
//        this.studentId = studentId;
        this.sem_year = sem_year;
        this.point = point;
    }

    public String getSem_year() {
        return sem_year;
    }

    public void setSem_year(String sem_year) {
        this.sem_year = sem_year;
    }

//    public Student getStudent() {
//        return student;
//    }
//
//    public void setStudent(Student student) {
//        this.student = student;
//    }

//    public String getStudentId() {
//        return studentId;
//    }
//
//    public void setStudentId(String studentId) {
//        this.studentId = studentId;
//    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "TrainingScores{" +
//                "studentId='" + studentId + '\'' +
                ", sem_year='" + sem_year + '\'' +
                ", point=" + point +
//                ", student=" + student +
                '}';
    }
}
