import java.util.*;  // Import Java utilities (List, Scanner, Stack, etc.)
import java.io.*;    // Import for File and IOException handling

// Define the Graph class
class Graph {

    private int vertices;                    // Total number of vertices
    private List<List<Integer>> adjList;     // Adjacency list to represent graph
    public boolean isOneBased;               // Flag: true if graph uses 1-based indexing
    private int size;                        // Size of the adjList (may be vertices+1 for 1-based)

    // Constructor that reads graph from a file
    public Graph(String filename) throws IOException {

        File file = new File(filename);      // Load file
        Scanner sc = new Scanner(file);      // Create Scanner to read the file

        int tempVertices = sc.nextInt();     // Read number of vertices
        int edges = sc.nextInt();            // Read number of edges

        List<int[]> tempEdges = new ArrayList<>(); // Temporarily store edges to process later

        boolean oneBased = true;             // Assume it's 1-based unless we find a 0

        // Read all edges and determine if graph is 1-based or 0-based
        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();            // Source vertex
            int v = sc.nextInt();            // Destination vertex
            tempEdges.add(new int[]{u, v});  // Save the edge for later use

            if (u == 0 || v == 0) {
                oneBased = false;            // If any vertex is 0, it's 0-based
            }
        }

        sc.close();                          // Close the scanner after reading

        this.vertices = tempVertices;        // Assign vertex count to class variable
        this.isOneBased = oneBased;          // Store whether graph is 1-based or not
        this.size = isOneBased ? vertices + 1 : vertices;  // Size of adjList depends on indexing

        // Initialize adjacency list with empty lists
        adjList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            adjList.add(new ArrayList<>());
        }

        // Add the edges to the graph
        for (int[] edge : tempEdges) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);           // Add edge from u to v
        }
    }

    // Add 'n' new empty vertices to the graph
    public void addVertex(int n) {
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
            vertices++;
            size++;
        }
    }

    // Add an edge from u to v
    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
    }

    // Get total number of vertices
    public int getVertexCount() {
        return vertices;
    }

    // Get all vertices connected to vertex u
    public List<Integer> getAdjVertices(int u) {
        return adjList.get(u);
    }

    // Display the graph as an adjacency list
    public void displayGraph() {
        int start = isOneBased ? 1 : 0;       // Start from 1 if 1-based, else from 0

        for (int i = start; i < size; i++) {
            System.out.print(i + " -> ");     // Print vertex number
            for (int neighbor : adjList.get(i)) {
                System.out.print(neighbor + " ");  // Print all neighbors of vertex i
            }
            System.out.println();
        }
    }

    // Perform DFS (Depth First Search) from a given start vertex
    public void DFS(int start) {
        boolean[] visited = new boolean[size]; // Track visited nodes

        System.out.print("DFS from " + start + ": ");
        dfsUtil(start, visited);               // Start DFS recursion
        System.out.println();
    }

    // Recursive DFS utility function
    private void dfsUtil(int v, boolean[] visited) {
        visited[v] = true;                     // Mark current node as visited
        System.out.print(v + " ");             // Print visited node

        // Visit all unvisited neighbors
        for (int u : adjList.get(v)) {
            if (!visited[u]) {
                dfsUtil(u, visited);
            }
        }
    }

    // Perform Topological Sort and return the sorted list
    public List<Integer> topologicalSort() {
        boolean[] visited = new boolean[size]; // Track visited nodes
        Stack<Integer> stack = new Stack<>();  // Stack to store the topological order

        int start = isOneBased ? 1 : 0;

        // Visit all vertices
        for (int i = start; i < size; i++) {
            if (!visited[i]) {
                topoSortUtil(i, visited, stack);
            }
        }

        // Pop from stack to get the correct order
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    // Recursive helper for Topological Sort
    private void topoSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;

        for (int u : adjList.get(v)) {
            if (!visited[u]) {
                topoSortUtil(u, visited, stack);
            }
        }

        stack.push(v); // Push current vertex to stack after visiting all neighbors
    }
}


public class Lab2 {

    public static void main(String[] args) throws IOException {

        // Create graph from input file
        Graph graph = new Graph("input.txt");

        // Print adjacency list
        System.out.println("Graph adjacency list:");
        graph.displayGraph();

        // Perform DFS
        System.out.println("\nPerforming DFS starting from vertex 5:");
        graph.DFS(5);

        // Perform Topological Sort
        System.out.println("\nPerforming Topological Sort:");
        List<Integer> topoOrder = graph.topologicalSort();
        System.out.println("Topological Sort order: " + topoOrder);
    }
}
