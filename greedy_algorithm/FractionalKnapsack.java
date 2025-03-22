import java.util.*;

public class FractionalKnapsack {
    List<Item> items;  // List to store items
    int n;  // Number of items

    // Constructor to initialize the list
    FractionalKnapsack(int n) {
        this.n = n;
        items = new ArrayList<>();
    }

    // Class to store item details (weight, value)
    static class Item {
        int weight, value;
        double profitPerWeight;
        Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
            this.profitPerWeight = (double) value / weight;
        }
    }

    // Function to add an item to the list
    void addItem(int weight, int value) {
        items.add(new Item(weight, value));
    }

    // Function to find the maximum value using the Greedy approach
    double getMaxValue(int capacity) {
        // Sort items by value/weight ratio in descending order
        items.sort((a, b) -> Double.compare(b.profitPerWeight, a.profitPerWeight));

        double totalValue = 0.0;  // Total value in the knapsack

        // Iterate through sorted items
        for (Item item : items) {
            if (capacity == 0) break;  // Stop when the knapsack is full

            if (item.weight <= capacity) {  // If the whole item fits, take it
                totalValue += item.value;
                capacity -= item.weight;
            } else {  // If only a part of the item fits, take the fraction
                totalValue += (double) item.value * capacity / item.weight;
                break;  // Knapsack is now full, so stop
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: number of items and knapsack capacity
        System.out.print("Enter the number of items: ");
        int n = sc.nextInt();
        System.out.print("Enter the knapsack capacity: ");
        int capacity = sc.nextInt();

        // Create an instance of the FractionalKnapsack class
        FractionalKnapsack knapsack = new FractionalKnapsack(n);

        // Read items (weight, value)
        System.out.println("Enter weight and value for each item:");
        for (int i = 0; i < n; i++) {
            int weight = sc.nextInt();
            int value = sc.nextInt();
            knapsack.addItem(weight, value);
        }

        // Compute the maximum value for the given capacity
        double maxValue = knapsack.getMaxValue(capacity);
        System.out.println("Maximum value in Knapsack = " + maxValue);

        sc.close();
    }
}
