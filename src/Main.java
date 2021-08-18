import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("\n\n\t\t\t\t\tHi!\n\n");

        FoodAccount user = new FoodAccount();
        user = user.start();
        Scanner scan = new Scanner(System.in);

        System.out.println("\n\nWelcome " + user.userId + ", what can we do for you");
        System.out.println("\n\n1] Browse / review restaurants \n2] Delivery / Takeaway \n3] Reserve Tables \n4] Check Delivery \n5] Check Reservation\n");

        int input = StdIn.readInt();

        while (input < 1 || input > 5) {
            System.out.println("\nEnter a valid number!\n");
            input = StdIn.readInt();
        }

        Delivery delivery = new Delivery(user);

        if (input == 1) {
            Restaurant restaurant;
            RestaurantList resList = new RestaurantList();

            System.out.println("\n1] Search restaurant by city");
            System.out.println("2] Search restaurant by rating");
            System.out.println("3] Search restaurant by category");
            System.out.println("4] Search restaurant by name\n");

            input = StdIn.readInt();

            while (input > 4 || input < 1) {
                System.out.println("\nEnter a valid number!\n");
                input = StdIn.readInt();
            }

            if (input == 1) {
                System.out.println("\n1] Chennai\n2] Bangalore\n3] Hyderabad\n4] Kolkata\n5] Delhi");
                System.out.println("6] Pune\n7] Coimbatore\n8] Vadodara\n9] Ahmedabad\n10] Jaipur\n");
                input = StdIn.readInt();
                System.out.println();

                while (input > 10 || input < 1) {
                    System.out.println("\nEnter a valid number!\n");
                    input = StdIn.readInt();
                }

                Restaurant[] newList;

                if (input == 1) {
                    String city = "Chennai";
                    newList = resList.searchByLocation(city);
                } else if (input == 2) {
                    String city = "Bangalore";
                    newList = resList.searchByLocation(city);
                } else if (input == 3) {
                    String city = "Hyderabad";
                    newList = resList.searchByLocation(city);
                } else if (input == 4) {
                    String city = "Kolkata";
                    newList = resList.searchByLocation(city);
                } else if (input == 5) {
                    String city = "Delhi";
                    newList = resList.searchByLocation(city);
                } else if (input == 6) {
                    String city = "Pune";
                    newList = resList.searchByLocation(city);
                } else if (input == 7) {
                    String city = "Coimbatore";
                    newList = resList.searchByLocation(city);
                } else if (input == 8) {
                    String city = "Vadodara";
                    newList = resList.searchByLocation(city);
                } else if (input == 9) {
                    String city = "Ahmedabad";
                    newList = resList.searchByLocation(city);
                } else {
                    String city = "Jaipur";
                    newList = resList.searchByLocation(city);
                }

                RestaurantList.printRes(newList);
                System.out.println("Enter the number corresponding to the restaurant to select it\n");
                input = StdIn.readInt() - 1;
                System.out.println();
                restaurant = newList[input];
            } else if (input == 2) {
                System.out.println("\nEnter the rating you want to search by (number from 0 - 5)\n");
                double rating = StdIn.readDouble();
                while (rating < 0 || rating > 5) {
                    System.out.println("\nEnter a valid number!\n");
                    rating = StdIn.readInt();
                }
                System.out.println();
                Restaurant[] newList = resList.searchByRating(rating);
                RestaurantList.printRes(newList);
                System.out.println("Enter the number corresponding to the restaurant to select it\n");
                input = StdIn.readInt() - 1;
                System.out.println();
                restaurant = newList[input];
            } else if (input == 3) {
                Restaurant[] newList = resList.searchByType();
                RestaurantList.printRes(newList);
                System.out.println("Enter the number corresponding to the restaurant to select it\n");
                input = StdIn.readInt() - 1;
                System.out.println();
                restaurant = newList[input];
            } else {
                String name;
                System.out.println("\nEnter the name of the restaurant: ");
                name = scan.next();
                restaurant = resList.searchByName(name);
                while (restaurant.name.equalsIgnoreCase("not found")) {
                    System.out.println("\nNo restaurants found");
                    System.out.println("Enter the name of the restaurant: ");
                    name = scan.next();
                    restaurant = resList.searchByName(name);
                }
                System.out.println();
            }

            System.out.println(restaurant.toString());

            if (restaurant.getReview().equalsIgnoreCase("good")) {
                System.out.println("This restaurant has no reviews yet, Enter 1 if you want to leave a review and 2 if you want to exit\n");
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
        } else if (input == 2) {
            delivery.start();
        } else if (input == 3) {
            Reservation reservation = new Reservation();
            reservation.start(user);
        } else if(input == 4) {
            delivery.checkDelivery();
        } else {
            System.out.println();
        	Reservation.checkReservation(user);
        }
    }
}
