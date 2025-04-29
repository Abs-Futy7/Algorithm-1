
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B {
    private List<Integer>[] g;
    private int[] disc, low;
    private boolean[] visited;
    private int time;
    private List<int[]> bridges;

    public B(int nodeCnt){
        g = new ArrayList[nodeCnt + 1];
        disc = new int[nodeCnt + 1];
        low = new int[nodeCnt + 1];
        visited = new boolean[nodeCnt + 1];
        bridges = new ArrayList<>();
        time = 0;

        for(int i = 1 ; i <= nodeCnt ; i++){
            g[i] = new ArrayList<>();
        }
    }

    public void addEdge(int x, int y){
        g[x].add(y);
        g[y].add(x);
    }

    public void findBridges(int nodeCnt){
        Arrays.fill(visited, false);
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);

        for(int i =  1 ; i <= nodeCnt ; i++){
            if(!visited[i]){
                dfs(i, -1);
            }
        }
    }

    public void printBridges(){
        System.out.println("Bridges in the graph:");
        for(int[] bridge : bridges){
            System.out.println(bridge[0] + " - " + bridge[1]);
        }
    }

    public void dfs(int node, int parent){
        visited[node] = true;
        disc[node] = low[node] = ++time;

        for(int child : g[node]){
            if(child == parent) continue;
            
            if(!visited[child]){
                dfs(child, node);
                low[node] = Math.min(low[node], low[child]);

                if(low[child] > disc[node]){
                    bridges.add(new int[]{node, child});
                }
            }

            else{
                low[node] = Math.min(low[node], disc[child]);
            }
        }
    }

}
