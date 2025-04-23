import java.io.*;
import java.util.*;

public class SearchInventoryMap {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Map<String , Product> inventory = loadInventory("inventory.csv");

        boolean keepSearching = true;
        while (keepSearching){
            System.out.print("\nEnter the product name: ");
            String name = scanner.nextLine();

            Product found = inventory.get(name);

            if (found != null){
                System.out.println("Product found: " + found);
            } else {
                System.out.println("Product not found.");
            }

            System.out.print("Do you want to search again? (yes/no): ");
            String answer = scanner.nextLine().toLowerCase();
            keepSearching = answer.equals("yes");
        }

        System.out.println("Thank you for shopping!");
    }

    public static Map<String, Product> loadInventory(String filename){
        Map<String, Product> inventory = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line;

            while ((line = reader.readLine()) != null){
                String[] tokens = line.split("\\|");

                if (tokens.length >= 3) {
                    int id = Integer.parseInt(tokens[0].trim());
                    String name = tokens[1].trim();
                    double price = Double.parseDouble(tokens[2].trim());

                    Product product = new Product(id, name, price);
                    inventory.put(name, product);
                } else {
                    System.out.println("Skipping invalid line: " + Arrays.toString(tokens));
                }
            }
        } catch (IOException e){
            System.out.println("Error reading file: " + e.getMessage());
        }

        return inventory;
    }
}