package org.example;

public class Main {
    public static void main(String[] args) {

        worker wk = new worker("Daniel","25/7/2000");
        work(wk);
        Employee em = new Employee("Bola", "23/05/2004", 1, "20/4/2000");

        work(em);
//        Employee ev =  new Employee("praise","23/4/2015","23/5/2005");
//       work(ev);

    }


    public static void work(worker worker){
        System.out.println(worker);

    }
}