import java.util.*;

public class PrimMST {
    int[][] graph; // Adjacency matrix
    int nodeCount; // Number of nodes

    // Constructor to initialize the graph with INF (indicating no direct edge)
    PrimMST(int nodeCount) {
        this.nodeCount = nodeCount;
        graph = new int[nodeCount][nodeCount];

        for (int i = 0; i < nodeCount; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE); // Set all edges as INF initially
            graph[i][i] = 0; // Distance to itself is 0
        }
    }

    // Add an edge to the graph (undirected)
    void addEdge(int u, int v, int weight) {
        graph[u][v] = weight;
        graph[v][u] = weight;
    }

    // Function to find the Minimum Spanning Tree using Prim's Algorithm
    int primMST() {
        boolean[] visited = new boolean[nodeCount]; // Track included nodes
        int[] minEdge = new int[nodeCount]; // Minimum edge weight to each node
        Arrays.fill(minEdge, Integer.MAX_VALUE); 
        minEdge[0] = 0; // Start from node 0

        int totalCost = 0;

        for (int i = 0; i < nodeCount; i++) {
            int u = -1;

            // Find the minimum edge that connects to an unvisited node
            for (int j = 0; j < nodeCount; j++) {
                if (!visited[j] && (u == -1 || minEdge[j] < minEdge[u])) {
                    u = j;
                }
            }

            visited[u] = true; // Mark node as visited
            totalCost += minEdge[u]; // Add edge weight to MST cost

            // Update minimum edge weights for adjacent nodes
            for (int v = 0; v < nodeCount; v++) {
                if (!visited[v] && graph[u][v] != Integer.MAX_VALUE) {
                    minEdge[v] = Math.min(minEdge[v], graph[u][v]);
                }
            }
        }
        return totalCost; // Return MST cost
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read number of nodes and edges
        System.out.print("Enter number of nodes: ");
        int node = scanner.nextInt();
        System.out.print("Enter number of edges: ");
        int edge = scanner.nextInt();

        // Create the graph
        PrimMST graph = new PrimMST(node);

        // Read edges
        System.out.println("Enter edges (u v weight):");
        for (int i = 0; i < edge; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int weight = scanner.nextInt();
            graph.addEdge(u, v, weight);
        }

        // Compute MST cost
        int mstCost = graph.primMST();
        System.out.println("Minimum Spanning Tree Cost: " + mstCost);

        scanner.close();
    }
}
