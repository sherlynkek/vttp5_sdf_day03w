package src;

import java.io.File;

public class ShoppingCartApp {
    public static void main(String[] args) {
        // Determine the directory to use for storing the cart
        String cartDirectory;

        if (args.length > 0) {
            // If the user specifies a directory, use that
            cartDirectory = args[0];
        } else {
            // If no directory is specified, default to "db"
            cartDirectory = "db";
        }

        // Create a File object for the directory
        File cartDir = new File(cartDirectory);

        // Check if the directory exists
        if (!cartDir.exists()) {
            // If it doesn't exist, create it
            if (cartDir.mkdir()) {
                System.out.println("Directory " + cartDirectory + " created.");
            } else {
                System.out.println("Failed to create directory.");
            }
        } else {
            System.out.println("Using existing directory: " + cartDirectory);
        }

        // From here, you can proceed to store the user's cart in this directory
    }
}
