package test;

import Entity.Event;
import Entity.Student;
import Entity.Account;
import Entity.TrainingScores;
import Interactive.*;

import java.util.*;


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
        TrainingScores trainingScore = new TrainingScores("02/2019-2020", 90);
        boolean ok = addOperation.addTrainingScores("18001131", trainingScore);
        System.out.println("add trainingscore is " + ok);

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
        Set<Student> students = getOperation.getStudentByEvent("HDZ1");
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
//        addEvent();
//        addEventStudentId();

        getEventStudentId();
    }
}

