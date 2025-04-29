import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class TopologicalSort_DFS {
    static List<Integer>[] g; // Adjacency list representation
    static boolean[] visited; // To track visited nodes
    static Stack<Integer> stack; // To store topological order

    // DFS function to perform topological sorting
    public static void dfs(int node) {
        visited[node] = true; // Mark node as visited

        for (int child : g[node]) { // Visit all adjacent nodes
            if (!visited[child]) {
                dfs(child);
            }
        }

        stack.push(node); // Push node to stack after visiting all neighbors
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read number of nodes and edges
        int node = scanner.nextInt();
        int edge = scanner.nextInt();

        g = new ArrayList[node + 1]; // Initialize adjacency list
        visited = new boolean[node + 1]; // Initialize visited array
        stack = new Stack<>(); // Initialize stack for storing topological order

        // Initialize adjacency list for each node
        for (int i = 1; i <= node; i++) {
            g[i] = new ArrayList<>();
        }

        // Read edges (Directed Graph)
        for (int i = 0; i < edge; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            g[x].add(y); // Directed edge from x to y
        }

        // Perform Topological Sorting using DFS
        for (int i = 1; i <= node; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }

        // Print the topological order
        System.out.println("Topological Sort Order:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

        scanner.close(); // Close the scanner
    }
}
