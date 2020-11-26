package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="TrainingScores")
public class TrainingScores {
    @Id
    @Column(name="studentId")
    private String studentId;

    @Column(name="semester")
    private String semester;
    @Column(name="point")
    private int point;

    public TrainingScores(String studentId, String semester, int point) {
        this.studentId = studentId;
        this.semester = semester;
        this.point = point;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
