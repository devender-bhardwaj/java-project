import java.util.ArrayList;
import java.util.Scanner;

import utilities.ProvidePadding;

public class FoodOrder extends Food{
    public int quantiy;
    public int orderOrder;
    FoodOrder(Food food, int quantiy, int orderOrder) {
        super(food);
        this.orderOrder = orderOrder;
        this.quantiy = quantiy;
    }

    public String toString() {
        String str = ProvidePadding.paddBoth(String.valueOf(this.orderOrder),10,' ');
        str += ProvidePadding.paddLeft(super.fname, 30, ' ');
        str += ProvidePadding.paddBoth("$"+super.price, 20, ' ');
        str += ProvidePadding.paddBoth(""+this.quantiy, 10, ' ');
        str += ProvidePadding.paddBoth("$"+super.price*this.quantiy, 10, ' ');
        return str;
    }

    public static double generateBill(ArrayList<FoodOrder> orders, Scanner sc) {
        int totalCost = 0;

        //header for table
        String header = ProvidePadding.paddBoth("Order No.", 10, ' ');
        header += ProvidePadding.paddLeft("Food", 30, ' ');
        header += ProvidePadding.paddBoth("Price", 20, ' ');
        header += ProvidePadding.paddBoth("Quantity", 10, ' ');
        header += ProvidePadding.paddBoth("Total", 10, ' ');
        System.out.println(header);

        for (FoodOrder foodOrder : orders) {
            System.out.println(foodOrder);
            totalCost += foodOrder.price * foodOrder.quantiy;
        }
        System.out.println("\nTotal Cost is: $"+totalCost);
        System.out.print("Tip :$");
        int tip = sc.nextInt();
        System.out.println("Total amount is to pay is:$"+tip + totalCost);
        while (true) {
            System.out.println("Pay bill(y/n)");
            String ans = sc.nextLine();
            if (ans.equals("Y") || ans.equals("y")) {
                break;
            } else if (ans.equals("n") || ans.equals(ans)) {
                System.out.println("You have to pay bill");
            } else {
                System.out.println("Enter a valid input");
            }

        }
        System.out.println("\nThank you for using our services");     
        return totalCost; 
    }
    
}
