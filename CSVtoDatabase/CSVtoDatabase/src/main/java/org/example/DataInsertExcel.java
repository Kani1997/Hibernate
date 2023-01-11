package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import static java.lang.Integer.parseInt;

public class DataInsertExcel {
    public static void main(String[] args) {
        String jdbcUrl="jdbc:mysql://localhost:3306/RegularDetail";
        String username="root";
        String password="Kani@123";

        String filePath="C:\\Users\\KANIMOZHI\\OneDrive\\Desktop\\RegularDetails.csv";
        int batchSize=20;

        Connection connection=null;
        try{
            connection= DriverManager.getConnection(jdbcUrl,username,password);
            connection.setAutoCommit(false);

            String sql="insert into rg(Empid,EmpName,EmpDepartment)values(?,?,?)";

            PreparedStatement statement=connection.prepareStatement(sql);

            BufferedReader lineReader=new BufferedReader(new FileReader(filePath));

            String lineText=null;
            int count=0;

            lineReader.readLine();
            while ((lineText=lineReader.readLine())!=null){
                String[] data =lineText.split(",");

                String Empid=data[0];
                String EmpName=data[1];
                String EmpDepartment=data[2];


                statement.setInt(1,parseInt(Empid));
                statement.setString(2,EmpName);
                statement.setString(3,EmpDepartment);

                statement.addBatch();

                if(count%batchSize==0){
                    statement.executeBatch();
                }
            }
            lineReader.close();
            statement.executeBatch();
            connection.commit();
            connection.close();

            System.out.println("Data has been inserted successfully");



        }catch(Exception exception){
            exception.printStackTrace();
        }


    }
}