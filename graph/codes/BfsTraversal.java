import java.util.*;

public class BfsTraversal {

    private int nodes;
    private List<List<Integer>> adjList;
    private List<Integer> bfsOrder;
    private boolean[] visited;
    private Queue<Integer> queue;

    // Constructor
    public BfsTraversal(int nodes) {
        this.nodes = nodes;
        adjList = new ArrayList<>();
        bfsOrder = new ArrayList<>();
        visited = new boolean[nodes];
        queue = new LinkedList<>();

        for (int i = 0; i < nodes; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Add edge to the graph
    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    // BFS from a given start node
    public void bfs(int start) {
        // Reset state before BFS
        Arrays.fill(visited, false);
        queue.clear();
        bfsOrder.clear();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            bfsOrder.add(current);

            for (int neighbor : adjList.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    // Print BFS traversal
    public void printTraversal() {
        System.out.print("BFS Traversal: ");
        for (int node : bfsOrder) {
            System.out.print(node + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of edges and nodes:");
        int edge = sc.nextInt();
        int node = sc.nextInt();

        BfsTraversal obj = new BfsTraversal(node);

        System.out.println("Enter edges (u v):");
        for (int i = 0; i < edge; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            obj.addEdge(u, v);
        }

        System.out.print("Enter starting node for BFS: ");
        int start = sc.nextInt();

        obj.bfs(start);
        obj.printTraversal();
    }
}
