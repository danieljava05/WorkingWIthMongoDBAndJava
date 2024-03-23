package org.example;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.IndexOptions;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;

public class HourlyEmployee extends Employee {

    private double HourlyPayRate;
    private double yearlyPayRate;
    private double MonthlyPayRate;
    private  double weeklyPayRate;
    private double dailyPayRate;



    public HourlyEmployee(String name, String birthDate, String hireDate,double yearlyPayRate) {
        super(name, birthDate, hireDate);
        this.HourlyPayRate = getHourlyPay();
        this.MonthlyPayRate = getMonthlyPayRate();
        this.weeklyPayRate = getWeeklyPayRate();
        this.dailyPayRate = getDailyPayRate();
        this.yearlyPayRate = getYearlyPayRate();
    }

    public double getYearlyPayRate(){
        return getMonthlyPayRate()* 12;
    }
    public double getMonthlyPayRate(){
        return yearlyPayRate/12 ;
    }
    public double getWeeklyPayRate(){
        return yearlyPayRate/52;
    }
    public double getDailyPayRate(){
    return yearlyPayRate /365;
    }
    public double getHourlyPay(){
        return (yearlyPayRate / 2080);
    }

    @Override
    public String toString() {

        Document doc  = new Document("Name",super.getName())
                .append("BirthDay", super.getBirthDate())
                .append("End Date",super.getEndDate())
                .append("Age",super.getAge())
                .append("HourlyPayRate",getHourlyPay())
                .append("yearlyPayRate", getYearlyPayRate())
                .append("MonthlyPayRate",getMonthlyPayRate())
                .append("weeklyPayRate",getWeeklyPayRate())
                .append("DailyPayRate",getDailyPayRate());

        MongoCollection<Document> coll = db.getCollection("HourlyEmployee");
        IndexOptions indexOptions = new IndexOptions().unique(true);

        coll.createIndex(new Document("Name",1),indexOptions );
        try{
            InsertOneResult nn = coll.insertOne(doc);
            return "Acknowledged";
        }catch (Exception e){
            return "Duplicate Name Value";
        }

    }
}
