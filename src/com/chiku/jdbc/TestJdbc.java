package com.chiku.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {

        String jdbcUrl =
                "jdbc:mysql://localhost:3306/spring_hb_student_tracker?useSSL=false&Timezone=UTC";
        String username = "developer";
        String password = "TESTtest";

        try {
            System.out.println("Connecting to database: " + jdbcUrl);
            Connection connection =
                    DriverManager.getConnection(jdbcUrl, username, password);

            System.out.println("Connection successful!!!!!!!!!!!");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
