package Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="student")
public class Student implements Serializable {
    @Id
    @Column(name="studentId", length = 100)
    private String studentId = "HaHieuDepzai";

    @Column(name="name", length = 100)
    private String name;
    @Column(name="gender")
    private String gender;
    @Column(name="birthday")
    private Date birthday;
    @Column(name="address")
    private String address;
    @Column(name="classroom")
    private String classroom;
    @Column(name="phoneNumber")
    private String phoneNumber;
    @Column(name="email")
    private String email;
    @Column(name="GPA")
    private Float GPA;

    @OneToOne(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Account account;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private TrainingScores trainingScores;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "student_event",
            joinColumns = { @JoinColumn(name = "studentId")},
            inverseJoinColumns = { @JoinColumn(name = "eventId")}
    )
    private Set<Event> eventSet = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "student_subjects",
            joinColumns = {@JoinColumn(name = "studentId")},
            inverseJoinColumns = {@JoinColumn(name = "subjectCode")}
    )
    private Set<Subjects> subjectsSet = new HashSet<>();

    @Column(name = "creditsCount")
    private Integer creditsCount = 0;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


    public Set<Event> getEventSet() {
        return eventSet;
    }

    public void setEventSet(Set<Event> eventSet) {
        this.eventSet = eventSet;
    }

    public Student() {
    }

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TrainingScores getTrainingScores() {
        return trainingScores;
    }

    public void setTrainingScores(TrainingScores trainingScores) {
        this.trainingScores = trainingScores;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Float getGPA() {
        return GPA;
    }

    public void setGPA(Float GPA) {
        this.GPA = GPA;
    }

    public Set<Subjects> getSubjectsSet() {
        return subjectsSet;
    }

    public void setSubjectsSet(Set<Subjects> subjectsSet) {
        this.subjectsSet = subjectsSet;
    }

    public Integer getCreditsCount() {
        return creditsCount;
    }

    public void setCreditsCount(Integer creditsCount) {
        this.creditsCount = creditsCount;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
