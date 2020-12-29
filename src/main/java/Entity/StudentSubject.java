package Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "student_subject")
public class StudentSubject implements Serializable {
    @Embeddable
    public static class StudentSubjectId implements Serializable {
        @ManyToOne(fetch = FetchType.EAGER, optional = false)
        @JoinColumn(name = "studentId", insertable = false, updatable = false)
        private Student student;
        @ManyToOne(fetch = FetchType.EAGER, optional = false)
        @JoinColumn(name = "subjectCode", insertable = false, updatable = false)
        private Subject subject;

        public StudentSubjectId() {
        }

        public StudentSubjectId(Student student, Subject subject) {
            this.student = student;
            this.subject = subject;
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof StudentSubjectId)) return false;
            StudentSubjectId that = (StudentSubjectId) o;
            return student.equals(that.student) && subject.equals(that.subject);
        }

        @Override
        public int hashCode() {
            return Objects.hash(student, subject);
        }

        @Override
        public String toString() {
            return "StudentSubjectId{" +
                    "studentId=" + student.getStudentId() +
                    ", subjectCode=" + subject.getSubjectCode() +
                    '}';
        }
    }

    @EmbeddedId
    private StudentSubjectId id;
    private boolean status;

    public StudentSubject() {
    }

    public StudentSubject(StudentSubjectId id, boolean status) {
        this.id = id;
        this.status = status;
    }

    public StudentSubjectId getId() {
        return id;
    }

    public void setId(StudentSubjectId id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StudentSubject{" +
                "id=" + id +
                ", status=" + status +
                '}';
    }
}
