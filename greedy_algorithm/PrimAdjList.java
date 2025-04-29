import java.util.*;

public class PrimAdjList {
    List<List<int[]>> graph; // Adjacency list (stores pairs [neighbor, weight])
    int nodeCount; // Number of nodes
    boolean[] visited; // Track included nodes
    PriorityQueue<int[]> pq; // Min-heap for edges [targetNode, weight]

    // Constructor to initialize the graph, visited array, and priority queue
    PrimAdjList(int nodeCount) {
        this.nodeCount = nodeCount;
        graph = new ArrayList<>();
        visited = new boolean[nodeCount]; // Initialize visited array
        pq = new PriorityQueue<>(Comparator.comparingInt(e -> e[1])); // Initialize priority queue

        // Initialize the adjacency list for each node
        for (int i = 0; i < nodeCount; i++) {
            graph.add(new ArrayList<>()); // Create an empty list for each node
        }
    }

    // Add an edge to the graph (undirected)
    void addEdge(int u, int v, int weight) {
        graph.get(u).add(new int[]{v, weight}); // Add edge u -> v with weight
        graph.get(v).add(new int[]{u, weight}); // Add edge v -> u with weight
    }

    // Function to find the Minimum Spanning Tree using Prim's Algorithm
    int primMST() {
        int totalCost = 0;

        // Start from node 0
        pq.add(new int[]{0, 0}); // Start with node 0 and weight 0

        while (!pq.isEmpty()) {
            int[] current = pq.poll(); // Get edge with the smallest weight
            int node = current[0];
            int weight = current[1];

            if (visited[node]) {
                continue; // Skip if node is already visited
            }

            visited[node] = true; // Mark node as visited
            totalCost += weight; // Add edge weight to MST cost

            // Add all unvisited neighbors of the current node to the priority queue
            for (int[] neighbor : graph.get(node)) {
                int target = neighbor[0];
                int edgeWeight = neighbor[1];

                if (!visited[target]) {
                    pq.add(new int[]{target, edgeWeight});
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
        PrimAdjList graph = new PrimAdjList(node);

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