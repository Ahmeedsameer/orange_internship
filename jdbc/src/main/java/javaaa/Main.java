package javaaa;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection;
        final String url = "jdbc:mariadb://Localhost:3306/test";
        final String user_name = "root";
        final String password = "root";
        String name, email, passwordd;
        int Number_of_admins, searchid;
        final String create_table = """
                CREATE TABLE IF NOT EXISTS admin(
                id INT PRIMARY KEY AUTO_INCREMENT,
                name VARCHAR(100),
                email VARCHAR(100),
                password VARCHAR(100)
                )
                """;
        final String insert = "INSERT INTO admin(name,email,password) values (?,?,?)";
        connection = DriverManager.getConnection(url, user_name, password);
        connection.createStatement().executeUpdate(create_table);
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the number of admins you want ");
        Number_of_admins = scanner.nextInt();
        scanner.nextLine();
        PreparedStatement insert_sta = connection.prepareStatement(insert);
        for (int i = 0; i < Number_of_admins; i++) {
            System.out.println("enter the admin information number : " + i);
            System.out.println("enter the Name of admin : ");
            name = scanner.nextLine();
            System.out.println("enter the email of admin  : ");
            email = scanner.nextLine();
            System.out.println("enter the password : ");
            passwordd = scanner.nextLine();
            insert_sta.setString(1, name);
            insert_sta.setString(2, email);
            insert_sta.setString(3, passwordd);
            insert_sta.executeUpdate();
        }
        System.out.println("enter admin id to know details ");
        searchid = scanner.nextInt();
        final String select = "select * from admin where id= ?";
        PreparedStatement searchst = connection.prepareStatement(select);
        searchst.setInt(1, searchid);
        ResultSet resultSet = searchst.executeQuery();
        if (resultSet.next()) {
            System.out.println("id : " + resultSet.getInt("id"));
            System.out.println("name : " + resultSet.getString("name"));
            System.out.println("email : " + resultSet.getString("email"));
            System.out.println("password : " + resultSet.getString("password"));
        } else {
            System.out.println("nothing in table");
        }
//        System.out.println("All admins in table:");// for test the bugs
//        ResultSet all = connection.createStatement().executeQuery("SELECT * FROM admin");
//        while (all.next()) {
//            System.out.println(all.getInt("id") + " - " + all.getString("name"));
//        }
        try {


            final String clean = "DROP TABLE admin";
            PreparedStatement cleann = connection.prepareStatement(clean);
            cleann.executeUpdate();
        } catch (SQLException e) {
            System.out.println("admin dosenot deleted");
        }
        connection.close();
    }
}