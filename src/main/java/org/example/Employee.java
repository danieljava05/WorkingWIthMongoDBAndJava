package org.example;

import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Random;
import java.util.UUID;

public class Employee extends worker{
    private int EmployeeID;
    private String hireDate;

    public Employee(){

    }
    public Employee(String name,String birthDate,String hireDate){
        this(name,birthDate,1,hireDate);
    }
    public Employee(String name, String birthDate, int EmployeeID,String hireDate) {
        super(name, birthDate);
        this.hireDate = hireDate;
        this.EmployeeID = 1;

    }
    public int yearspent(String hireDate){
        String[] n = hireDate.split("/");
        String getage = n[2];
        int convert = Integer.parseInt(getage);
        return 2024- convert;
    }






    @Override
    public String toString() {
        Document doc = new Document("EmployeeID", new ObjectId())

                .append("HireDate" ,hireDate)
                .append("year_Spent", yearspent(hireDate))
                .append("BirthDay", super.getBirthDate())
                .append("End Date",super.getEndDate())
                .append("Age",super.getAge())
                .append("Pay",super.collectPay());




        InsertOneResult nn = coll.insertOne(doc);
        return doc.toString();
    }
}
