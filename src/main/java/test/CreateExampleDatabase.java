package test;

import Entity.*;
import Hibernate.HibernateUtils;
import Interactive.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.hibernate.Session;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateExampleDatabase {
    private static class Pair{
        protected String string;
        protected boolean aBoolean;

        public Pair() {
        }

        public Pair(String string, boolean aBoolean) {
            this.string = string;
            this.aBoolean = aBoolean;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "string='" + string + '\'' +
                    ", aBoolean=" + aBoolean +
                    '}';
        }
    }
    static List <Pair> list = new ArrayList<>();

    private static void addAccount() {
        Account account = new Account("boss", "admin"
                , "admin", 1);
        boolean ok = addOperation.register(account);

        list.add(new Pair("add account admin", ok));
    }

    public static void main(String[] args) {
        addAccount();
        for (Pair pair: list) {
            System.out.println(pair);
        }
//        Date date;
//        try {
//            date = new SimpleDateFormat("dd/MM/yyyy").parse("16/12/2000");
//            Student student = new Student("admin", "boss", "MALE", date, "Ha Nam", "K63A3", "092922662626", "adsdasd@gmail.com");
//            boolean isOk = false;
//            while(isOk == false){
//                isOk = addOperation.addInformation("admin", student);
//            }
//        } catch (ParseException ex) {
//            Logger.getLogger(CreateExampleDatabase.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
    }
}
