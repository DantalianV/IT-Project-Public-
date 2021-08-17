import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        FoodAccount user = new FoodAccount();
        user = user.start();
        Scanner scan = new Scanner(System.in);

        System.out.println("\n\nWelcome " + user.userId + ", what can we do for you");
        System.out.println("\n\n1] Browse / review restaurants \n2] Delivery / Takeaway \n3] Reserve Tables \n4] Check Delivery \n5] Check Reservation\n");

        int input = StdIn.readInt();
        Delivery delivery = new Delivery(user);

        if (input == 1) {
            Restaurant restaurant;
            RestaurantList resList = new RestaurantList();

            System.out.println("\n1] Search restaurant by city");
            System.out.println("2] Search restaurant by rating");
            System.out.println("3] Search restaurant by type");
            System.out.println("4] Search restaurant by name\n");

            input = StdIn.readInt();

            if (input == 1) {
                System.out.println("\nEnter the city you want to search in:\n");
                String city = StdIn.readString();
                Restaurant[] newList = resList.searchByLocation(city);
                RestaurantList.printRes(newList);
                System.out.println("Press the number corresponding to the restaurant to select it\n");
                input = StdIn.readInt();
                System.out.println();
                restaurant = newList[input];
            }

            else if (input == 2) {
                System.out.println("\nEnter the rating you want to search by (number from 0 - 5)\n");
                double rating = StdIn.readDouble();
                Restaurant[] newList = resList.searchByRating(rating);
                RestaurantList.printRes(newList);
                System.out.println("Press the number corresponding to the restaurant to select it\n");
                input = StdIn.readInt();
                System.out.println();
                restaurant = newList[input];
            }

            else if (input == 3) {
                Restaurant[] newList = resList.searchByType();
                RestaurantList.printRes(newList);
                System.out.println("Press the number corresponding to the restaurant to select it\n");
                input = StdIn.readInt();
                System.out.println();
                restaurant = newList[input];
            }

            else if (input == 4) {
                System.out.println("\nEnter the name of the restaurant\n");
                String name = StdIn.readString();
                System.out.println();
                restaurant = resList.searchByName(name);
            }

            else {
                System.out.println("\nInvalid input");
                return;
            }

            System.out.println(restaurant.toString());

            if (restaurant.getReview().equalsIgnoreCase("good")) {
                System.out.println("This restaurant has no reviews yet, press 1 if you want to leave a review\n");
                input = StdIn.readInt();
                System.out.println();
                if (input == 1) {

                    System.out.println("Please type your review: ");
                    System.out.println();
                    String review = scan.nextLine();
                    restaurant.updateReview(review);
                    System.out.println();
                    System.out.println("Your review has been recorded!");
                }
            }
        }

        else if (input == 2) {
            delivery.start();
        }
        else if (input == 3) {
            Reservation reservation = new Reservation();
            reservation.start(user);
        }
        else if(input == 4) {
            delivery.checkDelivery();
        }
    }
}
