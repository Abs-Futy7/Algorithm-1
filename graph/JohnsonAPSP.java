import java.util.*;

// Johnson's Algorithm for All-Pairs Shortest Paths (APSP)
public class JohnsonAPSP {
    private final int INF = (int) 1e9; // A large value representing infinity

    // Edge class to represent a directed edge with weight
    class Edge {
        int u, v, weight;
        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    private int nodes; // Number of nodes in the graph
    private List<Edge> edges; // List of all edges
    private List<List<int[]>> adj; // Adjacency list for Dijkstra (after reweighting)
    private int[][] dist; // Resulting shortest path distances

    // Constructor: Reads the graph and runs Johnson's algorithm
    public JohnsonAPSP(int nodes, int edgeCount, Scanner scanner) {
        this.nodes = nodes;
        edges = new ArrayList<>();
        adj = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            adj.add(new ArrayList<>());
        }

        // Read all edges from input
        for (int i = 0; i < edgeCount; i++) {
            int u = scanner.nextInt() - 1; // Convert to 0-based index
            int v = scanner.nextInt() - 1;
            int weight = scanner.nextInt();
            addEdge(u, v, weight);
        }

        // Run Johnson's algorithm and print result if successful
        if (runJohnson()) {
            printAllPairsShortestPaths();
        }
    }

    // Add an edge to the edge list
    private void addEdge(int u, int v, int weight) {
        edges.add(new Edge(u, v, weight));
    }

    // Bellman-Ford algorithm to compute vertex potentials (h)
    // Returns false if a negative cycle is detected
    private boolean bellmanFord(int[] h) {
        Arrays.fill(h, INF); // Initialize all distances to INF
        h[nodes] = 0; // Extra node's distance is 0

        // Add extra node (nodes) with 0-weight edges to all nodes
        for (int i = 0; i < nodes; i++) {
            edges.add(new Edge(nodes, i, 0));
        }

        // Relax all edges (nodes + 1) times
        for (int i = 0; i <= nodes; i++) {
            for (Edge e : edges) {
                if (h[e.u] < INF && h[e.u] + e.weight < h[e.v]) {
                    h[e.v] = h[e.u] + e.weight;
                }
            }
        }

        // Check for negative-weight cycles
        for (Edge e : edges) {
            if (h[e.u] + e.weight < h[e.v]) return false;
        }

        // Remove the extra edges added for Bellman-Ford
        for (int i = 0; i < nodes; i++) {
            edges.remove(edges.size() - 1);
        }

        return true;
    }

    // Dijkstra's algorithm from a source node, using reweighted edges
    private void dijkstra(int src, int[] h, int[] result) {
        Arrays.fill(result, INF); // Initialize distances to INF
        result[src] = 0;

        // Min-heap priority queue: [node, distance]
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int d = curr[1];

            if (d > result[u]) continue; // Skip if already found a better path

            // Traverse all neighbors
            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int w = neighbor[1];
                if (result[u] + w < result[v]) {
                    result[v] = result[u] + w;
                    pq.add(new int[]{v, result[v]});
                }
            }
        }

        // Adjust distances back to original weights
        for (int i = 0; i < nodes; i++) {
            if (result[i] < INF) {
                result[i] = result[i] - h[src] + h[i];
            }
        }
    }

    // Main function to run Johnson's algorithm
    private boolean runJohnson() {
        int[] h = new int[nodes + 1]; // Potentials for reweighting

        // Step 1: Run Bellman-Ford to get h[]
        if (!bellmanFord(h)) {
            System.out.println("Negative weight cycle detected!");
            return false;
        }

        // Step 2: Reweight all edges and build adjacency list for Dijkstra
        for (Edge e : edges) {
            int newWeight = e.weight + h[e.u] - h[e.v];
            adj.get(e.u).add(new int[]{e.v, newWeight});
        }

        // Step 3: Run Dijkstra from each node
        dist = new int[nodes][nodes];
        for (int i = 0; i < nodes; i++) {
            dijkstra(i, h, dist[i]);
        }

        return true;
    }

    // Print the all-pairs shortest path matrix
    private void printAllPairsShortestPaths() {
        System.out.println("All-Pairs Shortest Paths:");
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    // Main entry point: reads input and runs the algorithm
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nodes = scanner.nextInt(); // Number of nodes
        int edges = scanner.nextInt(); // Number of edges
        new JohnsonAPSP(nodes, edges, scanner); // Build and solve
        scanner.close();
    }
}
