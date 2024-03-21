package org.example;

import java.util.Random;
import java.util.UUID;

public class Employee extends worker{
    private UUID EmployeeID;
    private String hireDate;

    public Employee(){

    }
    public Employee(String name,String birthDate,String hireDate){
        this(name,birthDate,1L,hireDate);
    }
    public Employee(String name, String birthDate, long EmployeeID,String hireDate) {
        super(name, birthDate);
        this.hireDate = hireDate;
        this.EmployeeID = nn;

    }
    public int yearspent(String hireDate){
        String[] n = hireDate.split("/");
        String getage = n[2];
        int convert = Integer.parseInt(getage);
        return convert - 2024;
    }



    UUID ud  = new UUID(99999999999L,222222222222L);
    long mostBits = get64MostSignificantBitsForVersion1();
    long leastBits = get64LeastSignificantBitsForVersion1();
    UUID nn = new UUID(mostBits, leastBits);

    private static long get64LeastSignificantBitsForVersion1() {
        Random random = new Random();
        long random63BitLong = random.nextLong() & 0x3FFFFFFFFFFFFFFFL;
        long variant3BitFlag = 0x8000000000000000L;
        return random63BitLong | variant3BitFlag;
    }
    private static long get64MostSignificantBitsForVersion1() {
        final long currentTimeMillis = System.currentTimeMillis();
        final long time_low = (currentTimeMillis & 0x0000_0000_FFFF_FFFFL) << 32;
        final long time_mid = ((currentTimeMillis >> 32) & 0xFFFF) << 16;
        final long version = 1 << 12;
        final long time_hi = ((currentTimeMillis >> 48) & 0x0FFF);
        return time_low | time_mid | version | time_hi;
    }
    public static UUID generateType1UUID() {
        long most64SigBits = get64MostSignificantBitsForVersion1();
        long least64SigBits = get64LeastSignificantBitsForVersion1();
        return new UUID(most64SigBits, least64SigBits);
    }
    @Override
    public String toString() {
        return "Employee{" +
                "EmployeeID=" + EmployeeID +
                ", hireDate='" + hireDate + '\'' +
                ", Year_Spent='" + yearspent(hireDate) + '\'' +
                "} " + super.toString();
    }
}
