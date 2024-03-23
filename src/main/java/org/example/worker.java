package org.example;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.IndexOptions;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;

import java.util.Iterator;

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
       return this.pay = pay * 2 * convert(getAge());
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


        MongoClient mongo = MongoClients.create(System.getProperty("TEST"));
        MongoDatabase db = mongo.getDatabase("JavaFiles");
        MongoCollection<Document> coll = db.getCollection("Worker");
       IndexOptions indexOptions = new IndexOptions().unique(true);



    @Override
    public String toString() {
        Document b = new Document(
                "Name",name )
                .append("birthDate",birthDate)
                .append("endDate", endDate)
                .append("Age", getAge())
                .append("Pay",collectPay());
        coll.createIndex(new Document("Name", 1), indexOptions);


        try{

                        InsertOneResult r = coll.insertOne(b);
                        return "Acknowledged";


        }catch (Exception e){
           return "duplicate";
        }



    }
}
