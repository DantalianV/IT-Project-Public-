import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Delivery {

    private int itemNumber = 0;
    FoodAccount user;

    public Delivery(FoodAccount user) {
        this.user = user;
    }

    public void addInCart(Restaurant restaurant) {

        user.cart[itemNumber] = "";
        System.out.println();
        restaurant.menu.displayMenu();
        System.out.println("\nEnter the number corresponding to the item you want to order\n");
        int input = StdIn.readInt();
        user.cart[itemNumber] = restaurant.menu.menu[input - 1];
        itemNumber++;
        System.out.println("\n" + restaurant.menu.menu[input - 1] + " was added to your cart!");
        System.out.println("\nPress 1 if you want to order more or 2 if you want to checkout\n");
        input = StdIn.readInt();
        if (input == 1)
            addInCart(restaurant);
        Date date = new Date();
        user.timeOrdered = date.toString();
    }

    public void start() {

        Restaurant restaurant;
        RestaurantList resList = new RestaurantList();

        System.out.println("\nPress 1 if you want to search by city");
        System.out.println("Press 2 if you want to search by rating");
        System.out.println("Press 3 if you want to search by type");
        System.out.println("Press 4 if you want to search by name\n");

        int input = StdIn.readInt();

        if (input == 1) {
            System.out.println("\nEnter the city you want to search in:\n");
            String city = StdIn.readString();
            Restaurant[] newList = resList.searchByLocation(city);
            RestaurantList.printRes(newList);
            System.out.println("Press the number corresponding to the restaurant to select it\n");
            input = StdIn.readInt();
            restaurant = newList[input];
        }

        else if (input == 2) {
            System.out.println("\nEnter the rating you want to search by (number from 0 - 5)\n");
            double rating = StdIn.readDouble();
            Restaurant[] newList = resList.searchByRating(rating);
            RestaurantList.printRes(newList);
            System.out.println("Press the number corresponding to the restaurant to select it\n");
            input = StdIn.readInt();
            restaurant = newList[input];
        }

        else if (input == 3) {
            Restaurant[] newList = resList.searchByType();
            RestaurantList.printRes(newList);
            System.out.println("Press the number corresponding to the restaurant to select it\n");
            input = StdIn.readInt();
            restaurant = newList[input];
        }

        else if (input == 4) {
            System.out.println("\nEnter the name of the restaurant\n");
            String name = StdIn.readString();
            restaurant = resList.searchByName(name);
        }

        else {
            System.out.println("\nInvalid input");
            return;
        }

        addInCart(restaurant);

        File f = new File("cart.txt");
        try {
            FileWriter fw = new FileWriter(f,true);
            String str = "";

            str += user.accNumber + ";" + user.timeOrdered;
            for (int i = 0; user.cart[i] != null; i++)
            {
                str += ";" + user.cart[i];
            }
            fw.write(str + "\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\nYour order will be delivered in 45 minutes, you can log in again to check how much longer the delivery will take\n");
        System.out.println("Thank you!");
    }

    public void checkDelivery() {
        if (user.cart[0] == null) {
            System.out.println("\nNo order has been placed yet");
            return;
        }

        System.out.println("\nThe items ordered are:");
        for (int i = 0; user.cart[i] != null; i++) {
            System.out.println(user.cart[i]);
        }
        System.out.println("\nThe order was placed at: " + user.timeOrdered);
        System.out.println("\nOrders usually take 45 minutes to be delivered");
    }
}
