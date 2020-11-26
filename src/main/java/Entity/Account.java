package Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(
        name = "account",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
        }
)
public class Account implements Serializable {
    @Id
    @Column(name="studentId", length = 100)
    private String studentId;

    @Column(name="username")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String username;

    @Column(name="password", length = 100)
    private String password;
    @Column(name="root", length = 100)
    private int root;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private Student student;

    public Student getInformation() {
        return student;
    }

    public void setInformation(Student student) {
        this.student = student;
    }

    public Account() {
    }

    public Account(String studentId, String username, String password, int root) {
        this.studentId = studentId;
        this.username = username;
        this.password = password;
        this.root = root;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoot() {
        return root;
    }

    public void setRoot(int root) {
        this.root = root;
    }

    @Override
    public String toString() {
        return "Account{" +
                "studentId='" + studentId + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", root=" + root +
                '}';
    }
}
