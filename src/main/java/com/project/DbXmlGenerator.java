package com.project;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;

public class DbXmlGenerator {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://10.10.5.38:5432/template";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "postgres");
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, props);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        try {
            IDatabaseConnection dbconn = new DatabaseConnection(conn);
            QueryDataSet partDS = new QueryDataSet(dbconn);
            partDS.addTable("tx_user");
            partDS.addTable("tx_employee", "select * from tx_employee where employeeid=39106");
            FlatXmlDataSet.write(partDS, new FileOutputStream("E:/test.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
