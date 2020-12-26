package test;

import Entity.Student;
import Entity.Account;
import Entity.TrainingScores;
import Hibernate.HibernateUtils;
import org.hibernate.Session;
import Interactive.*;
import java.util.Date;

import static Interactive.DatabaseInteractive.Register;

public class Mainn {
    public static void dangky() {
        Account ac1 = new Account("18001131", "18001131", "bb5522", 1);
        boolean ok = Operation.register(ac1);
        System.out.println("register is " + ok);
    }

    public static void themthongtinsinhvientheomasinhvien() {
        Student student = new Student("18001131", "Ha Hieu");
        boolean ok = Operation.addInformation("18001131", student);
        System.out.println("addInformation is " + ok);
    }

    public static void thaydoidiemGPA() {
        boolean ok = Operation.changeInformation("18001131", 3.6f);
        System.out.println("change information is " + ok);
    }

    public static void main(String[] args) throws Exception{
//        themthongtinsinhvientheomasinhvien();
        thaydoidiemGPA();
    }
}

