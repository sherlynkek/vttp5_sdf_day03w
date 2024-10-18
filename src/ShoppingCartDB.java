package src;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartDB {
    private String cartDirectory;
    private String currentUser;
    private List<String> cart;

    public ShoppingCartDB(String cartDirectory) {
        this.cartDirectory = cartDirectory;
        this.cart = new ArrayList<>();
    }

    // Method to login or load a user's cart file
    public void login(String username) throws IOException {
        this.currentUser = username;
        String userFile = cartDirectory + "/" + username + ".db";
        File file = new File(userFile);

        if (!file.exists()) {
            // If the user file does not exist, create it
            file.createNewFile();
            System.out.println("New user file created for: " + username);
        } else {
            // Load the cart contents from the file (if the file exists)
            cart = Files.readAllLines(Paths.get(userFile));
            System.out.println("User " + username + " logged in. Cart loaded.");
        }
    }

    // Method to save the cart
    public void save() throws IOException {
        if (currentUser == null) {
            System.out.println("Please login first before saving.");
            return;
        }
        
        String userFile = cartDirectory + "/" + currentUser + ".db";
        Files.write(Paths.get(userFile), cart); // Save cart items to user's file
        System.out.println("Cart saved for user: " + currentUser);
    }

    // Method to list all users (all *.db files in cart directory)
    public void listUsers() {
        File dir = new File(cartDirectory);
        File[] files = dir.listFiles((d, name) -> name.endsWith(".db"));
        
        if (files != null && files.length > 0) {
            System.out.println("Users:");
            for (File file : files) {
                System.out.println(file.getName().replace(".db", ""));
            }
        } else {
            System.out.println("No users found.");
        }
    }

    // Method to add items to the cart
    public void addToCart(String item) {
        cart.add(item);
    }

    // Method to display the cart
    public void displayCart() {
        System.out.println("Your cart:");
        for (String item : cart) {
            System.out.println("- " + item);
        }
    }
}
