import Entity.Student;
import Entity.Account;
import Entity.TrainingScores;
import Interactive.*;


public class Mainn {
    public static void dangky() {
        Account ac1 = new Account("18001131", "18001131", "bb5522", 1);
        boolean ok = addOperation.register(ac1);
        System.out.println("register is " + ok);
    }

    public static void themthongtinsinhvientheomasinhvien() {
        Student student = new Student("18001131", "Ha Hieu");
        boolean ok = addOperation.addInformation("18001131", student);
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

    public static void main(String[] args) throws Exception{
        dangky();
//        themthongtinsinhvientheomasinhvien();
//        thaydoidiemGPA();
//        deleteAccount();
        addTrainingScore();
    }
}

