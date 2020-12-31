package test;

import Entity.*;
import Hibernate.HibernateUtils;
import Interactive.*;
import org.hibernate.Session;

import java.util.*;

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
    }
}
