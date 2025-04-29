import java.util.*;
@SuppressWarnings("unchecked")

public class mainSCC {
    List<Integer>[] g;
    List<Integer>[] rg;
    boolean[] visited;
    Stack<Integer> stack;
    List<List<Integer>> sccList;
    int[] componentId;
    boolean[] hasOutgoing;

    mainSCC(int nodeCount) {
        g = new ArrayList[nodeCount + 1];
        rg = new ArrayList[nodeCount + 1];
        visited = new boolean[nodeCount + 1];
        stack = new Stack<>();
        sccList = new ArrayList<>();
        componentId = new int[nodeCount + 1];
        
        for (int i = 1; i <= nodeCount; i++) {
            g[i] = new ArrayList<>();
            rg[i] = new ArrayList<>();
        }
    }

    public void addEdge(int x, int y) {
        g[x].add(y);
        rg[y].add(x);
    }

    private void dfs1(int node) {
        visited[node] = true;
        for (int child : g[node]) {
            if (!visited[child]) {
                dfs1(child);
            }
        }
        stack.push(node);
    }

    private void dfs2(int node, List<Integer> component) {
        visited[node] = true;
        component.add(node);
        for (int child : rg[node]) {
            if (!visited[child]) {
                dfs2(child, component);
            }
        }
    }

    public void findSCCs(int nodeCount) {
        Arrays.fill(visited, false);
        for (int i = 1; i <= nodeCount; i++) {
            if (!visited[i]) {
                dfs1(i);
            }
        }

        Arrays.fill(visited, false);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                List<Integer> component = new ArrayList<>();
                dfs2(node, component);
                sccList.add(component);
            }
        }
    }

    public void printCapitalCandidates() {
        // Map nodes to their component IDs
        for (int i = 0; i < sccList.size(); i++) {
            for (int node : sccList.get(i)) {
                componentId[node] = i;
            }
        }

        // Check for outgoing edges between components
        hasOutgoing = new boolean[sccList.size()];
        for (int u = 1; u < g.length; u++) {
            for (int v : g[u]) {
                if (componentId[u] != componentId[v]) {
                    hasOutgoing[componentId[u]] = true;
                }
            }
        }

        // Find sink components (no outgoing edges)
        List<Integer> sinkComponents = new ArrayList<>();
        for (int i = 0; i < hasOutgoing.length; i++) {
            if (!hasOutgoing[i]) {
                sinkComponents.add(i);
            }
        }

        // If there's exactly one sink component, it's our candidate
        if (sinkComponents.size() == 1) {
            List<Integer> candidates = sccList.get(sinkComponents.get(0));
            Collections.sort(candidates);
            System.out.println(candidates.size());
            for (int city : candidates) {
                System.out.print(city + " ");
            }
        } else {
            System.out.println(0);
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int node = scanner.nextInt();
            int edge = scanner.nextInt();
            
            mainSCC graph = new mainSCC(node);
            
            for (int i = 0; i < edge; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                graph.addEdge(x, y);
            }
            
            graph.findSCCs(node);
            graph.printCapitalCandidates();
        }
    }
}
