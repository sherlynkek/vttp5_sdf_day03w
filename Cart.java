import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    
    public static void main(String[] args){
        
        userInput();

    }

    public static void menu(){
        System.out.println("Welcome to your shopping cart");
        System.out.println("=============================");
        System.out.println();
        System.out.println("List item in cart : type 'list'");
        System.out.println("Add item to cart : type 'add'");
        System.out.println("Delete item from cart : type 'delete'");
        System.out.println("Exit / Terminate : type 'quit'");
    }

    public static void userInput(){

        List<String> cartItems = new ArrayList<>();

        Console console = System.console();
        String keyboardInput = "";
        
        while(!keyboardInput.equals("quit")) {
            menu();

            keyboardInput = console.readLine(">>> ");
            keyboardInput = keyboardInput.toLowerCase();

            if (keyboardInput.equals("list")) {
                if(cartItems.size() > 0) {
                    for(String itm: cartItems){
                        System.out.println("Item: " + itm);
                    }

                } else {
                    System.out.println("No item in cart...");
                }
            }
            
            if (keyboardInput.startsWith("add")) {
                keyboardInput = keyboardInput.replace(',', ' ');

                Scanner scan = new Scanner(keyboardInput.substring(4));
                String tempStorage = "";
                while (scan.hasNext()) {
                    tempStorage = scan.next();
                    cartItems.add(tempStorage);
                }
                scan.close();
            }

            if (keyboardInput.startsWith("delete")) {
                Scanner scan = new Scanner(keyboardInput.substring(6));
                String deleteIndex = scan.next();
                scan.close();

                int indexToDelete = Integer.parseInt(deleteIndex) - 1;

                if(indexToDelete <= cartItems.size()) {
                    
                    if (indexToDelete < 0) {
                        System.out.println("Negative Index Position Not Found");
                    } else {
                        cartItems.remove(indexToDelete);
                    }
                } else {
                    System.out.println("Index out of bound. Delete Operation Cancelled");
                }
            }
        }
        System.out.println("See you again");
    }
}
