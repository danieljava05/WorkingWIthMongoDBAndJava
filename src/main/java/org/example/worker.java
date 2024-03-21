package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;

public class worker {





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

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public double getPay() {
        return pay;
    }

    String url = "mongodb+srv://danieljava:danieljava@cluster0.jxjmtjc.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
        MongoClient mongo = MongoClients.create(url);
        MongoDatabase db = mongo.getDatabase("JavaFiles");
        MongoCollection<Document> coll = db.getCollection("Worker");



    @Override
    public String toString() {
        Document b = new Document(
                "name " , name )
                .append("birthDate",birthDate)
                .append("endDate", endDate)
                .append("Age", getAge())
                .append("pay",collectPay());
        InsertOneResult  r = coll.insertOne(b);

        return r.toString();
    }
}
