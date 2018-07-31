package com.company;
//import for db connect

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;


public class Main
{
    //这两种方式都是可以的

//    private static void take(Demo<?> animal)
//    {
//        animal.print();
//    }
//
//    private static <T extends Animal> void take(Demo<T> animal)
//    {
//        animal.print();
//    }

    public static void main(String[] args)
    {
        Demo<Dog> one = new Demo<>(new Dog());
        Demo<Cat> two = new Demo<>(new Cat());
        one.print();
        two.print();


//        int i=99;
//        System.out.println(Integer.toString(i).length());
//        db(pwd());
    }

    private static String pwd()
    {
        try
        {
            String temp=JavaPassword.createHash("1234");
            System.out.println(temp);
            return temp;
        }
        catch(Exception ex)
        {
            System.out.println("ERROR: " + ex);
        }

        return null;
    }

    private static void db(String hash)
    {
//        System.err.println("HelloWorld");
//        System.out.println("HelloWorld");
//
//        System.out.println(System.in);
//        System.out.println(System.out);
//        System.out.println(System.err);

        String drivename="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String dburl="jdbc:sqlserver://徐络溟SURFACEPR\\SQLEXPRESS:2537;DatabaseName=JavaTest";
        String remoteurl="jdbc:sqlserver://182.254.223.162;database=javaChatHouse";
        String SQL="SELECT * FROM JavaTest.dbo.testTable";
        String sqlupdate="update testTable set name='u' where id=435";
        String sqlinsert="insert test(id,pwd) values(1234,'"+hash+"')";
        System.out.println(sqlinsert);
        //delete insert update 语句要用stat.executeUpdate();stat.getUpdateCount()
        //可以获取影响的行数

        Connection conn;
        try
        {
            String username="javaChatHouse";
            String userpwd="javachat";
            Class.forName(drivename);
            System.out.println("load jdbcdrive successful");
            conn=DriverManager.getConnection(remoteurl, username, userpwd);
            if (conn!=null)
            {
                System.out.println("connection successful");
            }
            else
            {
                System.out.println("connection fail");
                return;
            }
            //通过statment来执行sql语句, 通过resultset来接收返回的结果
            Statement stat=conn.createStatement();
            stat.executeUpdate(sqlinsert);
            System.out.println("affected rows: "+stat.getUpdateCount());
//            rs.last();
//            System.out.println("effected rows: "+rs.getRow());
//            rs.first();System.out.println("dfjk: "+rs.getRow());
//            while (rs.next())
//            {
//                System.out.println(rs.getString(1));
//                //不知道为什么, 这边用直接利用index:0, 就不行, 不许用"name"
//            }
        }
        catch(Exception e)
        {
            System.out.println("error: " + e);
            e.printStackTrace();
        }
    }
}
