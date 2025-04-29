import java.util.*;

public class ArticulationPoints {
    List<Integer>[] g; // Adjacency list for the graph
    int nodeCount; // Number of nodes
    int[] disc, low, parent; // Discovery time, Low value, Parent tracking
    boolean[] visited, ap; // Visited array and Articulation Point tracker
    int time; // Timer for discovery time tracking

    // Constructor to initialize the graph
    
    
    ArticulationPoints(int nodeCount) {
        this.nodeCount = nodeCount;
        g = new ArrayList[nodeCount + 1]; // Create an adjacency list

        // Initialize adjacency list for each node
        for (int i = 0; i <= nodeCount; i++) {  // Fix: Include index 0 for 0-based graphs
            g[i] = new ArrayList<>();
        }

        // Initialize arrays
        disc = new int[nodeCount + 1];
        low = new int[nodeCount + 1];
        parent = new int[nodeCount + 1];
        visited = new boolean[nodeCount + 1];
        ap = new boolean[nodeCount + 1];

        Arrays.fill(parent, -1); // Initialize parents as -1 (root has no parent)
    }

    // Add an undirected edge
    void addEdge(int x, int y) {
        g[x].add(y);
        g[y].add(x);
    }

    // DFS function to find articulation points
    void dfs(int node) {
        visited[node] = true;
        disc[node] = low[node] = ++time; // Set discovery and low time
        int childCount = 0; // Track number of DFS tree children

        for (int neighbor : g[node]) {
            if (!visited[neighbor]) { // If the neighbor is unvisited
                parent[neighbor] = node;
                childCount++;
                dfs(neighbor);

                // Update low value
                low[node] = Math.min(low[node], low[neighbor]);

                // Condition 1: Root node with more than 1 child is an articulation point
                if (parent[node] == -1 && childCount > 1) {
                    ap[node] = true;
                }

                // Condition 2: Non-root node whose child cannot reach an ancestor
                if (parent[node] != -1 && low[neighbor] >= disc[node]) {
                    ap[node] = true;
                }
            } else if (neighbor != parent[node]) {
                // If neighbor is visited and is not the parent, update low[]
                low[node] = Math.min(low[node], disc[neighbor]);
            }
        }
    }

    // Function to find all articulation points
    public void findArticulationPoints() {
        time = 0; // Reset global time counter

        // Run DFS from every unvisited node (for disconnected graphs)
        for (int i = 0; i <= nodeCount; i++) { // Fix: Include index 0 for 0-based graphs
            if (!visited[i]) {
                dfs(i);
            }
        }

        // Print articulation points
        System.out.println("Articulation Points:");
        boolean found = false;
        for (int i = 0; i <= nodeCount; i++) { // Fix: Include index 0 for 0-based graphs
            if (ap[i]) {
                System.out.print(i + " ");
                found = true;
            }
        }
        if (!found) {
            System.out.println("None");
        } else {
            System.out.println();
        }
    }

    // Main function to take input and run the algorithm
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read number of nodes and edges
        int node = scanner.nextInt();
        int edge = scanner.nextInt();

        // Create graph
        ArticulationPoints graph = new ArticulationPoints(node);

        // Read edges
        for (int i = 0; i < edge; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            graph.addEdge(x, y);
        }

        // Find and print articulation points
        graph.findArticulationPoints();

        scanner.close();
    }
}
