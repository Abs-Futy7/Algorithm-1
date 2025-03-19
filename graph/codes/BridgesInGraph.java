import java.util.*;

public class BridgesInGraph {
    List<Integer>[] g; // Adjacency list
    int[] disc; // Discovery time of each node
    int[] low; // Lowest discovery time reachable from the node
    boolean[] visited; // To track visited nodes
    List<int[]> bridges; // List to store bridge edges
    int time; // Time counter for discovery

    // Constructor to initialize the graph
    BridgesInGraph(int nodeCount) {
        g = new ArrayList[nodeCount + 1];
        disc = new int[nodeCount + 1];
        low = new int[nodeCount + 1];
        visited = new boolean[nodeCount + 1];
        bridges = new ArrayList<>();
        time = 0;

        // Initialize adjacency lists
        for (int i = 1; i <= nodeCount; i++) {
            g[i] = new ArrayList<>();
        }
    }

    // Add an edge (undirected)
    void addEdge(int x, int y) {
        g[x].add(y);
        g[y].add(x);
    }

    // DFS to find bridges
    void dfs(int node, int parent) {
        visited[node] = true;
        disc[node] = low[node] = ++time; // Set discovery and low values

        for (int child : g[node]) {
            if (child == parent) continue; // Skip parent edge

            if (!visited[child]) {
                dfs(child, node); // Recur for the child node
                low[node] = Math.min(low[node], low[child]); // Update low-link value

                // If no back edge found, it is a bridge
                if (low[child] > disc[node]) {
                    bridges.add(new int[]{node, child});
                }
            } else {
                // Back edge (update low-link value)
                low[node] = Math.min(low[node], disc[child]);
            }
        }
    }

    // Function to find all bridges
    void findBridges(int nodeCount) {
        Arrays.fill(visited, false);
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);

        for (int i = 1; i <= nodeCount; i++) {
            if (!visited[i]) {
                dfs(i, -1);
            }
        }
    }

    // Print all bridges
    void printBridges() {
        System.out.println("Bridges in the graph:");
        for (int[] bridge : bridges) {
            System.out.println(bridge[0] + " - " + bridge[1]);
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read number of nodes and edges
        int node = scanner.nextInt();
        int edge = scanner.nextInt();

        // Create BridgesInGraph instance
        BridgesInGraph graph = new BridgesInGraph(node);

        // Read edges (Undirected Graph)
        for (int i = 0; i < edge; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            graph.addEdge(x, y);
        }

        // Find Bridges
        graph.findBridges(node);

        // Print Bridges
        graph.printBridges();

        scanner.close();
    }
}

