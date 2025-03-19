import java.util.*;

public class BellmanFordAlgorithm {
    
    // Function to perform Bellman-Ford Algorithm
    static int[] bellmanFord(int V, int[][] edges, int src) {
        
        // Step 1: Initialize distances from source to all vertices as infinite
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e8); // Setting initial distances to a large value
        dist[src] = 0; // Distance to the source itself is 0

        // Step 2: Relax all edges V - 1 times
        for (int i = 0; i < V - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1], wt = edge[2];

                // If the current distance to 'u' is not infinite and a shorter path exists
                if (dist[u] != (int) 1e8 && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        // Step 3: Check for negative weight cycles (One extra relaxation step)
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];

            // If another relaxation is possible, then a negative weight cycle exists
            if (dist[u] != (int) 1e8 && dist[u] + wt < dist[v]) {
                return new int[]{-1}; // Indicating a negative cycle
            }
        }

        return dist; // Returning shortest distances
    }

    // Driver function to test the implementation
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read number of vertices and edges
        int V = scanner.nextInt();
        int E = scanner.nextInt();

        // Read edges
        int[][] edges = new int[E][3];
        for (int i = 0; i < E; i++) {
            edges[i][0] = scanner.nextInt(); // From node
            edges[i][1] = scanner.nextInt(); // To node
            edges[i][2] = scanner.nextInt(); // Weight
        }

        // Read the source node
        int src = scanner.nextInt();

        // Run Bellman-Ford Algorithm
        int[] result = bellmanFord(V, edges, src);

        // Print the shortest distances or detect a negative cycle
        if (result.length == 1 && result[0] == -1) {
            System.out.println("Graph contains a negative weight cycle!");
        } else {
            System.out.println("Shortest distances from node " + src + ":");
            for (int i = 0; i < V; i++) {
                System.out.println("Node " + i + " -> " + (result[i] == (int) 1e8 ? "INF" : result[i]));
            }
        }

        scanner.close();
    }
}
