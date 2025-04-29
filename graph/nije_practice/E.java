
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E {
    List<Integer>[] g;
    int nodeCnt;
    int[] disc, low, parent;
    boolean[] visited, ap;
    int time;

    E(int nodeCnt){
        this.nodeCnt = nodeCnt;
        g = new ArrayList[nodeCnt + 1];

        for(int i = 0 ; i < nodeCnt ; i++){
            g[i] = new ArrayList<>();
        }

        disc = new int[nodeCnt + 1];
        low = new int[nodeCnt + 1];
        parent = new int[nodeCnt + 1];
        visited = new boolean[nodeCnt + 1];
        ap = new boolean[nodeCnt + 1];

        Arrays.fill(parent, -1);
    }

    void addEdge(int u, int v){
        g[v].add(u);
        g[u].add(v);

    }

    void dfs(int node){
        visited[node] = true;
        disc[node] = low[node] = ++time;

        int childCnt = 0;

        for(int neighbour : g[node]){
            if(!visited[neighbour]){
                parent[neighbour] = node;
                childCnt++;
                dfs(neighbour);


                low[node] = Math.min(low[node], low[neighbour]);

                if(parent[node] == -1 && childCnt > 1){
                    ap[node] = true;
                }

                if(parent[node] != -1 && low[neighbour] >= disc[node]){
                    ap[node] = true;
                }
            }
            else if (neighbour != parent[node]) {
                low[node] = Math.min(low[node], disc[neighbour]);
            }
        }
    }

    void findAps(){
        time = 0;

        for(int i = 0; i <= nodeCnt ; i++){
            if(!visited[i]){
                dfs(i);
            }
        }

        System.out.println("Apps: ");
        boolean found = false;

        for(int i = 0 ; i <= nodeCnt ; i++){
            if(ap[i]){
                System.out.println(i + " ");
                found = true;
            }
        }

        if(!found) System.out.println("Node");
        else System.out.println();
    }

    public static void main(String[] args) {
        
    }
}
