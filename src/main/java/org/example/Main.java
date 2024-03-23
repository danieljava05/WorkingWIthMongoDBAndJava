package org.example;

public class Main {
    public static void main(String[] args) {

        worker mk = new worker("CEO","25/7/1960");
        work(mk);
        worker mm = new worker("HOD","27/9/2002");
        work(mm);
        Employee em = new Employee("Fiyin", "23/05/1960", "20/4/1995");
        work(em);
        Employee ev =  new Employee("Bose","23/4/2015","23/5/2005");
       work(ev);
       HourlyEmployee he = new HourlyEmployee("Tobi","6/9/2001","9/2/2002",5000000);
       work(he);

    }


    public static void work(worker worker){
        System.out.println(worker);

    }
}