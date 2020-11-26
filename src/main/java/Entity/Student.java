package Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="student")
public class Student implements Serializable {
    @Id
    @Column(name="studentId", length = 100)
    private String studentId;

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

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Account account;

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

    public Account getManager() {
        return account;
    }

    public void setManager(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
