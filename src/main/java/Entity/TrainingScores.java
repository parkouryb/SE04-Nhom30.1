package Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="trainingScores")
public class TrainingScores implements Serializable {
    @Id
    @Column(name="studentId", length = 100)
    private String studentId = "HaHieuDepzai";

    @Column(name="semester")
    private Integer semester;

    @Column(name="year")
    private String year;

    @Column(name="point")
    private int point;

    @OneToOne(mappedBy = "trainingScores",cascade = CascadeType.ALL)
    private Student student;

    public TrainingScores() {
    }

    public TrainingScores(String studentId, Integer semester, String year, int point) {
        this.studentId = studentId;
        this.semester = semester;
        this.year = year;
        this.point = point;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "TrainingScores{" +
                "studentId='" + studentId + '\'' +
                ", semester=" + semester +
                ", year='" + year + '\'' +
                ", point=" + point +
                '}';
    }
}
