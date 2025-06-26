
import java.util.Arrays;
import java.util.Scanner;

public class FracKnapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] weights = new int[n];
        int[] values = new int[n];

        for(int i = 0 ; i < n ; i++){
            weights[i] = sc.nextInt();
        }

        for(int i = 0 ; i < n ; i++){
            values[i] = sc.nextInt();
        }

        int capacity = sc.nextInt();
        System.out.println("Maximum value in Knapsack = " + knapsack(weights, values, n, capacity));
    }

    static Double knapsack(int[] weights, int[] values, int n, int capacity){
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(weights[i], values[i]);
        }
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        double totalValue = 0.0;
        int remainingCapacity = capacity;

        for (int i = 0; i < n && remainingCapacity > 0; i++) {
            if (items[i].weight <= remainingCapacity) {
                totalValue += items[i].value;
                remainingCapacity -= items[i].weight;
            } else {
                // Take fraction of the item
                totalValue += items[i].ratio * remainingCapacity;
                remainingCapacity = 0;
            }
        }
        return totalValue;
    }

    static class Item {
        int weight, value;
        double ratio;
        Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
            this.ratio = (double)value / weight;
        }
    }
}
