import java.util.*;

public class DijkstraAlgorithm {
    List<int[]>[] g; // Adjacency list storing (neighbor, weight)
    int nodeCount; // Number of nodes
    int[] dist; // Stores shortest distances from the source

    // Constructor to initialize the graph
    DijkstraAlgorithm(int nodeCount) {
        this.nodeCount = nodeCount;
        g = new ArrayList[nodeCount]; // Adjust for 0-based indexing

        for (int i = 0; i < nodeCount; i++) {
            g[i] = new ArrayList<>();
        }

        dist = new int[nodeCount];
        Arrays.fill(dist, Integer.MAX_VALUE); // Set all distances to infinity
    }

    // Add a weighted edge to the graph
    void addEdge(int x, int y, int weight) {
        g[x].add(new int[]{y, weight});
        g[y].add(new int[]{x, weight}); // For undirected graphs
    }

    // Dijkstra’s Algorithm using a PriorityQueue (Min-Heap)
    void dijkstra(int src) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); // Min-Heap
        pq.add(new int[]{src, 0});
        dist[src] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0], d = curr[1];

            // If the current distance is greater than the stored one, it's an outdated entry in pq
            if (d > dist[node]) continue;

            for (int[] neighbor : g[node]) {
                int nextNode = neighbor[0], weight = neighbor[1];

                if (dist[node] + weight < dist[nextNode]) {
                    dist[nextNode] = dist[node] + weight;
                    pq.add(new int[]{nextNode, dist[nextNode]});
                }
            }
        }
    }

    // Function to print shortest distances
    void printDistances(int src) {
        System.out.println("Shortest distances from node " + src + ":");
        for (int i = 0; i < nodeCount; i++) {
            System.out.println("Node " + i + " -> " + (dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]));
        }
    }

    // Main function to take input and run Dijkstra’s Algorithm
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read number of nodes and edges
        int node = scanner.nextInt();
        int edge = scanner.nextInt();

        // Create the graph
        DijkstraAlgorithm graph = new DijkstraAlgorithm(node);

        // Read edges
        for (int i = 0; i < edge; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int weight = scanner.nextInt();
            graph.addEdge(x, y, weight);
        }

        // Read source node
        int src = scanner.nextInt();

        // Run Dijkstra's Algorithm
        graph.dijkstra(src);

        // Print shortest distances
        graph.printDistances(src);

        scanner.close();
    }
}
