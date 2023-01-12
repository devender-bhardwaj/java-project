package utilities;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class CP {
    static String url = "jdbc:mysql://localhost:3306/";
    static String user;
    static String password;

    public static Connection getC(String database, Scanner sc) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        File fileObj = new File("userData.txt");
        if (fileObj.exists()) {
            try {
                Scanner myReader = new Scanner(fileObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    user = data;
                    break;
                }
                myReader.close();
            } catch (Exception e) {
                System.out.println("Enter username for mysql database: ");
                user = sc.nextLine();
            }
        } else {
            try {
                fileObj.createNewFile();
                System.out.println("Enter username for mysql database: ");
                user = sc.nextLine();
                FileWriter fileWriter = new FileWriter(fileObj);
                fileWriter.write(user);
                fileWriter.close();
            } catch (Exception e) {
                System.out.println("Enter username for mysql database: ");
                user = sc.nextLine();
            }
        }
        System.out.println("Enter password for database: ");
        password = sc.nextLine();
        url = url + database;
        return DriverManager.getConnection(url, user, password);
    }
}
