import java.util.*;

public class EulerianPathCircuit {
    List<Integer>[] g; // Adjacency list
    int nodeCount; // Number of nodes

    // Constructor to initialize the graph
    EulerianPathCircuit(int nodeCount) {
        this.nodeCount = nodeCount;
        g = new ArrayList[nodeCount + 1];

        // Initialize adjacency list
        for (int i = 1; i <= nodeCount; i++) {
            g[i] = new ArrayList<>();
        }
    }

    // Add an undirected edge
    void addEdge(int x, int y) {
        g[x].add(y);
        g[y].add(x);
    }

    // Function to check if graph is connected (ignoring isolated nodes)
    boolean isConnected() {

        boolean[] visited = new boolean[nodeCount + 1];
        int startNode = -1;

        // Find first node with edges (non-isolated)
        for (int i = 1; i <= nodeCount; i++) {
            if (!g[i].isEmpty()) {
                startNode = i;
                break;
            }
        }

        // If no edges exist, the graph is Eulerian
        if (startNode == -1) return true;

        // Perform DFS to check connectivity
        dfs(startNode, visited);

        // Ensure all non-isolated nodes are visited
        for (int i = 1; i <= nodeCount; i++) {
            if (!visited[i] && !g[i].isEmpty()) return false;
        }
        return true;
    }

    // DFS for connectivity check
    void dfs(int node, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : g[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited);
            }
        }
    }

    // Function to check for Eulerian Path or Circuit
    void checkEulerian() {
        if (!isConnected()) {
            System.out.println("Graph is not Eulerian (Disconnected)");
            return;
        }

        int oddDegreeCount = 0;
        for (int i = 1; i <= nodeCount; i++) {
            if (g[i].size() % 2 == 1) oddDegreeCount++;
        }

        if (oddDegreeCount == 0) {
            System.out.println("Graph has an Eulerian Circuit");
        } else if (oddDegreeCount == 2) {
            System.out.println("Graph has an Eulerian Path");
        } else {
            System.out.println("Graph is not Eulerian");
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read number of nodes and edges
        int node = scanner.nextInt();
        int edge = scanner.nextInt();

        // Create graph
        EulerianPathCircuit graph = new EulerianPathCircuit(node);

        // Read edges
        for (int i = 0; i < edge; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            graph.addEdge(x, y);
        }

        // Check for Eulerian Path or Circuit
        graph.checkEulerian();

        scanner.close();
    }
}
