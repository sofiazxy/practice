/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenumstatistics;

import java.util.Random;
import java.sql.*;

/**
 *
 * @author sofiazxy
 */
public class StdNormDist {
    

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/teststat";

    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "";

    public static void main (String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Inserting records into the table...");
            stmt = conn.createStatement();
             // create random object 
        Random ran = new Random(); 
  
        for (int i=0;i<1000;i++)
        {
        // generating integer 
        double nxt = ran.nextGaussian(); 
  
        // Printing the random Number 
        System.out.println("The next Gaussian value generated is : " + nxt); 
        

            String sql = "INSERT INTO teststat " + "VALUES (i,nxt,0 ,0)";

            stmt.executeUpdate(sql);
            
        }

            System.out.println("Inserted records into the table...");

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt!=null)
                    conn.close();
            } catch (SQLException se) {
            } // do nothing
            try {
                if (conn!=null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } //end finally try
        } //end try

        System.out.println("Goodbye!");

    } //end main

//     public static void main (String args[])
 //    {
 //        System.out.println("Calling gaussianVal");
 //        gaussianVal();
 //    }
    public static void gaussianVal() 
    { 
  
        // create random object 
        Random ran = new Random(); 
  
        for (int i=0;i<1000;i++)
        {
        // generating integer 
        double nxt = ran.nextGaussian(); 
  
        // Printing the random Number 
        System.out.println("The next Gaussian value generated is : " + nxt); 
        }
    } 
} 

