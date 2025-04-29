
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class A{
    private List<Integer>[] g;
    private int nodeCnt;
    private int[] disc, low, parent;
    private boolean[] ap, visited;
    private int time;


    public A(int nodeCnt){
        this.nodeCnt = nodeCnt;
        g = new ArrayList[nodeCnt + 1];
        for(int i = 0 ; i <= nodeCnt ; i++){
            g[i] = new  ArrayList<>();
        }

        disc = new int[nodeCnt + 1];
        low = new int[nodeCnt + 1];
        parent = new int[nodeCnt + 1];
        visited = new boolean[nodeCnt + 1];
        ap = new boolean[nodeCnt + 1];

        Arrays.fill(parent, -1);
    }


    public void addEdge(int x, int y){
        g[x].add(y);
        g[y].add(x);
    }

    public void findAPs(){
        time = 0;
        for(int i = 0 ; i <= nodeCnt ; i++){
            if(!visited[i]){
                dfs(i);
            }
        }

        System.out.println("Ap Points:");
        boolean found = false;


        for(int i = 0; i <= nodeCnt ; i++){
            if(ap[i]){
                System.out.print(i + " ");
                found = true;
            }
        }

        if(!found){
            System.out.println("None");
        }
        else{
            System.out.println();
        }
    }

    public void dfs(int node){
        visited[node] = true;
        disc[node] = low[node] = ++time;

        int childCnt = 0;

        for(int neighbor : g[node]){
            if(!visited[neighbor]){
                parent[neighbor] = node;
                childCnt++;
                dfs(neighbor);

                low[node] = Math.min(low[node], low[neighbor]);

                if(parent[node] == -1 && childCnt > 1){
                    ap[node] = true;
                }

                if(parent[node] != -1 && low[neighbor] >= disc[node]){
                    ap[node] = true;
                }
                
                
            }
            else if(neighbor != parent[node]){
                low[node] = Math.min(low[node], disc[neighbor]);
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int node = sc.nextInt();
        int edge = sc.nextInt();

        A graph = new A(node);

        for(int i = 0 ; i < edge ; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph.addEdge(x, y);
        }

        graph.findAPs();
        sc.close();
    }
}