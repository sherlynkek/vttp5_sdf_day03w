import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyList {
        public static void main(String[] args) throws Exception {

            menu();

            userInput();

        }

        public static void menu() {
            System.out.println("Welcome to your shopping cart");
            System.out.println("What would you like to do today?");
            System.out.println("> list / List items");
            System.out.println("> add / Add items into shopping cart");
            System.out.println("> delete / Delete items from shopping cart");
            System.out.println("> exit / Exit from shopping cart");
        }
    
        public static void userInput() {
            List<String> cart = new ArrayList<>();
            
            String command = "";
            Scanner scan = new Scanner(System.in);

            while(scan.hasNext()) {

                command = scan.next().toLowerCase();

                switch (command) {
                    case "list":
                        if (cart.isEmpty()) {
                            System.out.println("Your cart is empty");
                        } else {
                            for (int i = 0; i < cart.size(); i++) {
                                System.out.printf("%d. %s\n", i+1, cart.get(i));
                            }
                        }
                    break;
                    
                    case "add":
                        String[] items = scan.nextLine().trim().split(",");
                        for (int i = 0; i < items.length; i++) {
                            if (cart.contains(items[i].trim())) {
                                System.out.printf("You have %s in your cart\n", items[i].trim());
                            } else {
                                cart.add(items[i].trim());
                                System.out.printf("%s added to cart\n", items[i].trim());
                            }
                        }
                    break;

                    case "delete":
                        int deleteIndex = scan.nextInt();
                        if (deleteIndex <= cart.size()) {
                                System.out.printf("%s removed from cart\n", cart.get(deleteIndex - 1));
                                cart.remove(deleteIndex - 1);
                        } else {
                                System.out.println("incorrect item index");
                        }
                    break;

                    case "exit":
                        System.out.println("See you again");    
                        System.exit(0);

                    default:
                        System.out.println("Command not recognized. Please try again");
                }
            }
        }
    }