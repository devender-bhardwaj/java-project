import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import utilities.CP;

public class App {
    public static void customerLog(Connection con, Scanner sc) throws SQLException {
        Menu menu = new Menu(con);
        ArrayList<FoodOrder> orders = menu.takeOrder(sc);
        FoodOrder.generateBill(orders);
    }

    public static int start(Scanner sc) {
        int choice;
            while (true) {
                try {
                    choice = sc.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Enter a valid input");
                    e.printStackTrace();
                }
            }
        
        return choice;
    }
    public static boolean ownerLog(Connection con, Scanner sc) throws SQLException {
            System.out.println("Enter: ");
            System.out.println("0 for Exiting from program");
            System.out.println("1 for Displaying all customers");
            System.out.println("2 for Displaying menu");
            System.out.println("3 for Adding new customer");
            int choice ;
            while (true) {
                try {
                    choice = sc.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Enter a valid input");
                    e.printStackTrace();
            }
            }
            
            switch (choice) {
                case 0:
                    return false;
                case 1:
                    Customer.displayAllCustomers(con);
                    return true;
                case 2 :
                    new Menu(con).displayMenu();
                    return true;
                case 3 :
                    Customer.addCustomer(con,sc);
                    return true;
                default:
                    System.out.println("Enter a valid input");
                    return true;
            }
        }
    
    public static void main(String[] args) throws Exception {
        Connection con = CP.getC("restaurant");
        System.out.println("Enter:");
        System.out.println("1 if you are owner");
        System.out.println("2 if you are customer");
        Scanner sc = new Scanner(System.in);
        int choice = start(sc);
        
        if (choice == 1) {
            while (ownerLog(con , sc)) ;
        } else if (choice == 2) {
            customerLog(con,sc);
        } else {
            System.out.println("Enter a valid input");
        }
        con.close();
    }

}
