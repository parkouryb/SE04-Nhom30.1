package Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name= "subject")
public class Subject {
    @Id
    @Column(name = "subjectCode", length = 100)
    private String subjectCode;

    @Column(name = "subjectTitle")
    private String subjectTitle;

    @Column(name = "credits")
    private Integer credits;
    @Column(name = "status")
    private boolean status;
    @Column(name = "teacher")
    private String teacher;
    @Column(name = "type")
    private boolean type;
    @Column(name = "room")
    private String room;
    @Column(name = "timeStart")
    private Integer timeStart;
    @Column(name = "timeEnd")
    private Integer timeEnd;
    @Column(name = "day")
    private String day;
    @Column(name="semester")
    private Integer semester;
    @Column(name="year")
    private String year;

//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "subjectsSet")
//    private Set<Student> studentsSet = new HashSet<>();


    public Subject() {
    }

    public Subject(String subjectCode, String subjectTitle) {
        this.subjectCode = subjectCode;
        this.subjectTitle = subjectTitle;
    }

    public Subject(String subjectCode, String subjectTitle, Integer credits, boolean status, String teacher) {
        this.subjectCode = subjectCode;
        this.subjectTitle = subjectTitle;
        this.credits = credits;
        this.status = status;
        this.teacher = teacher;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectTitle() {
        return subjectTitle;
    }

    public void setSubjectTitle(String subjectTitle) {
        this.subjectTitle = subjectTitle;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Integer getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Integer timeStart) {
        this.timeStart = timeStart;
    }

    public Integer getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Integer timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

//    public Set<Student> getStudentsSet() {
//        return studentsSet;
//    }
//
//    public void setStudentsSet(Set<Student> studentsSet) {
//        this.studentsSet = studentsSet;
//    }


}