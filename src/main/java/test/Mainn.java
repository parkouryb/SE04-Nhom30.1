package test;

import Entity.*;
import Hibernate.HibernateUtils;
import Interactive.*;
import java.text.SimpleDateFormat;

import java.util.*;
import org.hibernate.Session;


public class Mainn {
    public static void dangky() {
        Account ac1 = new Account("18001131", "18001131", "bb5522", 1);
        boolean ok = addOperation.register(ac1);
        System.out.println("register is " + ok);
        Account ac2 = new Account("18001132", "18001132", "bb5522", 1);
        ok = addOperation.register(ac2);
        System.out.println("register is " + ok);
    }

    public static void themthongtinsinhvientheomasinhvien() {
        Student student = new Student("18001131", "Ha Hieu");
        boolean ok = addOperation.addInformation("18001131", student);
        System.out.println("addInformation is " + ok);

        Student student1 = new Student("18001132", "Ha Hieu depzai");
        ok = addOperation.addInformation("18001132", student1);
        System.out.println("addInformation is " + ok);
    }

    public static void thaydoidiemGPA() {
        boolean ok = changeOperation.changeGPA("18001131", 3.6f);
        System.out.println("change information is " + ok);
    }

    public static void deleteAccount() {
        boolean ok = deleteOperation.deleteAccount("4");
        System.out.println("delete Account " + ok);
    }

    public static void addTrainingScore() {
        TrainingScores.TrainingScoresId id =
                new TrainingScores.TrainingScoresId(
                        getOperation.getStudentByStudentId("18001132"), "01/2019-2020");
        TrainingScores trainingScore = new TrainingScores(id, 90);
        boolean ok = addOperation.addTrainingScoresByStudentId(trainingScore);
        System.out.println("add trainingscore is " + ok);

        TrainingScores.TrainingScoresId id1 =
                new TrainingScores.TrainingScoresId(
                        getOperation.getStudentByStudentId("18001132"), "02/2019-2020");
        TrainingScores trainingScore1 = new TrainingScores(id1, 99);
        boolean ok1 = addOperation.addTrainingScoresByStudentId(trainingScore1);
        System.out.println("add trainingscore is " + ok1);

        TrainingScores.TrainingScoresId id2 =
                new TrainingScores.TrainingScoresId(
                        getOperation.getStudentByStudentId("18001131"), "01/2019-2020");
        TrainingScores trainingScore2 = new TrainingScores(id2, 100);
        boolean ok2 = addOperation.addTrainingScoresByStudentId(trainingScore2);
        System.out.println("add trainingscore is " + ok2);
    }

    public static void addEvent() {
        List<Event> events = new ArrayList<Event>();
        Event event1 = new Event("HDZ1", "Hoa Hau Hoan Vu");
        Event event2 = new Event("HDZ2", "Vo Thuat Kungfu");
        Event event3 = new Event("HDZ3", "Dep zai ai cam");
        events.add(event1);
        events.add(event2);
        events.add(event3);
        for (Event event: events) {
            boolean ok = addOperation.addEvent(event);
            System.out.println("Event add " + (ok ? " success" : " fail"));
        }
    }

    public  static void addEventStudentId() {
        List<Event> events = new ArrayList<Event>();
        List<Event> events1 = new ArrayList<Event>();
        Event event1 = new Event("HDZ1", "Hoa Hau Hoan Vu");
        Event event2 = new Event("HDZ2", "Vo Thuat Kungfu");
        Event event3 = new Event("HDZ3", "Dep zai ai cam");

        events.add(event1);
        events.add(event2);

        events1.add(event1);
        events1.add(event3);

        for (Event event: events) {
            boolean ok = addOperation.addEventStudent("18001131", event);
            System.out.println("Event 18001131 add " + (ok ? " success" : " fail"));
        }
        for (Event event: events1) {
            boolean ok = addOperation.addEventStudent("18001132", event);
            System.out.println("Event 18001132 add " + (ok ? " success" : " fail"));
        }


    }

    public static void getEventStudentId() {
        Set<Event> events = getOperation.getEventsByStudentId("18001132");
        if (events == null) {
            System.out.println("null value");
            return;
        }
        for (Event event: events) {
            System.out.println("18001131 " + event);
        }
        Event event1 = new Event("HDZ1", "Hoa Hau Hoan Vu");
        Set<Student> students = getOperation.getStudentsByEvent("HDZ1");
        if (students == null) {
            System.out.println("null value");
            return;
        }
        for (Student student: students) {
            System.out.println(event1 + " " + student.getStudentId());
        }
    }

    public static void main(String[] args) throws Exception{
//        dangky();
//        themthongtinsinhvientheomasinhvien();
//        thaydoidiemGPA();
//        deleteAccount();
//        addTrainingScore();
//        viewTrainingScore();
//        addEvent();
//        addEventStudentId();
//        getEventStudentId();
//        addSubjects();
//        viewSubjects();
//        addSubjectsToStudent();
//        viewStudentSubject();

//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        try {
//            Student student = getOperation.getStudentByStudentId("18001131");
//            System.out.println(student);
//        } catch (Exception e) {
//        }
//        session.close();
//        String currentDir = System.getProperty("user.dir");
//        System.out.println("Current dir using System:" +currentDir);
//        Date date = new SimpleDateFormat("dd/MM/yyyy").parse("30/01/2020");
//        System.out.println(date.toString());
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        List<TrainingScores> trainingScores = new ArrayList<>();
        try {
            session.getTransaction().begin();
            trainingScores= getOperation.loadAllData(TrainingScores.class, session);
        } catch (Exception e) {
        }
        finally{
            session.close();
        }
        
    }

    private static void viewStudentSubject() {
        Student student1 = getOperation.getStudentByStudentId("18001131");
        Student student2 = getOperation.getStudentByStudentId("18001132");

        Set<StudentSubject> subjects1 = getOperation.getSubjectsByStudent(student1);
        Set<StudentSubject> subjects2 = getOperation.getSubjectsByStudent(student2);

        for (StudentSubject subject: subjects1) {
            System.out.println(student1 + " get subjects" + subject);
        }
        for (StudentSubject subject: subjects2) {
            System.out.println(student2 + " get subjects" + subject);
        }

        Subject subject = getOperation.getSubjectBySubjectCode("MAT0002");

        Set<StudentSubject> students1 = getOperation.getStudentsBySubject(subject);
        for (StudentSubject student: students1) {
            System.out.println(subject + " get student " + student);
        }
    }

    private static void addSubjectsToStudent() {
        Subject subject1 = getOperation.getSubjectBySubjectCode("MAT0001");
        Subject subject2 = getOperation.getSubjectBySubjectCode("MAT0002");
        Subject subject3 = getOperation.getSubjectBySubjectCode("MAT0030");
        Subject subject4 = getOperation.getSubjectBySubjectCode("INT0004");
        Subject subject5 = getOperation.getSubjectBySubjectCode("POL0012");

        Student student1 = getOperation.getStudentByStudentId("18001131");
        Student student2 = getOperation.getStudentByStudentId("18001132");

        StudentSubject studentSubject1 = new StudentSubject(
                new StudentSubject.StudentSubjectId(student1, subject1), true);
        StudentSubject studentSubject2 = new StudentSubject(
                new StudentSubject.StudentSubjectId(student1, subject2), false);
        StudentSubject studentSubject3 = new StudentSubject(
                new StudentSubject.StudentSubjectId(student2, subject3), true);
        StudentSubject studentSubject4 = new StudentSubject(
                new StudentSubject.StudentSubjectId(student2, subject4), false);
        StudentSubject studentSubject5 = new StudentSubject(
                new StudentSubject.StudentSubjectId(student2, subject5), false);
        StudentSubject studentSubject6 = new StudentSubject(
                new StudentSubject.StudentSubjectId(student2, subject2), true);

        List <StudentSubject> studentSubjects = new ArrayList<StudentSubject>();
        studentSubjects.add(studentSubject1);
        studentSubjects.add(studentSubject2);
        studentSubjects.add(studentSubject3);
        studentSubjects.add(studentSubject4);
        studentSubjects.add(studentSubject5);
        studentSubjects.add(studentSubject6);

        for (StudentSubject studentSubject: studentSubjects) {
            boolean ok = addOperation.addSubjectStudent(studentSubject);
            System.out.println("add stusub " + studentSubject + " : " + ok);
        }
    }

    private static void viewSubjects() {
        List<Subject> subjects = getOperation.getSubjects();
        for (Subject subject:subjects) {
            System.out.println(subject);
        }
    }

    private static void addSubjects() {
        Subject subject1 = new Subject("MAT0001", "Giai tich 1");
        Subject subject2 = new Subject("MAT0002", "Giai tich 2");
        Subject subject3 = new Subject("INT0004", "Tin hoc 4");
        Subject subject4 = new Subject("POL0012", "Duong loi cach mang");
        Subject subject5 = new Subject("MAT0030", "Giai tich so");
        List <Subject> subjects = new ArrayList<Subject>();
        subjects.add(subject1);
        subjects.add(subject2);
        subjects.add(subject3);
        subjects.add(subject4);
        subjects.add(subject5);
        for (Subject subject: subjects) {
            boolean ok = addOperation.addSubject(subject);
            System.out.println("add " + subject + " : " + ok);
        }
    }

    private static void viewTrainingScore() {
        List<TrainingScores> trainingScoresList = getOperation
                .getTrainingScoresByStudentId("18001132");
        for (TrainingScores t: trainingScoresList) {
            System.out.println(t);
        }

        List <Student> students = getOperation
                .getStudentsBySemYear("01/2019-2020");
        for (Student student: students) {
            System.out.println(student);
        }

    }
 }

