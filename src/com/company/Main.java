package com.company;

import com.sun.corba.se.spi.presentation.rmi.IDLNameTranslator;
import sun.plugin.util.UserProfile;

import java.util.Scanner;

import static java.lang.System.out;
//import for db connect
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main
{
    public static void main(String[] args)
    {
        System.err.println("HelloWorld");
        System.out.println("HelloWorld");

        System.out.println(System.in);
        System.out.println(System.out);
        System.out.println(System.err);

        String drivename="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String dburl="jdbc:sqlserver://徐络溟SURFACEPR\\SQLEXPRESS:2537;DatabaseName=JavaTest";
        String SQL="SELECT * FROM JavaTest.dbo.testTable ORDER BY id DESC";
        Connection conn;
        try
        {
            String username="sa";
            String userpwd="xuluoming";
            Class.forName(drivename);
            System.out.println("load jdbcdrive successful");
            conn=DriverManager.getConnection(dburl, username, userpwd);
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
            ResultSet rs=stat.executeQuery(SQL);
            while (rs.next())
            {
                System.out.println(rs.getString("name"));
                //不知道为什么, 这边用直接利用index:0, 就不行, 不许用"name"
            }
        }
        catch(Exception e)
        {
            System.out.println("error: " + e);
            e.printStackTrace();
        }

    }
}
