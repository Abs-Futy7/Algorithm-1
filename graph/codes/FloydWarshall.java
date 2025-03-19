import java.util.*;

public class FloydWarshall {
    int[][] dist; // Distance matrix

    // Constructor to initialize the graph
    FloydWarshall(int nodes) {
        dist = new int[nodes][nodes];

        // Initialize distance matrix
        for (int i = 0; i < nodes; i++) {
            Arrays.fill(dist[i], (int) 1e9); // Set all distances to infinity
            dist[i][i] = 0; // Distance to itself is 0
        }
    }

    // Add an edge to the graph
    void addEdge(int u, int v, int weight) {
        dist[u][v] = weight; // Directed edge from u -> v
    }

    // Floyd-Warshall Algorithm
    void floydWarshall() {
        int nodes = dist.length; // Get the graph length
        for (int k = 0; k < nodes; k++) { // Intermediate node
            for (int i = 0; i < nodes; i++) { // Start node
                for (int j = 0; j < nodes; j++) { // End node
                    if (dist[i][k] < 1e9 && dist[k][j] < 1e9) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
    }

    // Main function to take input and run Floyd-Warshall
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read number of nodes and edges
        int nodes = scanner.nextInt();
        int edges = scanner.nextInt();

        // Create the graph
        FloydWarshall graph = new FloydWarshall(nodes);

        // Read edges (adjust indexing if input is 1-based)
        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt() - 1; // Decrement by 1 to adjust to 0-based index
            int v = scanner.nextInt() - 1; // Decrement by 1 to adjust to 0-based index
            int weight = scanner.nextInt();
            graph.addEdge(u, v, weight);
        }

        // Run Floyd-Warshall Algorithm
        graph.floydWarshall();

        // Print shortest distances in main
        System.out.println("All-Pairs Shortest Paths:");
        int n = graph.dist.length; // Get the graph length
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph.dist[i][j] == (int) 1e9) {
                    System.out.print("INF ");
                } else {
                    System.out.print(graph.dist[i][j] + " ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}
