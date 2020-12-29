package Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="trainingscores")
public class TrainingScores implements Serializable {

    @Embeddable
    public static class TrainingScoresId implements Serializable {
        @ManyToOne(fetch = FetchType.EAGER, optional=false)
        @JoinColumn(name="studentId", insertable = false, updatable = false)
        private Student student;

        @Column(length = 20, nullable = false, updatable = false)
        private String sem_year;

        public TrainingScoresId() {
        }

        public TrainingScoresId(Student student, String sem_year) {
            this.student = student;
            this.sem_year = sem_year;
        }

        public String getSem_year() {
            return sem_year;
        }

        public void setSem_year(String sem_year) {
            this.sem_year = sem_year;
        }

        public Student getStudent() {
            return student;
        }

        public void setStudent(Student student) {
            this.student = student;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof TrainingScoresId)) return false;
            TrainingScoresId that = (TrainingScoresId) o;
            return getStudent().equals(that.getStudent()) && getSem_year().equals(that.getSem_year());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getStudent(), getSem_year());
        }

        @Override
        public String toString() {
            return "TrainingScoresId{" +
                    "studentId=" + student.getStudentId() +
                    ", sem_year='" + sem_year + '\'' +
                    '}';
        }
    }

    @EmbeddedId
    private TrainingScoresId id;

    @Column(name="point")
    private Integer point;

    public TrainingScores() {
    }

    public TrainingScores(TrainingScoresId id, Integer point) {
        this.id = id;
        this.point = point;
    }

    public TrainingScoresId getId() {
        return id;
    }

    public void setId(TrainingScoresId id) {
        this.id = id;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "TrainingScores{" +
                "id=" + id +
                ", point=" + point +
                '}';
    }
}
