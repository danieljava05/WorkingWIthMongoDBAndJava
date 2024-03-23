package org.example;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.IndexOptions;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;
import org.bson.types.ObjectId;



public class Employee extends worker{

    private String hireDate;

    public Employee(){

    }

    public Employee(String name, String birthDate,String hireDate) {
        super(name, birthDate);
        this.hireDate = hireDate;


    }
    public int yearspent(String hireDate){
        String[] n = hireDate.split("/");
        String getage = n[2];
        int convert = Integer.parseInt(getage);
        return 2024- convert;
    }



    MongoCollection<Document> col = db.getCollection("Employee");
    IndexOptions indexOptions = new IndexOptions().unique(true);

    @Override
    public String toString() {
        Document doc = new Document("EmployeeID", new ObjectId())
                .append("Name", super.getName())
                .append("HireDate" ,hireDate)
                .append("year_Spent", yearspent(hireDate))
                .append("BirthDay", super.getBirthDate())
                .append("End Date",super.getEndDate())
                .append("Age",super.getAge())
                .append("Pay",super.collectPay() * super.getAge());
        col.createIndex(new Document("Name",1),indexOptions );
try{

            InsertOneResult nn = col.insertOne(doc);
            return "Acknowledged";
    }catch (Exception e){
       return "Duplicate Name Value";
}

    }
}
