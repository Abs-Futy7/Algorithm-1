import java.util.*;
@SuppressWarnings("unchecked")


public class KosarajuSCC {

    List<Integer>[] g;  // Adjacency list for the original graph
    List<Integer>[] rg; // Reverse graph
    boolean[] visited;  // Visited array for DFS
    Stack<Integer> stack; // Stack to store finishing times
    List<List<Integer>> sccList; // List to store SCCs

    // Constructor to initialize the graph
    
    KosarajuSCC(int nodeCount) {

        g = new ArrayList[nodeCount + 1];
        rg = new ArrayList[nodeCount + 1];
        visited = new boolean[nodeCount + 1];
        stack = new Stack<>();
        sccList = new ArrayList<>();

        // Initialize adjacency lists
        for (int i = 1; i <= nodeCount; i++) {
            g[i] = new ArrayList<>();
            rg[i] = new ArrayList<>();
        }
    }

    // Add a directed edge (X → Y)
    public void addEdge(int x, int y) {
        g[x].add(y);  // Original graph edge
        rg[y].add(x); // Reverse graph edge
    }

    // First DFS to fill stack with nodes in order of completion time
    private void dfs1(int node) {
        visited[node] = true;
        for (int child : g[node]) {
            if (!visited[child]) {
                dfs1(child);
            }
        }
        stack.push(node); // Store node after visiting all its neighbors
    }

    // Second DFS to explore the reversed graph and find SCCs
    private void dfs2(int node, List<Integer> component) {
        visited[node] = true;
        component.add(node); // Add node to current SCC

        for (int child : rg[node]) {
            if (!visited[child]) {
                dfs2(child, component);
            }
        }
    }

    // Function to find all SCCs
    public void findSCCs(int nodeCount) {
        // Step 1: First DFS pass on the original graph to fill the stack
        Arrays.fill(visited, false); // Reset visited array
        for (int i = 1; i <= nodeCount; i++) {
            if (!visited[i]) {
                dfs1(i);
            }
        }

        // Step 2: Process nodes in reverse finishing order (on reversed graph)
        Arrays.fill(visited, false); // Reset visited array for second DFS

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                List<Integer> component = new ArrayList<>();
                dfs2(node, component);
                sccList.add(component); // Store this SCC
            }
        }
    }

    // Print SCCs
    public void printSCCs() {
        System.out.println("Strongly Connected Components:");
        for (List<Integer> scc : sccList) {
            System.out.println(scc);
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read number of nodes and edges
        int node = scanner.nextInt();
        int edge = scanner.nextInt();

        // Create KosarajuSCC instance
        KosarajuSCC graph = new KosarajuSCC(node);

        // Read edges (Directed Graph)
        for (int i = 0; i < edge; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            graph.addEdge(x, y);
        }

        // Find Strongly Connected Components
        graph.findSCCs(node);

        // Print SCCs
        graph.printSCCs();

        scanner.close(); // Close scanner
    }
}
