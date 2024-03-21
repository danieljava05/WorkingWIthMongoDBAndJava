package org.example;

public class worker {
    String url = "mongodb+srv://danieljava:danieljava@cluster0.jxjmtjc.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    


    private String name;
    private String birthDate;
    private String endDate;
    private double pay;
    public worker(){
        this.name = "Worker";
    }
    public worker(String name,String birthDate) {
        this.birthDate = birthDate;
        this.name = name;
        this.pay = 15000;

        this.endDate = (getAge() > 50) ? "Your endDate is in the year "+convert(getAge()) :  "You are not yet retired" ;
    }
    public int getAge(){
        String[] n = birthDate.split("/");
        String getage = n[2];
        int convert = Integer.parseInt(getage);
        int age = 2024 - convert;
        return age;
    }
    public int convert(int birth){
        String[] n = birthDate.split("/");
        String getage = n[2];
        int convert = Integer.parseInt(getage);
        return convert + birth;
    }
    public double collectPay(){
       return this.pay = pay * 2;
    }


    @Override
    public String toString() {
        return "worker{" +
                "name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", Age ='" + getAge() + '\'' +
                ", pay ='" + collectPay() + '\'' +
                '}';
    }
}
