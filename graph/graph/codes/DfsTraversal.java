import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DfsTraversal {
    static List<Integer>[] g; // Adjacency list representation of the graph
    static boolean[] visited; // Array to keep track of visited nodes

    // DFS function to explore the graph recursively
    static void dfs(int node) {
        visited[node] = true; // Mark the current node as visited
        System.out.print(node + " "); // Print the current node

        for (int child : g[node]) { // Iterate through all adjacent nodes
            if (!visited[child]) { // If the adjacent node is not visited
                dfs(child); // Recursively visit the child node
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int node = scanner.nextInt();
        int edge = scanner.nextInt();
        
        g = new ArrayList[node + 1]; // Initialize adjacency list
        visited = new boolean[node + 1]; // Initialize visited array

        // Initialize each list in the adjacency list
        for (int i = 1; i <= node; i++) {
            g[i] = new ArrayList<>();
        }

        // Read edges and construct the adjacency list
        for (int i = 0; i < edge; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            g[x].add(y); // Add edge from x to y
            g[y].add(x); // Since the graph is undirected, add edge from y to x
        }

        System.out.println("DFS Traversal Output:");

        for (int i = 1; i <= node; i++) {
            if (!visited[i]) {
                dfs(i);
                System.out.println();
            }
        }

        scanner.close();
    }
}
